# 数据模型

Copyright 2026 上海如静知华信息科技有限公司。

| 表 | 作用 | 关键约束 |
| --- | --- | --- |
| `sys_user` | 登录账号与角色 | `username` 唯一 |
| `eam_asset` | 资产主数据 | `asset_code` 唯一 |
| `eam_maintenance_plan` | 周期维护计划 | `plan_no` 唯一，按 `next_execution_date` 索引 |
| `eam_work_order` | 维修执行工单 | `order_no` 唯一，按状态索引 |
| `eam_inspection_record` | 现场巡检结果 | `record_no` 唯一，按资产索引 |
| `eam_spare_part` | 维护备件库存 | `part_code` 唯一 |

业务实体继承 `BaseEntity`，统一保存 `id`、`created_at` 与 `updated_at`。演示版以资产编码关联各域，生产扩展可改为外键 ID，同时增加组织、工厂、租户和软删除字段。
