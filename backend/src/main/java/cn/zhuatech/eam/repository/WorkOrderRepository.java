/* Copyright 2026 Shanghai Rujing Zhihua Information Technology Co., Ltd. */
package cn.zhuatech.eam.repository;
import cn.zhuatech.eam.model.WorkOrder; import org.springframework.data.jpa.repository.JpaRepository; import java.util.List;
public interface WorkOrderRepository extends JpaRepository<WorkOrder,Long>{List<WorkOrder> findAllByOrderByDueAtAsc(); long countByStatusNot(String status); long countByPriorityAndStatusNot(String priority,String status);}
