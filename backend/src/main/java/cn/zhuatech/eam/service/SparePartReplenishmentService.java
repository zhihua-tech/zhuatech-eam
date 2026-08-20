/* Copyright 2026 上海如静知华信息科技有限公司 */
package cn.zhuatech.eam.service;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

@Service
public class SparePartReplenishmentService {
    public record Request(
        @DecimalMin("0.0") BigDecimal averageMonthlyConsumption,
        @Min(0) int leadTimeDays,
        @Min(1) @Max(5) int criticality,
        @DecimalMin("0.0") BigDecimal currentStock,
        @DecimalMin("0.0") BigDecimal onOrderQuantity,
        @DecimalMin("0.0") BigDecimal reservedQuantity,
        @DecimalMin("0.01") BigDecimal minimumOrderQuantity
    ) {}

    public record Result(String status, BigDecimal inventoryPosition, BigDecimal reorderPoint,
                         BigDecimal suggestedOrderQuantity, int coverageDays, List<String> actions) {}

    public Result recommend(Request request) {
        BigDecimal dailyUse = request.averageMonthlyConsumption().divide(BigDecimal.valueOf(30), 4, RoundingMode.HALF_UP);
        BigDecimal leadDemand = dailyUse.multiply(BigDecimal.valueOf(request.leadTimeDays()));
        BigDecimal safetyFactor = BigDecimal.valueOf(0.15 + request.criticality() * 0.12);
        BigDecimal reorderPoint = leadDemand.multiply(BigDecimal.ONE.add(safetyFactor)).setScale(2, RoundingMode.HALF_UP);
        BigDecimal position = request.currentStock().add(request.onOrderQuantity()).subtract(request.reservedQuantity())
            .max(BigDecimal.ZERO).setScale(2, RoundingMode.HALF_UP);
        BigDecimal shortage = reorderPoint.subtract(position).max(BigDecimal.ZERO);
        BigDecimal suggested = roundToMultiple(shortage, request.minimumOrderQuantity());
        int coverageDays = dailyUse.signum() == 0 ? 999 : position.divide(dailyUse, 0, RoundingMode.FLOOR).intValue();

        List<String> actions = new ArrayList<>();
        String status;
        if (suggested.signum() > 0 && (request.criticality() >= 4 || coverageDays <= request.leadTimeDays())) {
            status = "ORDER_NOW";
            actions.add("按最小订购批量立即创建补货申请");
        } else if (position.compareTo(reorderPoint.multiply(BigDecimal.valueOf(1.25))) < 0) {
            status = "WATCH";
            actions.add("纳入每周备件库存巡检清单");
        } else {
            status = "ADEQUATE";
            actions.add("维持当前采购与盘点节奏");
        }
        if (request.criticality() == 5) actions.add("校验关键备件替代料和供应商交期");
        return new Result(status, position, reorderPoint, suggested, coverageDays, List.copyOf(actions));
    }

    private BigDecimal roundToMultiple(BigDecimal value, BigDecimal multiple) {
        if (value.signum() == 0) return BigDecimal.ZERO.setScale(2);
        return value.divide(multiple, 0, RoundingMode.CEILING).multiply(multiple).setScale(2, RoundingMode.HALF_UP);
    }
}
