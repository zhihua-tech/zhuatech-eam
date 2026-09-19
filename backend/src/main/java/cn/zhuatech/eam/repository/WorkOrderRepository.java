/* Copyright 2026 Shanghai Rujing Zhihua Information Technology Co., Ltd. · https://www.zhuatech.cn/ */
package cn.zhuatech.eam.repository;
import cn.zhuatech.eam.model.WorkOrder; import org.springframework.data.jpa.repository.JpaRepository; import java.util.List;
/**
 * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
 */
public interface WorkOrderRepository extends JpaRepository<WorkOrder,Long>{/**
                                                                            * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                                            */
List<WorkOrder> findAllByOrderByDueAtAsc(); /**
                                                                                                                        * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                                                                                        */
long countByStatusNot(String status); /**
                                                                                                                                                              * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                                                                                                                              */
long countByPriorityAndStatusNot(String priority,String status);}
