package com.company.project.core.configurer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    @ConfigurationProperties("spring.datasource.druid.write")
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
    @ConfigurationProperties("spring.datasource.druid.read")
    public DruidDataSource dataSourceRead(){
        logger.debug("Configuring dataSourceRead");
        return DruidDataSourceBuilder.create().build();
    }

    /**  
    * @Title: druidServletRegist  
    * @Description: druid连接池提供的监控页面servlet
    * @param @return    参数
    * @return ServletRegistrationBean    返回类型  
    * @throws  
    */
//    @Bean
//    public ServletRegistrationBean druidServletRegist() {
//        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean();
//        servletRegistrationBean.setServlet(new StatViewServlet());
//        servletRegistrationBean.addUrlMappings("/druid/*");
//        Map<String, String> initParameters = new HashMap<String, String>(10);
//        // 用户名
//        initParameters.put("loginUsername", "admin");
//        // 密码
//        initParameters.put("loginPassword", "admin");
//        // 禁用HTML页面上的“Reset All”功能
//        initParameters.put("resetEnable", "false");
//        // IP白名单 (没有配置或者为空，则允许所有访问)
//        initParameters.put("allow", "");
//        servletRegistrationBean.setInitParameters(initParameters);
//        return servletRegistrationBean;
//    }

    /**  
    * @Title: webStatFilterRegist  
    * @Description: druid连接池统计页面需要的过滤器
    * @param @return    参数
    * @return FilterRegistrationBean    返回类型  
    * @throws  
    */
//    @Bean
//    public FilterRegistrationBean webStatFilterRegist() {
//        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
//        filterRegistrationBean.setFilter(new WebStatFilter());
//        filterRegistrationBean.addUrlPatterns("/*");
//        filterRegistrationBean.addInitParameter("exclusions", "*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");
//        return filterRegistrationBean;
//    }
}