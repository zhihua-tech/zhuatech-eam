/* Copyright 2026 Shanghai Rujing Zhihua Information Technology Co., Ltd. · https://www.zhuatech.cn/ */
package cn.zhuatech.eam.repository;
import cn.zhuatech.eam.model.MaintenancePlan; import org.springframework.data.jpa.repository.JpaRepository; import java.time.LocalDate; import java.util.List;
/**
 * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
 */
public interface MaintenancePlanRepository extends JpaRepository<MaintenancePlan,Long>{/**
                                                                                        * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                                                        */
List<MaintenancePlan> findAllByOrderByNextExecutionDateAsc(); /**
                                                                                                                                                      * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                                                                                                                      */
long countByNextExecutionDateLessThanEqual(LocalDate date);}
