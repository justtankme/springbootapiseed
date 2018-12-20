package com.company.project.core.filter;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.alibaba.druid.util.PatternMatcher;
import com.alibaba.druid.util.ServletPathMatcher;
import com.company.project.core.common.Result;
import com.company.project.core.common.ResultCode;
import com.company.project.service.TokenService;

/**  
* @ClassName: TokenFilter  
* @Description: token校验所用的filter类
* @author 段志伟
* @date 2016年5月11日 下午7:56:45  
*    
*/
public class TokenFilter implements Filter{
	protected static Logger logger = Logger.getLogger(TokenFilter.class);

	private TokenService tokenService;
	private String unAuthUrl;
	
	protected PatternMatcher pathMatcher = new ServletPathMatcher();
	private Set<String> unAuthPattern;
	private String contextPath;

	public TokenFilter(String unAuthUrl,TokenService tokenService) {
		this.unAuthUrl = unAuthUrl;
		this.tokenService = tokenService;
	}
    /**
	 * 
	 * 对每个request进行token处理
	 * 
	 * @see javax.servlet.Filter#doFilter(javax.servlet.ServletRequest,
	 *      javax.servlet.ServletResponse, javax.servlet.FilterChain)
	 */
	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;
//		request.getSession();
//		// 判断请求方式
//		String method = request.getMethod();
//		if ("OPTIONS".equals(method)) {
			chain.doFilter(req, response);
//		} else {
//			// 获取请求url
//			String requestURI=request.getRequestURI();
//			requestURI = trimUrl(requestURI);
//			// 不拦截的列表
//			// 如果url符合要求则不进行token认证
//			if(isUnAuth(requestURI)){
//				logger.debug("authed url " + requestURI);
//				chain.doFilter(req, response);
//			}
//			else {
//				// 获取header中的token信息
//				String token = request.getHeader(ProjectConstant.TOKEN_HEADER);
//				// token校验
//				if (tokenService.tokenValidate(token)) {
//					logger.debug("valid url " + requestURI);
//					tokenService.resetCacheTime(token);
//                    chain.doFilter(req, response);
//				} else {
//					logger.debug("url " + requestURI + " without token");
//					// 校验不通过
//					failResp(response, ResultCode.TOKEN_EMPTY);
//                }
//            }
//        }
    }
	/**  
	* @Title: trimUrl  
	* @Description: 对url做处理，去除多余的/
	* @param @param requestURI    参数
	* @return void    返回类型  
	* @throws  
	*/
	private String trimUrl(String requestURI) {
		while(requestURI.startsWith("/")){
			requestURI = requestURI.substring(1);
		}
		requestURI = "/" + requestURI;
		return requestURI;
	}

	/**
	 * @param code   
	* @Title: failResp  
	* @Description: 校验不通过操作
	* @param @param response
	* @param @throws JSONException
	* @param @throws IOException    参数
	* @return void    返回类型  
	* @throws  
	*/
	private void failResp(HttpServletResponse response, ResultCode resultCode) {
		response.setContentType("application/json;charset=UTF-8");
		try {
			response.getWriter().write(Result.build(resultCode).toString());
		} catch (IOException e) {
			logger.error("返回错误结果失败", e);
		}finally{
			try {
				response.flushBuffer();
			} catch (IOException e) {
				logger.error("返回错误结果失败", e);
			}
		}
	}

	@Override
	public void init(FilterConfig filterConfig) {
		{
            if (unAuthUrl != null && unAuthUrl.trim().length() != 0) {
            	unAuthPattern = new HashSet<String>(Arrays.asList(unAuthUrl.split("\\s*,\\s*")));
            }
        }
		{
			contextPath=getContextPath(filterConfig.getServletContext());
			
		}
	}

	@Override
	public void destroy() {
	}
	
	
	public boolean isUnAuth(String requestURI) {
        if (unAuthPattern == null) {
            return false;
        }

        if (contextPath != null && requestURI.startsWith(contextPath)) {
            requestURI = requestURI.substring(contextPath.length());
            if (!requestURI.startsWith("/")) {
                requestURI = "/" + requestURI;
            }
        }

        for (String pattern : unAuthPattern) {
            if (pathMatcher.matches(pattern, requestURI)) {
                return true;
            }
        }
        return false;
    }
	
	    public static String getContextPath(ServletContext context) {
	        if (context.getMajorVersion() == 2 && context.getMinorVersion() < 5) {
	            return null;
	        }
	        try {
	            return getContextPath25(context);
	        } catch (NoSuchMethodError error) {
	            return null;
	        }
	    }
		  private static String getContextPath25(ServletContext context) {
		        String contextPath = context.getContextPath();
		        if (contextPath == null || contextPath.length() == 0) {
		            contextPath = "/";
		        }
		        return contextPath;
		    }
}
