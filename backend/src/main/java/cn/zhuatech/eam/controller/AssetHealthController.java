/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
package cn.zhuatech.eam.controller;

import cn.zhuatech.eam.common.ApiResponse;
import cn.zhuatech.eam.service.AssetHealthService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

/**
 * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
 */
@RestController
@RequestMapping("/api/eam")
public class AssetHealthController {
    private final AssetHealthService service;
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public AssetHealthController(AssetHealthService service) { this.service = service; }

    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    @PostMapping("/asset-health")
    public ApiResponse<AssetHealthService.Result> assess(@Valid @RequestBody AssetHealthService.Request request) {
        return ApiResponse.ok(service.assess(request));
    }
}
