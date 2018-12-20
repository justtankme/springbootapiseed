>感谢 https://github.com/lihengming 的分享

### 简介
一个springboot种子项目，用于快速开发基于rest API的接口服务，提供基于表的增删改查代码自动生成、基于aop的读写分离配置。

### changeLog
#### 2018/01/16
- 增加了对mysql uuid的处理，现在能正确的自动生成uuid并回写给入参。
- 增加了swagger组件，但是没有实现自动生成。
- 基于ali p3c eclipse plugin对controller、service模板进行了改造，增加了合理的注释。
- 将项目修改为既支持jar模式启动又支持war模式部署。
- 将响应结果类中data字段修改为泛型，并提供static方法便于使用。
- 增加了一个token过滤器用于用户认证，去掉了原来的签名认证逻辑。
- 增加了druid对于spring bean的监控。--这个似乎有配置化的解决方案，先不管
- 使用redisson进行缓存管理、分布式并发控制。

### TODO
- 对于redis的配置和使用，暂时没有比较完美的方案。
- 将mybatis、pagehelper、generator、freemarker升级到springboot版本。
- 实现自动生成swagger注解。