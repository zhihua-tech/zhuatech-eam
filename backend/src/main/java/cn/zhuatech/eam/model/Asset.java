/* Copyright 2026 Shanghai Rujing Zhihua Information Technology Co., Ltd. · https://www.zhuatech.cn/ */
package cn.zhuatech.eam.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
 */
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

    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    protected Asset() {}

    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public Asset(String code, String name, String category, String location, String custodian,
                 BigDecimal originalValue, LocalDate commissionedOn, String healthStatus, String operationStatus) {
        this.assetCode = code; this.assetName = name; this.category = category; this.location = location;
        this.custodian = custodian; this.originalValue = originalValue; this.commissionedOn = commissionedOn;
        this.healthStatus = healthStatus; this.operationStatus = operationStatus;
    }

    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public String getAssetCode(){return assetCode;} /**
                                                     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                     */
public String getAssetName(){return assetName;}
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public String getCategory(){return category;} /**
                                                   * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                   */
public String getLocation(){return location;}
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public String getCustodian(){return custodian;} /**
                                                     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                     */
public BigDecimal getOriginalValue(){return originalValue;}
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public LocalDate getCommissionedOn(){return commissionedOn;} /**
                                                                  * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                                  */
public String getHealthStatus(){return healthStatus;}
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public String getOperationStatus(){return operationStatus;}
}
