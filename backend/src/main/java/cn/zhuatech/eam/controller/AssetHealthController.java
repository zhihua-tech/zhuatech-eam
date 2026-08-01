/* Copyright 2026 上海如静知华信息科技有限公司 */
package cn.zhuatech.eam.controller;

import cn.zhuatech.eam.common.ApiResponse;
import cn.zhuatech.eam.service.AssetHealthService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/eam")
public class AssetHealthController {
    private final AssetHealthService service;
    public AssetHealthController(AssetHealthService service) { this.service = service; }

    @PostMapping("/asset-health")
    public ApiResponse<AssetHealthService.Result> assess(@Valid @RequestBody AssetHealthService.Request request) {
        return ApiResponse.ok(service.assess(request));
    }
}
