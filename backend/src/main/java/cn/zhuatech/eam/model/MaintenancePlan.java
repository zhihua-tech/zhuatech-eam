/* Copyright 2026 Shanghai Rujing Zhihua Information Technology Co., Ltd. · https://www.zhuatech.cn/ */
package cn.zhuatech.eam.model;

import jakarta.persistence.*;
import java.time.LocalDate;

/**
 * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
 */
@Entity
@Table(name = "eam_maintenance_plan")
public class MaintenancePlan extends BaseEntity {
    @Column(nullable = false, unique = true, length = 32) private String planNo;
    @Column(nullable = false, length = 32) private String assetCode;
    @Column(nullable = false, length = 100) private String planName;
    @Column(nullable = false) private Integer cycleDays;
    @Column(nullable = false) private LocalDate nextExecutionDate;
    @Column(nullable = false, length = 40) private String team;
    @Column(nullable = false, length = 24) private String status;

    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    protected MaintenancePlan() {}
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public MaintenancePlan(String no,String assetCode,String name,Integer cycleDays,LocalDate nextExecutionDate,String team,String status){
        this.planNo=no;this.assetCode=assetCode;this.planName=name;this.cycleDays=cycleDays;
        this.nextExecutionDate=nextExecutionDate;this.team=team;this.status=status;
    }
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public String getPlanNo(){return planNo;} /**
                                               * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                               */
public String getAssetCode(){return assetCode;}
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public String getPlanName(){return planName;} /**
                                                   * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                   */
public Integer getCycleDays(){return cycleDays;}
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public LocalDate getNextExecutionDate(){return nextExecutionDate;} /**
                                                                        * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                                        */
public String getTeam(){return team;}
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public String getStatus(){return status;}
}
