package com.company.project.core.domain.dto;

import com.baomidou.dynamic.datasource.spring.boot.autoconfigure.druid.DruidConfig;
import com.baomidou.dynamic.datasource.spring.boot.autoconfigure.hikari.HikariCpConfig;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.boot.context.properties.NestedConfigurationProperty;

import javax.sql.DataSource;

/**
 * @program: springboot-quickstart
 * @description: 数据库dto
 * @author: duanzhiwei
 * @created: 2020/12/14 15:21
 */
@Data
@AllArgsConstructor
public class DataSourceDTO {
    private String poolName;
    private Class<? extends DataSource> type;
    private String driverClassName;
    private String url;
    private String username;
    private String password;
    private String jndiName;
    private String schema;
    private String data;
    private Boolean seata = true;
    private Boolean p6spy = true;
    private boolean continueOnError = true;
    private String publicKey;
}