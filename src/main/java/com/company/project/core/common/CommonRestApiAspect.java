package com.company.project.core.common;

import java.util.Arrays;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.JoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**  
* @ClassName: CommonRestApiAspect  
* @Description: 简单通用的restAPI请求切面，记录了请求参数、返回值及耗时
* @author 段志伟
* @date 2017年6月3日 下午5:17:59  
*    
*/
public class CommonRestApiAspect {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    ThreadLocal<Long> startTime = new ThreadLocal<Long>();

    /**  
    * @Title: doBefore  
    * @Description: 前置动作，包括打印请求信息，开始计时
    * @param @param joinPoint    参数
    * @return void    返回类型  
    * @throws  
    */
    public void doBefore(JoinPoint joinPoint) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        startTime.set(System.currentTimeMillis());
        StringBuilder sb = getRequestInfo(joinPoint, request);
        logger.info(sb.toString());
    }

    /**  
    * @Title: doAfterReturning  
    * @Description: 后置动作，包括打印结果，统计耗时
    * @param @param joinPoint    参数
    * @return void    返回类型  
    * @throws  
    */
    public void doAfterReturning(JoinPoint joinPoint, Object result) {
        StringBuilder sb = getResponseInfo(result);
        sb.append("耗时(毫秒) :");
        sb.append((System.currentTimeMillis() - startTime.get()));
        logger.info(sb.toString());
        startTime.remove();
    }
    
    /**  
    * @Title: getRequestInfo  
    * @Description: 接收到请求，记录请求内容
    * @param @param joinPoint
    * @param @param request
    * @param @return    参数
    * @return StringBuilder    返回类型  
    * @throws  
    */
    private StringBuilder getRequestInfo(JoinPoint joinPoint, HttpServletRequest request) {
        StringBuilder sb = new StringBuilder();
        sb.append("接收到http请求，请求信息如下：");
        sb.append(System.lineSeparator());
    
        // 记录下请求内容
        sb.append("请求方式 :");
        sb.append(request.getMethod());
        sb.append(System.lineSeparator());
        sb.append("请求URL:");
        sb.append(request.getRequestURL().toString());
        String queryString = request.getQueryString();
        if (StringUtils.isNotBlank(queryString)) {
            sb.append("?");
            sb.append(queryString);
        }
        sb.append(System.lineSeparator());
        sb.append("请求头:");
        sb.append(getHeaderInfo(request));
        sb.append(System.lineSeparator());
        sb.append("请求参数:");
        sb.append(getParameterInfo(request));
        sb.append(System.lineSeparator());
        sb.append("来源IP:");
        sb.append(request.getRemoteAddr());
        sb.append(System.lineSeparator());
        sb.append("执行方法:");
        sb.append(joinPoint.getSignature().getDeclaringTypeName());
        sb.append(".");
        sb.append(joinPoint.getSignature().getName());
        sb.append(System.lineSeparator());
        sb.append("方法参数 :");
        sb.append(Arrays.toString(joinPoint.getArgs()));
        return sb;
    }
    
    /**  
    * @Title: getResponseInfo  
    * @Description: 处理完请求，记录处理结果
    * @param @param result
    * @param @return    参数
    * @return StringBuilder    返回类型  
    * @throws  
    */
    private StringBuilder getResponseInfo(Object result) {
        StringBuilder sb = new StringBuilder();
        // 处理完请求，返回内容
        sb.append("请求处理完成.");
        sb.append("结果是：");
        sb.append(result);
        sb.append(System.lineSeparator());
        return sb;
    }

    /**  
    * @Title: getHeadersInfo  
    * @Description: 获取请求头信息
    * @param @param request
    * @param @return    参数
    * @return Map<String,String>    返回类型  
    * @throws  
    */
    private Map<String, String> getHeaderInfo(HttpServletRequest request) {
        Map<String, String> map = new HashMap<>();
        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String key = (String) headerNames.nextElement();
            String value = request.getHeader(key);
            map.put(key, value);
        }
        return map;
    }
    
    /**  
    * @Title: getParameterInfo  
    * @Description: 获取请求参数信息
    * @param @param request
    * @param @return    参数
    * @return Map<String,String>    返回类型  
    * @throws  
    */
    private Map<String, String> getParameterInfo(HttpServletRequest request) {
        Map<String, String> map = new HashMap<>();
        Enumeration<String> headerNames = request.getParameterNames();
        while (headerNames.hasMoreElements()) {
            String key = (String) headerNames.nextElement();
            String value = request.getParameter(key);
            map.put(key, value);
        }
        return map;
    }
}