package com.company.project.core.configurer;

/**
 * 
* @ClassName: DruidSpringMonitorConfigurer  
* @Description: druid spring监控interceptor
* @author duanzhiwei
* @date 2018年1月16日 上午11:45:20  
*
 */
public class DruidSpringMonitorConfigurer{
    
}
//@Configuration
//public class DruidSpringMonitorConfigurer extends WebMvcConfigurerAdapter {
//    private Logger logger = LoggerFactory.getLogger(DruidSpringMonitorConfigurer.class);
//
//    /**
//     * 是否进行监控
//     */
//    @Value("${spring.druid.interceptor}")
//    private Boolean interceptor = false;
//    /**
//     * monitorPattern:监控对象通配符
//     */
//    @Value("${spring.druid.monitor.pattern}")
//    private String monitorPattern = "";
//    
//    @Bean
//    public DruidStatInterceptor getDruidStatInterceptor(){
//        return new DruidStatInterceptor();
//    }
//    @Bean
//    public JdkRegexpMethodPointcut getJdkRegexpMethodPointcut(){
//        JdkRegexpMethodPointcut jdkRegexpMethodPointcut = new JdkRegexpMethodPointcut();
//        if (interceptor) {
//            String[] patterns = new String[]{monitorPattern};
//            jdkRegexpMethodPointcut.setPatterns(patterns);
//            logger.info(String.format("加载druid监控，监控对象为:%s", monitorPattern));
//        }
//        return jdkRegexpMethodPointcut;
//    }
//    @Bean
//    public Advisor druidStatAdvisor() {
//        return new DefaultPointcutAdvisor(getJdkRegexpMethodPointcut(), getDruidStatInterceptor());
//    }
//}
