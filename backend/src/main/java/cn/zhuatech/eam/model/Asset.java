/* Copyright 2026 Shanghai Rujing Zhihua Information Technology Co., Ltd. · https://www.zhuatech.cn/ */
package cn.zhuatech.eam.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "eam_asset")
public class Asset extends BaseEntity {
    @Column(nullable = false, unique = true, length = 32) private String assetCode;
    @Column(nullable = false, length = 100) private String assetName;
    @Column(nullable = false, length = 40) private String category;
    @Column(nullable = false, length = 80) private String location;
    @Column(nullable = false, length = 40) private String custodian;
    @Column(nullable = false, precision = 14, scale = 2) private BigDecimal originalValue;
    @Column(nullable = false) private LocalDate commissionedOn;
    @Column(nullable = false, length = 24) private String healthStatus;
    @Column(nullable = false, length = 24) private String operationStatus;

    protected Asset() {}

    public Asset(String code, String name, String category, String location, String custodian,
                 BigDecimal originalValue, LocalDate commissionedOn, String healthStatus, String operationStatus) {
        this.assetCode = code; this.assetName = name; this.category = category; this.location = location;
        this.custodian = custodian; this.originalValue = originalValue; this.commissionedOn = commissionedOn;
        this.healthStatus = healthStatus; this.operationStatus = operationStatus;
    }

    public String getAssetCode(){return assetCode;} public String getAssetName(){return assetName;}
    public String getCategory(){return category;} public String getLocation(){return location;}
    public String getCustodian(){return custodian;} public BigDecimal getOriginalValue(){return originalValue;}
    public LocalDate getCommissionedOn(){return commissionedOn;} public String getHealthStatus(){return healthStatus;}
    public String getOperationStatus(){return operationStatus;}
}
