/* Copyright 2026 Shanghai Rujing Zhihua Information Technology Co., Ltd. */
package cn.zhuatech.eam.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "eam_inspection_record")
public class InspectionRecord extends BaseEntity {
    @Column(nullable = false, unique = true, length = 32) private String recordNo;
    @Column(nullable = false, length = 32) private String assetCode;
    @Column(nullable = false, length = 40) private String inspector;
    @Column(nullable = false) private LocalDateTime inspectedAt;
    @Column(nullable = false, length = 24) private String result;
    @Column(nullable = false, length = 240) private String finding;

    protected InspectionRecord() {}
    public InspectionRecord(String no,String assetCode,String inspector,LocalDateTime inspectedAt,String result,String finding){
        this.recordNo=no;this.assetCode=assetCode;this.inspector=inspector;this.inspectedAt=inspectedAt;this.result=result;this.finding=finding;
    }
    public String getRecordNo(){return recordNo;} public String getAssetCode(){return assetCode;}
    public String getInspector(){return inspector;} public LocalDateTime getInspectedAt(){return inspectedAt;}
    public String getResult(){return result;} public String getFinding(){return finding;}
}
