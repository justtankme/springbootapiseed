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

#### 2018/12/28
- 升级至springboot 2.1.1.RELEASE
- 修改项目为jar包项目
- 升级swagger至2.9.0
- 使用spring boot新特性集成quartz，参考 `https://www.jianshu.com/p/056281e057b3`
- 增加对restapi请求的日志记录
- 增加指定数据源功能，见`SpecifiedDataSource`

### 2020/12/11
- 使用mybatis-plus 3.4.1，及其代码生成器，参考`https://baomidou.com/config/generator-config.html`
- 升级springboot到2.4.0
- 升级druid到1.2.3
- 集成lombok 1.18.16
- 升级到swagger3 参考 `https://github.com/springfox/springfox`
- 使用通用 `BaseController` 实现CRUD
- 更换多数据源方案为`dynamic-datasource-spring-boot-starter` 参考 `https://dynamic-datasource.com/`
- 数据库密码加密使用Druid自带方案`java -cp druid-1.1.10.jar com.alibaba.druid.filter.config.ConfigTools youpassword`
- 新的读写分离实现方案

### TODO
- 对于redis的配置和使用，暂时没有比较完美的方案。
- 实现自动生成swagger注解，包括ApiModelProperty ApiOperation ApiImplicitParams
- 优化增加数据源时需要进行的配置操作量

### tips
- src/main/resources/sql目录下是所需的sql脚本
- 使用eclipse的，建议在market中安装sts插件
- swagger页面 http://localhost:8080/quickstart/swagger-ui.html
- druid页面 http://localhost:8080/quickstart/druid/api.html
```
    //前台向后台传递字符串类型的日期参数时，需要通过此注解将字符串解析成日期类型，其中日期格式可以根据需要进行设置。
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss:SSSSSSSSS")
    //SpringMVC向前端返回json格式的数据时，日期类型默认返回时间戳，那么我们可以通过此注解将时间返回为固定格式的字符串。
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss:SSSSSSSSS",timezone = "GMT+8")
    private LocalDateTime createTime;
