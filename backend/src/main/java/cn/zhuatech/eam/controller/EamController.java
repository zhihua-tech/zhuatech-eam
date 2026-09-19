/* Copyright 2026 Shanghai Rujing Zhihua Information Technology Co., Ltd. · https://www.zhuatech.cn/ */
package cn.zhuatech.eam.controller;
import cn.zhuatech.eam.common.ApiResponse; import cn.zhuatech.eam.dto.EamDto.*; import cn.zhuatech.eam.service.EamService; import jakarta.validation.Valid; import org.springframework.security.access.prepost.PreAuthorize; import org.springframework.web.bind.annotation.*; import java.util.List;
/**
 * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
 */
@RestController @RequestMapping("/api/eam") public class EamController {
    private final EamService service; /**
                                       * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                       */
public EamController(EamService service){this.service=service;}
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    @GetMapping("/dashboard") public ApiResponse<Dashboard> dashboard(){return ApiResponse.ok(service.dashboard());}
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    @GetMapping("/assets") public ApiResponse<List<AssetView>> assets(){return ApiResponse.ok(service.assets());}
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    @GetMapping("/spare-parts") public ApiResponse<List<SparePartView>> spareParts(){return ApiResponse.ok(service.spareParts());}
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    @GetMapping("/maintenance-plans") public ApiResponse<List<PlanView>> plans(){return ApiResponse.ok(service.plans());}
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    @GetMapping("/work-orders") public ApiResponse<List<WorkOrderView>> workOrders(){return ApiResponse.ok(service.workOrders());}
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    @GetMapping("/inspections") public ApiResponse<List<InspectionView>> inspections(){return ApiResponse.ok(service.inspections());}
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    @PostMapping("/assets") @PreAuthorize("hasAnyRole('ADMIN','ASSET_MANAGER')") public ApiResponse<AssetView> createAsset(@Valid @RequestBody CreateAssetRequest r){return ApiResponse.ok("资产创建成功",service.createAsset(r));}
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    @PostMapping("/work-orders") @PreAuthorize("hasAnyRole('ADMIN','ASSET_MANAGER')") public ApiResponse<WorkOrderView> createWorkOrder(@Valid @RequestBody CreateWorkOrderRequest r){return ApiResponse.ok("维修工单已创建",service.createWorkOrder(r));}
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    @PatchMapping("/work-orders/{id}/advance") @PreAuthorize("hasAnyRole('ADMIN','ASSET_MANAGER','TECHNICIAN')") public ApiResponse<WorkOrderView> advance(@PathVariable Long id){return ApiResponse.ok("维修工单状态已推进",service.advanceWorkOrder(id));}
}
