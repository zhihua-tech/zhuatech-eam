/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
package cn.zhuatech.eam.service;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

@Service
public class MaintenanceWindowDecisionService {
    public Result evaluate(Request request) {
        BigDecimal failureExposure = request.expectedFailureLoss()
            .multiply(request.failureProbability()).setScale(2, RoundingMode.HALF_UP);
        BigDecimal plannedInterruptionLoss = request.productionLossPerHour()
            .multiply(BigDecimal.valueOf(request.plannedDowntimeHours())).setScale(2, RoundingMode.HALF_UP);
        boolean windowFits = request.availableWindowHours() >= request.plannedDowntimeHours();
        boolean ready = windowFits && request.spareReady() && request.technicianReady();
        boolean economicallyRequired = failureExposure.compareTo(plannedInterruptionLoss) > 0
            || request.criticality() >= 4;
        String decision = economicallyRequired && ready ? "EXECUTE"
            : economicallyRequired ? "PREPARE" : "DEFER";

        List<String> actions = new ArrayList<>();
        if (!windowFits) actions.add("申请更长停机窗口或拆分维护工序");
        if (!request.spareReady()) actions.add("锁定关键备件并确认到货时间");
        if (!request.technicianReady()) actions.add("安排具备资质的维护人员与安全交底");
        if ("EXECUTE".equals(decision)) actions.add("批准维护窗口并同步生产排程");
        if ("DEFER".equals(decision)) actions.add("延后计划并提高状态监测频率");
        return new Result(request.assetCode(), failureExposure, plannedInterruptionLoss,
            windowFits, decision, actions);
    }

    public record Request(@NotBlank String assetCode, @Min(1) @Max(5) int criticality,
                          @DecimalMin("0") @DecimalMax("1") BigDecimal failureProbability,
                          @Min(1) int plannedDowntimeHours, @Min(0) int availableWindowHours,
                          boolean spareReady, boolean technicianReady,
                          @DecimalMin("0") BigDecimal productionLossPerHour,
                          @DecimalMin("0") BigDecimal expectedFailureLoss) {}

    public record Result(String assetCode, BigDecimal failureExposure,
                         BigDecimal plannedInterruptionLoss, boolean windowFits,
                         String decision, List<String> actions) {}
}
