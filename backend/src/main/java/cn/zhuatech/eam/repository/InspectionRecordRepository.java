/* Copyright 2026 Shanghai Rujing Zhihua Information Technology Co., Ltd. · https://www.zhuatech.cn/ */
package cn.zhuatech.eam.repository;
import cn.zhuatech.eam.model.InspectionRecord; import org.springframework.data.jpa.repository.JpaRepository; import java.util.List;
public interface InspectionRecordRepository extends JpaRepository<InspectionRecord,Long>{List<InspectionRecord> findAllByOrderByInspectedAtDesc(); long countByResult(String result);}
