/* Copyright 2026 Shanghai Rujing Zhihua Information Technology Co., Ltd. */
package cn.zhuatech.eam.repository;
import cn.zhuatech.eam.model.MaintenancePlan; import org.springframework.data.jpa.repository.JpaRepository; import java.time.LocalDate; import java.util.List;
public interface MaintenancePlanRepository extends JpaRepository<MaintenancePlan,Long>{List<MaintenancePlan> findAllByOrderByNextExecutionDateAsc(); long countByNextExecutionDateLessThanEqual(LocalDate date);}
