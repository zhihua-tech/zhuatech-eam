/* Copyright 2026 Shanghai Rujing Zhihua Information Technology Co., Ltd. · https://www.zhuatech.cn/ */
package cn.zhuatech.eam.repository;
import cn.zhuatech.eam.model.Asset; import org.springframework.data.jpa.repository.JpaRepository; import java.util.*;
/**
 * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
 */
public interface AssetRepository extends JpaRepository<Asset,Long>{/**
                                                                    * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                                    */
List<Asset> findAllByOrderByAssetCodeAsc(); /**
                                                                                                                * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                                                                                */
Optional<Asset> findByAssetCode(String code); /**
                                                                                                                                                              * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                                                                                                                              */
long countByHealthStatus(String status);}
