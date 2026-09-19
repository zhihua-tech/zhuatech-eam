/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
package cn.zhuatech.eam.controller;

import cn.zhuatech.eam.common.ApiResponse;
import cn.zhuatech.eam.service.SparePartReplenishmentService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

/**
 * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
 */
@RestController
@RequestMapping("/api/eam/insights")
public class SparePartReplenishmentController {
    private final SparePartReplenishmentService service;
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public SparePartReplenishmentController(SparePartReplenishmentService service) { this.service = service; }

    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    @PostMapping("/spare-part-replenishment")
    public ApiResponse<SparePartReplenishmentService.Result> recommend(
        @Valid @RequestBody SparePartReplenishmentService.Request request) {
        return ApiResponse.ok(service.recommend(request));
    }
}
