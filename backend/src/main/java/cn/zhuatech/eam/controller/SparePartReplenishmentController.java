/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
package cn.zhuatech.eam.controller;

import cn.zhuatech.eam.common.ApiResponse;
import cn.zhuatech.eam.service.SparePartReplenishmentService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/eam/insights")
public class SparePartReplenishmentController {
    private final SparePartReplenishmentService service;
    public SparePartReplenishmentController(SparePartReplenishmentService service) { this.service = service; }

    @PostMapping("/spare-part-replenishment")
    public ApiResponse<SparePartReplenishmentService.Result> recommend(
        @Valid @RequestBody SparePartReplenishmentService.Request request) {
        return ApiResponse.ok(service.recommend(request));
    }
}
