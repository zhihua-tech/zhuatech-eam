/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
package cn.zhuatech.eam;

import cn.zhuatech.eam.service.SparePartReplenishmentService;
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import static org.assertj.core.api.Assertions.assertThat;

class SparePartReplenishmentServiceTests {
    private final SparePartReplenishmentService service = new SparePartReplenishmentService();

    @Test void ordersCriticalPartWithLowStock() {
        var result = service.recommend(new SparePartReplenishmentService.Request(
            bd("90"), 30, 5, bd("10"), bd("0"), bd("2"), bd("20")));
        assertThat(result.status()).isEqualTo("ORDER_NOW");
        assertThat(result.suggestedOrderQuantity()).isGreaterThanOrEqualTo(bd("20"));
    }

    @Test void keepsAdequateInventory() {
        var result = service.recommend(new SparePartReplenishmentService.Request(
            bd("30"), 10, 2, bd("80"), bd("0"), bd("0"), bd("5")));
        assertThat(result.status()).isEqualTo("ADEQUATE");
        assertThat(result.suggestedOrderQuantity()).isZero();
    }

    private BigDecimal bd(String value) { return new BigDecimal(value); }
}
