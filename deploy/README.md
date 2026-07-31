# ZhuaTech EAM 部署说明

复制根目录 `.env.example` 为 `.env`，替换数据库密码与 JWT 密钥后执行 `docker compose up --build -d`。默认 Web 地址为 `http://localhost:8090`，API 地址为 `http://localhost:8080`。

生产部署前应至少配置 HTTPS、备份恢复、日志脱敏、统一身份认证、最小权限、审计、监控告警和高可用数据库。接入真实设备或 IoT 平台时，还需评估网络隔离、边缘缓存、时序数据容量与指令安全。

社区源码版仅限个人非商业学习。生产商用、私有化实施或深度定制请通过 [知华科技官网](https://www.zhuatech.cn/) 联系上海如静知华信息科技有限公司取得授权。
