package com.company.project.core.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.company.project.core.common.Result;
import com.company.project.core.common.ServiceException;

/**
 * 异常处理切面
 * @author duanzhiwei 
 *
 */
@Component
@Aspect
public class ThrowExceptionAspect {
    private Logger logger = LoggerFactory.getLogger(ThrowExceptionAspect.class);
    
    @Around(value = "execution(* com.company.project.*.controller..*.*(..))")
    public Object dealExceptionOfController(ProceedingJoinPoint jp) {
        Object res = null;
        try {
            res = jp.proceed();
        } catch (ServiceException re) {
            logger.error(re.toString(), re);
            return Result.build(re.getResultCode(), re.getData());
        } catch (Throwable exception) {
            logger.error(exception.toString(), exception);
            return Result.fail(exception.getMessage());
        }
        return res;
    }
}
