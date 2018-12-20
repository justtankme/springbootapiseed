package com.company.project.core.aop;

import org.aspectj.lang.annotation.Before;

import com.company.project.core.configurer.DataSourceContextHolder;


/**
 * 
* @ClassName: DataSourceAopInDao  
* @Description: 在dao层决定数据源(注：如果用这方式，service层不能使用事务，否则出问题，因为打开事务打开时，就会觉得数据库源了）
* 暂时关闭，代码保留
* @author duanzhiwei
* @date 2018年1月18日 下午2:59:49  
*
 */
//@Aspect
//@Component
public class DataSourceAopInDao {

//	private static Logger log = LoggerFactory.getLogger(DataSourceAopInDao.class);
	
	@Before("execution(* com.real.springboot.dao..*.find*(..)) "
			+ " or execution(* com.real.springboot.dao..*.get*(..)) "
			+ " or execution(* com.real.springboot.dao..*.query*(..))")
    public void setReadDataSourceType() {
        DataSourceContextHolder.setRead();
    }

    @Before("execution(* com.real.springboot.dao..*.insert*(..)) "
    		+ " or execution(* com.real.springboot.dao..*.update*(..))"
    		+ " or execution(* com.real.springboot.dao..*.add*(..))")
    public void setWriteDataSourceType() {
        DataSourceContextHolder.setWrite();
    }

}
