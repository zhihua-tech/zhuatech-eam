/* Copyright 2026 Shanghai Rujing Zhihua Information Technology Co., Ltd. */
package cn.zhuatech.eam.model;

import jakarta.persistence.*;
import java.time.LocalDate;

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

    protected MaintenancePlan() {}
    public MaintenancePlan(String no,String assetCode,String name,Integer cycleDays,LocalDate nextExecutionDate,String team,String status){
        this.planNo=no;this.assetCode=assetCode;this.planName=name;this.cycleDays=cycleDays;
        this.nextExecutionDate=nextExecutionDate;this.team=team;this.status=status;
    }
    public String getPlanNo(){return planNo;} public String getAssetCode(){return assetCode;}
    public String getPlanName(){return planName;} public Integer getCycleDays(){return cycleDays;}
    public LocalDate getNextExecutionDate(){return nextExecutionDate;} public String getTeam(){return team;}
    public String getStatus(){return status;}
}
