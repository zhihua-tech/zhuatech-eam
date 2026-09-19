/* Copyright 2026 Shanghai Rujing Zhihua Information Technology Co., Ltd. · https://www.zhuatech.cn/ */
package cn.zhuatech.eam.dto;
import cn.zhuatech.eam.model.*; import jakarta.validation.constraints.*; import java.math.BigDecimal; import java.time.*; import java.util.List;
/**
 * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
 */
public final class EamDto {
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    private EamDto(){}
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public record AssetView(Long id,String assetCode,String assetName,String category,String location,String custodian,BigDecimal originalValue,LocalDate commissionedOn,String healthStatus,String operationStatus){/**
                                                                                                                                                                                                                      * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                                                                                                                                                                                      */
public static AssetView from(Asset a){return new AssetView(a.getId(),a.getAssetCode(),a.getAssetName(),a.getCategory(),a.getLocation(),a.getCustodian(),a.getOriginalValue(),a.getCommissionedOn(),a.getHealthStatus(),a.getOperationStatus());}}
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public record SparePartView(Long id,String partCode,String partName,String specification,String unit,Integer stockQuantity,Integer safetyStock,String warehouse,boolean belowSafetyStock){/**
                                                                                                                                                                                               * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                                                                                                                                                               */
public static SparePartView from(SparePart p){return new SparePartView(p.getId(),p.getPartCode(),p.getPartName(),p.getSpecification(),p.getUnit(),p.getStockQuantity(),p.getSafetyStock(),p.getWarehouse(),p.isBelowSafetyStock());}}
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public record PlanView(Long id,String planNo,String assetCode,String planName,Integer cycleDays,LocalDate nextExecutionDate,String team,String status){/**
                                                                                                                                                            * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                                                                                                                            */
public static PlanView from(MaintenancePlan p){return new PlanView(p.getId(),p.getPlanNo(),p.getAssetCode(),p.getPlanName(),p.getCycleDays(),p.getNextExecutionDate(),p.getTeam(),p.getStatus());}}
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public record WorkOrderView(Long id,String orderNo,String assetCode,String title,String orderType,String priority,String assignee,LocalDateTime dueAt,String status){/**
                                                                                                                                                                          * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                                                                                                                                          */
public static WorkOrderView from(WorkOrder w){return new WorkOrderView(w.getId(),w.getOrderNo(),w.getAssetCode(),w.getTitle(),w.getOrderType(),w.getPriority(),w.getAssignee(),w.getDueAt(),w.getStatus());}}
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public record InspectionView(Long id,String recordNo,String assetCode,String inspector,LocalDateTime inspectedAt,String result,String finding){/**
                                                                                                                                                    * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                                                                                                                    */
public static InspectionView from(InspectionRecord i){return new InspectionView(i.getId(),i.getRecordNo(),i.getAssetCode(),i.getInspector(),i.getInspectedAt(),i.getResult(),i.getFinding());}}
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public record Dashboard(long assetCount,long attentionAssets,long openOrders,long urgentOrders,long upcomingPlans,long abnormalInspections,List<AssetView> keyAssets,List<WorkOrderView> urgentWorkOrders,List<PlanView> upcomingMaintenance){}
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public record CreateAssetRequest(@NotBlank String assetCode,@NotBlank String assetName,@NotBlank String category,@NotBlank String location,@NotBlank String custodian,@NotNull @PositiveOrZero BigDecimal originalValue,@NotNull @PastOrPresent LocalDate commissionedOn){}
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public record CreateWorkOrderRequest(@NotBlank String assetCode,@NotBlank @Size(max=140) String title,@NotBlank String orderType,@Pattern(regexp="一般|紧急|特急") String priority,@NotBlank String assignee,@NotNull @FutureOrPresent LocalDateTime dueAt){}
}
