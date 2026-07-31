/* Copyright 2026 Shanghai Rujing Zhihua Information Technology Co., Ltd. */
package cn.zhuatech.eam.controller;
import cn.zhuatech.eam.common.ApiResponse; import cn.zhuatech.eam.dto.EamDto.*; import cn.zhuatech.eam.service.EamService; import jakarta.validation.Valid; import org.springframework.security.access.prepost.PreAuthorize; import org.springframework.web.bind.annotation.*; import java.util.List;
@RestController @RequestMapping("/api/eam") public class EamController {
    private final EamService service; public EamController(EamService service){this.service=service;}
    @GetMapping("/dashboard") public ApiResponse<Dashboard> dashboard(){return ApiResponse.ok(service.dashboard());}
    @GetMapping("/assets") public ApiResponse<List<AssetView>> assets(){return ApiResponse.ok(service.assets());}
    @GetMapping("/spare-parts") public ApiResponse<List<SparePartView>> spareParts(){return ApiResponse.ok(service.spareParts());}
    @GetMapping("/maintenance-plans") public ApiResponse<List<PlanView>> plans(){return ApiResponse.ok(service.plans());}
    @GetMapping("/work-orders") public ApiResponse<List<WorkOrderView>> workOrders(){return ApiResponse.ok(service.workOrders());}
    @GetMapping("/inspections") public ApiResponse<List<InspectionView>> inspections(){return ApiResponse.ok(service.inspections());}
    @PostMapping("/assets") @PreAuthorize("hasAnyRole('ADMIN','ASSET_MANAGER')") public ApiResponse<AssetView> createAsset(@Valid @RequestBody CreateAssetRequest r){return ApiResponse.ok("资产创建成功",service.createAsset(r));}
    @PostMapping("/work-orders") @PreAuthorize("hasAnyRole('ADMIN','ASSET_MANAGER')") public ApiResponse<WorkOrderView> createWorkOrder(@Valid @RequestBody CreateWorkOrderRequest r){return ApiResponse.ok("维修工单已创建",service.createWorkOrder(r));}
    @PatchMapping("/work-orders/{id}/advance") @PreAuthorize("hasAnyRole('ADMIN','ASSET_MANAGER','TECHNICIAN')") public ApiResponse<WorkOrderView> advance(@PathVariable Long id){return ApiResponse.ok("维修工单状态已推进",service.advanceWorkOrder(id));}
}
