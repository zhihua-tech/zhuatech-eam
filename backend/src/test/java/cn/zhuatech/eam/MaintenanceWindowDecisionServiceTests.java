/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
package cn.zhuatech.eam;

import cn.zhuatech.eam.service.MaintenanceWindowDecisionService;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MaintenanceWindowDecisionServiceTests {
    private final MaintenanceWindowDecisionService service = new MaintenanceWindowDecisionService();

    @Test
    void executesReadyMaintenanceWhenFailureExposureIsHigher() {
        var result = service.evaluate(new MaintenanceWindowDecisionService.Request(
            "ASSET-CNC-01", 5, new BigDecimal("0.40"), 4, 6, true, true,
            new BigDecimal("5000"), new BigDecimal("100000")));

        assertEquals(new BigDecimal("40000.00"), result.failureExposure());
        assertEquals(new BigDecimal("20000.00"), result.plannedInterruptionLoss());
        assertEquals("EXECUTE", result.decision());
    }

    @Test
    void preparesResourcesBeforeCriticalMaintenance() {
        var result = service.evaluate(new MaintenanceWindowDecisionService.Request(
            "ASSET-BOILER-02", 5, new BigDecimal("0.30"), 8, 4, false, true,
            new BigDecimal("3000"), new BigDecimal("80000")));

        assertEquals("PREPARE", result.decision());
    }
}
