/* Copyright 2026 Shanghai Rujing Zhihua Information Technology Co., Ltd. */
package cn.zhuatech.eam.model;

import jakarta.persistence.*;

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

    protected SparePart() {}
    public SparePart(String code,String name,String specification,String unit,Integer stock,Integer safetyStock,String warehouse){
        this.partCode=code;this.partName=name;this.specification=specification;this.unit=unit;
        this.stockQuantity=stock;this.safetyStock=safetyStock;this.warehouse=warehouse;
    }
    public String getPartCode(){return partCode;} public String getPartName(){return partName;}
    public String getSpecification(){return specification;} public String getUnit(){return unit;}
    public Integer getStockQuantity(){return stockQuantity;} public Integer getSafetyStock(){return safetyStock;}
    public String getWarehouse(){return warehouse;} public boolean isBelowSafetyStock(){return stockQuantity<safetyStock;}
}
