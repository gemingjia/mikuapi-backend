# MIKU API开放平台

## 平台功能

1.后端采用springboot框架，Mybatis Plus做数据层操作，数据库使用MySQL

2.Spring Cloud Gateway做统一网关，主要实现了白名单、api调用鉴权、 日志打印

3.使用Feign作为系统间 RPC 调用，使用 Nacos 作为注册中心

4.自定义SpringBoot starter，自动配置ApiClient sdk，封装了调用API接口的功能

5.设计 API 签名认证算法，为用户分配唯一 ak / sk 以鉴权，保障调用的安全性、可溯源性（指便于统计接口调用次数）。


----
## 技术栈
●Spring Boot

●MySQL 数据库

●MyBatis-Plus 及 MyBatis X 自动生成

●API 签名认证（Http 调用）

●Spring Boot Starter（SDK 开发）

●Dubbo 分布式（RPC、Nacos）

●Swagger + Knife4j 接口文档生成

●Spring Cloud Gateway 微服务网关

●Hutool、Apache Common Utils、Gson 等
