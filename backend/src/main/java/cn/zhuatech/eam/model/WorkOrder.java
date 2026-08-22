/* Copyright 2026 Shanghai Rujing Zhihua Information Technology Co., Ltd. · https://www.zhuatech.cn/ */
package cn.zhuatech.eam.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "eam_work_order")
public class WorkOrder extends BaseEntity {
    @Column(nullable = false, unique = true, length = 32) private String orderNo;
    @Column(nullable = false, length = 32) private String assetCode;
    @Column(nullable = false, length = 140) private String title;
    @Column(nullable = false, length = 24) private String orderType;
    @Column(nullable = false, length = 16) private String priority;
    @Column(nullable = false, length = 40) private String assignee;
    @Column(nullable = false) private LocalDateTime dueAt;
    @Column(nullable = false, length = 24) private String status;

    protected WorkOrder() {}
    public WorkOrder(String no,String assetCode,String title,String type,String priority,String assignee,LocalDateTime dueAt,String status){
        this.orderNo=no;this.assetCode=assetCode;this.title=title;this.orderType=type;this.priority=priority;
        this.assignee=assignee;this.dueAt=dueAt;this.status=status;
    }
    public void advance(){this.status=switch(status){case "待接单"->"处理中";case "处理中"->"待验收";case "待验收"->"已完成";default->status;};}
    public String getOrderNo(){return orderNo;} public String getAssetCode(){return assetCode;}
    public String getTitle(){return title;} public String getOrderType(){return orderType;}
    public String getPriority(){return priority;} public String getAssignee(){return assignee;}
    public LocalDateTime getDueAt(){return dueAt;} public String getStatus(){return status;}
}
