/* Copyright 2026 Shanghai Rujing Zhihua Information Technology Co., Ltd. · https://www.zhuatech.cn/ */
package cn.zhuatech.eam.model;

import jakarta.persistence.*;

/**
 * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
 */
@Entity
@Table(name = "eam_spare_part")
public class SparePart extends BaseEntity {
    @Column(nullable = false, unique = true, length = 32) private String partCode;
    @Column(nullable = false, length = 100) private String partName;
    @Column(nullable = false, length = 60) private String specification;
    @Column(nullable = false, length = 20) private String unit;
    @Column(nullable = false) private Integer stockQuantity;
    @Column(nullable = false) private Integer safetyStock;
    @Column(nullable = false, length = 40) private String warehouse;

    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    protected SparePart() {}
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public SparePart(String code,String name,String specification,String unit,Integer stock,Integer safetyStock,String warehouse){
        this.partCode=code;this.partName=name;this.specification=specification;this.unit=unit;
        this.stockQuantity=stock;this.safetyStock=safetyStock;this.warehouse=warehouse;
    }
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public String getPartCode(){return partCode;} /**
                                                   * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                   */
public String getPartName(){return partName;}
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public String getSpecification(){return specification;} /**
                                                             * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                             */
public String getUnit(){return unit;}
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public Integer getStockQuantity(){return stockQuantity;} /**
                                                              * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                              */
public Integer getSafetyStock(){return safetyStock;}
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public String getWarehouse(){return warehouse;} /**
                                                     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                     */
public boolean isBelowSafetyStock(){return stockQuantity<safetyStock;}
}
