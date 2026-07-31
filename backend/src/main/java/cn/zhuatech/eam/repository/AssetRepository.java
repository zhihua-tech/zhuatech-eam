/* Copyright 2026 Shanghai Rujing Zhihua Information Technology Co., Ltd. */
package cn.zhuatech.eam.repository;
import cn.zhuatech.eam.model.Asset; import org.springframework.data.jpa.repository.JpaRepository; import java.util.*;
public interface AssetRepository extends JpaRepository<Asset,Long>{List<Asset> findAllByOrderByAssetCodeAsc(); Optional<Asset> findByAssetCode(String code); long countByHealthStatus(String status);}
