/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
package cn.zhuatech.eam.controller;

import cn.zhuatech.eam.common.ApiResponse;
import cn.zhuatech.eam.service.CriticalWorkPermitGovernanceService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/enterprise/eam")
public class CriticalWorkPermitGovernanceController {
    private final CriticalWorkPermitGovernanceService service;
    public CriticalWorkPermitGovernanceController(CriticalWorkPermitGovernanceService service) { this.service = service; }

    @PostMapping("/critical-work-permit")
    public ApiResponse<CriticalWorkPermitGovernanceService.Assessment> assess(
            @Valid @RequestBody CriticalWorkPermitGovernanceService.Request request) {
        return ApiResponse.ok("关键设备作业许可评估完成", service.assess(request));
    }
}
