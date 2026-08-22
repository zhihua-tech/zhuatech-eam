/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
package cn.zhuatech.eam.controller;

import cn.zhuatech.eam.common.ApiResponse;
import cn.zhuatech.eam.service.MaintenanceWindowDecisionService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/eam/insights")
public class MaintenanceWindowController {
    private final MaintenanceWindowDecisionService service;

    public MaintenanceWindowController(MaintenanceWindowDecisionService service) {
        this.service = service;
    }

    @PostMapping("/maintenance-window")
    public ApiResponse<MaintenanceWindowDecisionService.Result> evaluate(
        @Valid @RequestBody MaintenanceWindowDecisionService.Request request) {
        return ApiResponse.ok(service.evaluate(request));
    }
}
