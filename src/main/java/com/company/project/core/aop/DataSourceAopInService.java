package com.company.project.core.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.company.project.core.annotation.SpecifiedDataSource;
import com.company.project.core.common.DataSourceTypeEnum;
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
@Component
@Order(1)
public class DataSourceAopInService {

    @Pointcut("execution(* com.company.project.service.*.find*(..)) "
            + "|| execution(* com.company.project.core.common.Service.find*(..)) "
            + "|| @annotation(com.company.project.core.annotation.ReadDataSource) ")
    public void readPoint() {
        
    }
    
    @Pointcut("execution(* com.company.project.service.*.save*(..)) "
            + "|| execution(* com.company.project.service.*.delete*(..)) "
            + "|| execution(* com.company.project.service.*.update*(..)) "
            + "|| execution(* com.company.project.core.common.Service.save*(..)) "
            + "|| execution(* com.company.project.core.common.Service.delete*(..)) "
            + "|| execution(* com.company.project.core.common.Service.update*(..)) "
            + "|| @annotation(com.company.project.core.annotation.WriteDataSource) ")
    public void writePoint() {

    }
    
    /**  
    * 读库切面，处理service层的find开头的方法和ReadDataSource注解
    * @Title: setReadDataSourceType  
    * @param @param joinPoint    参数
    * @return void    返回类型  
    * @throws  
    */
    @Before("readPoint()")
    public void setReadDataSourceType(JoinPoint joinPoint) {
        //如果已经开启写事务了，那之后的所有读都从写库读
        if (!DataSourceTypeEnum.write.getType().equals(DataSourceContextHolder.get())) {
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
    @Before("writePoint()")
    public void setWriteDataSourceType(JoinPoint joinPoint) {
        DataSourceContextHolder.setWrite();
    }
    
    /**  
    * 手动指定任意数据源
    * @Title: setSpecifiedDataSourceType  
    * @param @param joinPoint
    * @param @param specifiedDataSource    参数
    * @return void    返回类型  
    * @throws  
    */
    @Before("(@annotation(specifiedDataSource))")
    public void setSpecifiedDataSourceType(JoinPoint joinPoint, SpecifiedDataSource specifiedDataSource) {
        DataSourceContextHolder.set(specifiedDataSource.dataSourceType());
    }
    
    /**  
    * 清理本地线程变量防止内存泄漏
    * @Title: after  
    * @param @param point    参数
    * @return void    返回类型  
    * @throws  
    */
    @After("readPoint() || writePoint()")
    public void after(JoinPoint point) {
        DataSourceContextHolder.clear();
    }
    
    /**  
    * 清理本地线程变量防止内存泄漏
    * @Title: after  
    * @param @param joinPoint
    * @param @param specifiedDataSource    参数
    * @return void    返回类型  
    * @throws  
    */
    @After("(@annotation(specifiedDataSource))")
    public void after(JoinPoint joinPoint, SpecifiedDataSource specifiedDataSource) {
        DataSourceContextHolder.clear();
    }
}
