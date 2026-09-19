/* Copyright 2026 Shanghai Rujing Zhihua Information Technology Co., Ltd. · https://www.zhuatech.cn/ */
package cn.zhuatech.eam.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

/**
 * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
 */
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

    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    protected WorkOrder() {}
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public WorkOrder(String no,String assetCode,String title,String type,String priority,String assignee,LocalDateTime dueAt,String status){
        this.orderNo=no;this.assetCode=assetCode;this.title=title;this.orderType=type;this.priority=priority;
        this.assignee=assignee;this.dueAt=dueAt;this.status=status;
    }
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public void advance(){this.status=switch(status){case "待接单"->"处理中";case "处理中"->"待验收";case "待验收"->"已完成";default->status;};}
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public String getOrderNo(){return orderNo;} /**
                                                 * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                 */
public String getAssetCode(){return assetCode;}
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public String getTitle(){return title;} /**
                                             * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                             */
public String getOrderType(){return orderType;}
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public String getPriority(){return priority;} /**
                                                   * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                   */
public String getAssignee(){return assignee;}
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public LocalDateTime getDueAt(){return dueAt;} /**
                                                    * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                    */
public String getStatus(){return status;}
}
