package com.company.project.core.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.company.project.core.common.DataSourceType;
import com.company.project.core.configurer.DataSourceContextHolder;

/**
 * 
* @ClassName: DataSourceAopInService  
* @Description: 通过before aop实现数据源切换
 * 必须在事务AOP之前执行，所以order的值越小，越先执行
 * 一旦开始切换到写库，则之后的读都会走写库
* @author duanzhiwei
* @date 2018年1月18日 下午1:08:59  
*
 */
@Aspect
//@EnableAspectJAutoProxy(exposeProxy=true,proxyTargetClass=true)
@Component
@Order(1)
public class DataSourceAopInService {
    private static Logger log = LoggerFactory.getLogger(DataSourceAopInService.class);

    /**  
    * 读库切面，处理service层的find开头的方法和ReadDataSource注解
    * @Title: setReadDataSourceType  
    * @param @param joinPoint    参数
    * @return void    返回类型  
    * @throws  
    */
    @Before("execution(* com.company.project.service..*.find*(..)) "
            + "or execution(* com.company.project.core.common.AbstractService.find*(..)) "
            + " or @annotation(com.company.project.core.annotation.ReadDataSource) ")
    public void setReadDataSourceType(JoinPoint joinPoint) {
        //如果已经开启写事务了，那之后的所有读都从写库读
        if (!DataSourceType.write.getType().equals(DataSourceContextHolder.getReadOrWrite())) {
            log.debug("设置数据源为read");
            DataSourceContextHolder.setRead();
        }
    }

    /**  
    * 写库切面，处理service层的save、delete、update开头的方法和WriteDataSource注解
    * 把这个方法写在第二位，保证最差的情况下会去写库中操作
    * @Title: setWriteDataSourceType  
    * @param @param joinPoint    参数
    * @return void    返回类型  
    * @throws  
    */
    @Before("execution(* com.company.project.service..*.save*(..)) "
            + "or execution(* com.company.project.service..*.delete*(..)) "
            + "or execution(* com.company.project.service..*.update*(..)) "
            + "or execution(* com.company.project.core.common.AbstractService.save*(..)) "
            + "or execution(* com.company.project.core.common.AbstractService.delete*(..)) "
            + "or execution(* com.company.project.core.common.AbstractService.update*(..)) "
            + " or @annotation(com.company.project.core.annotation.WriteDataSource) ")
    public void setWriteDataSourceType(JoinPoint joinPoint) {
        log.debug("设置数据源为write");
        DataSourceContextHolder.setWrite();
    }
}
