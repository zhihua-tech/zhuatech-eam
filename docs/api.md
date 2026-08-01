# API 概览

Copyright 2026 上海如静知华信息科技有限公司。

除登录外，接口需携带 `Authorization: Bearer <token>`。统一响应结构为 `code`、`message`、`data` 和 `timestamp`。

| 方法 | 路径 | 说明 |
| --- | --- | --- |
| POST | `/api/auth/login` | 登录并取得 JWT |
| GET | `/api/eam/dashboard` | 读取资产运营驾驶舱 |
| GET / POST | `/api/eam/assets` | 查询或新增资产 |
| GET | `/api/eam/maintenance-plans` | 查询维护计划 |
| GET / POST | `/api/eam/work-orders` | 查询或创建维修工单 |
| PATCH | `/api/eam/work-orders/{id}/advance` | 待接单→处理中→待验收→已完成 |
| GET | `/api/eam/inspections` | 查询巡检记录 |
| GET | `/api/eam/spare-parts` | 查询备件及安全库存状态 |

`ADMIN` 可访问全部接口，`ASSET_MANAGER` 可新增资产与工单，`TECHNICIAN` 可推进分配给现场执行的工单。生产环境应进一步实现数据范围权限与资源归属校验。

## 资产健康

`POST /api/eam/asset-health`：根据状态与历史维护数据评估设备风险和工单优先级。
