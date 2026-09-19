/* Copyright 2026 Shanghai Rujing Zhihua Information Technology Co., Ltd. · https://www.zhuatech.cn/ */
package cn.zhuatech.eam.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

/**
 * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
 */
@Entity
@Table(name = "eam_inspection_record")
public class InspectionRecord extends BaseEntity {
    @Column(nullable = false, unique = true, length = 32) private String recordNo;
    @Column(nullable = false, length = 32) private String assetCode;
    @Column(nullable = false, length = 40) private String inspector;
    @Column(nullable = false) private LocalDateTime inspectedAt;
    @Column(nullable = false, length = 24) private String result;
    @Column(nullable = false, length = 240) private String finding;

    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    protected InspectionRecord() {}
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public InspectionRecord(String no,String assetCode,String inspector,LocalDateTime inspectedAt,String result,String finding){
        this.recordNo=no;this.assetCode=assetCode;this.inspector=inspector;this.inspectedAt=inspectedAt;this.result=result;this.finding=finding;
    }
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public String getRecordNo(){return recordNo;} /**
                                                   * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                   */
public String getAssetCode(){return assetCode;}
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public String getInspector(){return inspector;} /**
                                                     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                     */
public LocalDateTime getInspectedAt(){return inspectedAt;}
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public String getResult(){return result;} /**
                                               * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                               */
public String getFinding(){return finding;}
}
