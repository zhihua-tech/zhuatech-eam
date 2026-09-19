/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
package cn.zhuatech.eam.controller;

import cn.zhuatech.eam.common.ApiResponse;
import cn.zhuatech.eam.service.MaintenanceWindowDecisionService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
 */
@RestController
@RequestMapping("/api/eam/insights")
public class MaintenanceWindowController {
    private final MaintenanceWindowDecisionService service;

    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public MaintenanceWindowController(MaintenanceWindowDecisionService service) {
        this.service = service;
    }

    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    @PostMapping("/maintenance-window")
    public ApiResponse<MaintenanceWindowDecisionService.Result> evaluate(
        @Valid @RequestBody MaintenanceWindowDecisionService.Request request) {
        return ApiResponse.ok(service.evaluate(request));
    }
}
