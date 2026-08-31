/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
package cn.zhuatech.eam.service;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class CriticalWorkPermitGovernanceServiceTest {
    private final CriticalWorkPermitGovernanceService service = new CriticalWorkPermitGovernanceService();

    @Test void releasesPreparedCriticalWork() {
        var result = service.assess(new CriticalWorkPermitGovernanceService.Request(
                "WO-001", true, true, true, true, true, true, true, true, false));
        assertThat(result.decision()).isEqualTo(CriticalWorkPermitGovernanceService.Decision.RELEASE);
        assertThat(result.blockers()).isEmpty();
    }

    @Test void holdsUnsafeEmergencyWork() {
        var result = service.assess(new CriticalWorkPermitGovernanceService.Request(
                "WO-002", true, false, false, false, false, false, false, false, true));
        assertThat(result.decision()).isEqualTo(CriticalWorkPermitGovernanceService.Decision.HOLD);
        assertThat(result.blockers()).hasSize(5);
        assertThat(result.actions()).hasSize(3);
    }
}
