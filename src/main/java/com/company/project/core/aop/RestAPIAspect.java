package com.company.project.core.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.company.project.core.common.CommonRestApiAspect;

/**
 * 
* @ClassName: RestAPIAspect  
* @Description: restAPI请求切面
* @author 段志伟
* @date 2017年6月3日 下午5:29:02  
*
 */
@Aspect
@Component
@Order(-5)
public class RestAPIAspect extends CommonRestApiAspect{

    /**
    * 定义一个切入点.
    * 解释下：
    * 
    * ~ 第一个 * 代表任意修饰符及任意返回值.
    * ~ 第二个 * 任意包名
    * ~ 第三个 * 代表任意方法. 
    * ~ 第四个 * 任意方法
    * ~ .. 匹配任意数量的参数.表示controller包或者子包
    */
    @Pointcut("execution(public * com.company.*.web..*.*(..))")
    public void webLog() {
        
    }
    
    @Before("webLog()")
    public void before(JoinPoint joinPoint){
        doBefore(joinPoint);
    }
    
    @AfterReturning(returning = "result", pointcut = "webLog()")
    public void afterReturning(JoinPoint joinPoint, Object result) {
        doAfterReturning(joinPoint, result);
    }
}
