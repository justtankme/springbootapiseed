package com.company.project.core.configurer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.quartz.QuartzDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;

/**  
* @ClassName: DataBaseConfigurer  
* @Description: 数据库连接及事务配置
* @author duanzhiwei
* @date 2018年1月16日 上午11:43:02  
*    
*/
@Configuration
public class DataBaseConfigurer {
    private static final Logger logger = LoggerFactory.getLogger(DataBaseConfigurer.class);

    /**
     * 
    * 写库配置
    * @Title: dataSourceWrite  
    * @param @return    参数
    * @return DruidDataSource    返回类型  
    * @throws
     */
    @Bean(name = "dataSourceWrite")
    @Primary
    @ConfigurationProperties("spring.datasource.write")
    public DruidDataSource dataSourceWrite() {
        logger.debug("Configuring dataSourceWrite");
        return DruidDataSourceBuilder.create().build();
    }

    /**  
    * 读库配置
    * @Title: dataSourceRead  
    * @param @return    参数
    * @return DruidDataSource    返回类型  
    * @throws  
    */
    @Bean(name = "dataSourceRead")
    @ConfigurationProperties("spring.datasource.read")
    public DruidDataSource dataSourceRead(){
        logger.debug("Configuring dataSourceRead");
        return DruidDataSourceBuilder.create().build();
    }
    
    /**  
    * 日志库配置
    * @Title: dataSourceLog  
    * @param @return    参数
    * @return DruidDataSource    返回类型  
    * @throws  
    */
    @Bean(name = "dataSourceLog")
    @ConfigurationProperties("spring.datasource.log")
    public DruidDataSource dataSourceLog(){
        logger.debug("Configuring dataSourceLog");
        return DruidDataSourceBuilder.create().build();
    }    
    
    /**  
    * quartz库配置
    * @Title: dataSourceQuartz  
    * @param @return    参数
    * @return DruidDataSource    返回类型  
    * @throws  
    */
    @QuartzDataSource
    @Bean(name = "dataSourceQuartz")
    @ConfigurationProperties("spring.datasource.quartz")
    public DruidDataSource dataSourceQuartz(){
        logger.debug("Configuring dataSourceQuartz");
        return DruidDataSourceBuilder.create().build();
    }
}