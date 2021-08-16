# wyl blog

wyl 博客

## 系统模块

``` java
com.wyl     
├── wyl-ui              // 前端框架 [80]
├── wyl-gateway         // 网关模块 [8080]
├── wyl-auth            // 认证中心 [9200]
├── wyl-api             // 接口模块
├── wyl-common          // 通用模块
│       └── wyl-common-core                         // 核心模块
│       └── wyl-common-datascope                    // 权限范围
│       └── wyl-common-datasource                   // 多数据源
│       └── wyl-common-log                          // 日志记录
│       └── wyl-common-redis                        // 缓存服务
│       └── wyl-common-security                     // 安全模块
│       └── wyl-common-swagger                      // 系统接口
├── wyl-modules         // 业务模块
│       └── wyl-system                              // 系统模块 [9201]
│       └── wyl-gen                                 // 代码生成 [9202]
│       └── wyl-job                                 // 定时任务 [9203]
│       └── wyl-file                                // 文件服务 [9300]
├── wyl-visual          // 图形化管理模块
│       └── wyl-visual-monitor                      // 监控中心 [9100]
├──pom.xml                // 公共依赖
```