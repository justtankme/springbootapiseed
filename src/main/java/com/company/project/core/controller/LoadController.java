package com.company.project.core.controller;

import com.baomidou.dynamic.datasource.DynamicRoutingDataSource;
import com.baomidou.dynamic.datasource.creator.*;
import com.baomidou.dynamic.datasource.spring.boot.autoconfigure.DataSourceProperty;
import com.company.project.core.domain.dto.DataSourceDTO;
import com.company.project.core.util.SpringContextUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.sql.DataSource;
import java.util.Set;

/**
 * @program: springboot-quickstart
 * @description: 动态增减数据源
 * @author: duanzhiwei
 * @created: 2020/12/14 15:19
 */
@RestController
@RequestMapping("/datasources")
@Api(tags = "添加删除数据源")
public class LoadController {

//    private final DynamicRoutingDataSource ds;
//    private final DataSourceCreator dataSourceCreator;
//    private final BasicDataSourceCreator basicDataSourceCreator;
//    private final JndiDataSourceCreator jndiDataSourceCreator;
//    private final DruidDataSourceCreator druidDataSourceCreator;
//    private final HikariDataSourceCreator hikariDataSourceCreator;

    @GetMapping
    @ApiOperation(value = "获取数据源列表")
    public Set<String> now() {
        DynamicRoutingDataSource dynamicRoutingDataSource = SpringContextUtil.getBean(DynamicRoutingDataSource.class);
        return dynamicRoutingDataSource.getCurrentDataSources().keySet();
    }

//    @PostMapping("/add") //recommond use this method
//    public Set<String> add(@Validated @RequestBody DataSourceDTO dto) {
//        DataSourceProperty dataSourceProperty = new DataSourceProperty();
//        BeanUtils.copyProperties(dto, dataSourceProperty);
//        DataSource dataSource = dataSourceCreator.createDataSource(dataSourceProperty);
//        ds.addDataSource(dto.getPoolName(), dataSource);
//        return ds.getCurrentDataSources().keySet();
//    }
//
//    @PostMapping("/addBasic")
//    public Set<String> addBasic(@Validated @RequestBody DataSourceDTO dto) {
//        DataSourceProperty dataSourceProperty = new DataSourceProperty();
//        BeanUtils.copyProperties(dto, dataSourceProperty);
//        DataSource dataSource = basicDataSourceCreator.createDataSource(dataSourceProperty);
//        ds.addDataSource(dto.getPoolName(), dataSource);
//        return ds.getCurrentDataSources().keySet();
//    }
//
//    @PostMapping("/addJndi")
//    public Set<String> addJndi(String pollName, String jndiName) {
//        DataSource dataSource = jndiDataSourceCreator.createDataSource(jndiName);
//        ds.addDataSource(pollName, dataSource);
//        return ds.getCurrentDataSources().keySet();
//    }

    @PostMapping("/addDruid")
    @ApiOperation(value = "添加一个Druid数据源")
    public Set<String> addDruid(@Validated @RequestBody DataSourceDTO dto) {
        DruidDataSourceCreator druidDataSourceCreator = SpringContextUtil.getBean(DruidDataSourceCreator.class);
        DynamicRoutingDataSource dynamicRoutingDataSource = SpringContextUtil.getBean(DynamicRoutingDataSource.class);
        DataSourceProperty dataSourceProperty = new DataSourceProperty();
        BeanUtils.copyProperties(dto, dataSourceProperty);
        DataSource dataSource = druidDataSourceCreator.createDataSource(dataSourceProperty);
        dynamicRoutingDataSource.addDataSource(dto.getPoolName(), dataSource);
        return dynamicRoutingDataSource.getCurrentDataSources().keySet();
    }
//
//    @PostMapping("/addHikariCP")
//    public Set<String> addHikariCP(@Validated @RequestBody DataSourceDTO dto) {
//        DataSourceProperty dataSourceProperty = new DataSourceProperty();
//        BeanUtils.copyProperties(dto, dataSourceProperty);
//        DataSource dataSource = hikariDataSourceCreator.createDataSource(dataSourceProperty);
//        ds.addDataSource(dto.getPoolName(), dataSource);
//        return ds.getCurrentDataSources().keySet();
//    }

    @DeleteMapping
    @ApiOperation(value = "根据数据源名称删除一个数据源")
    public String removeDatasource(String name) {
        DynamicRoutingDataSource dynamicRoutingDataSource = SpringContextUtil.getBean(DynamicRoutingDataSource.class);
        dynamicRoutingDataSource.removeDataSource(name);
        return "delete success";
    }
}