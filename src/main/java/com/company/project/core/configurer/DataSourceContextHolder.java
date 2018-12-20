package com.company.project.core.configurer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.company.project.core.common.DataSourceType;

/**
 * 
* @ClassName: DataSourceContextHolder  
* @Description: 本地线程，数据源上下文。
* @author duanzhiwei
* @date 2018年1月18日 下午12:55:52  
*
 */
public class DataSourceContextHolder {

	private static Logger log = LoggerFactory.getLogger(DataSourceContextHolder.class);
	
	//线程本地环境
	private static final ThreadLocal<String> local = new ThreadLocal<String>();

    public static ThreadLocal<String> getLocal() {
        return local;
    }

    /**
     * 
    * 数据库切换到读库
    * @Title: setRead  
    * @param     参数
    * @return void    返回类型  
    * @throws
     */
    public static void setRead() {
        local.set(DataSourceType.read.getType());
        log.info("数据库切换到读库...");
    }

    /**
    * 数据库切换到写库
    * @Title: setWrite  
    * @param     参数
    * @return void    返回类型  
    * @throws
     */
    public static void setWrite() {
        local.set(DataSourceType.write.getType());
        log.info("数据库切换到写库...");
    }

    /**  
    * 获取当前线程中设置的数据库类型
    * @Title: getReadOrWrite  
    * @param @return    参数
    * @return String    返回类型  
    * @throws  
    */
    public static String getReadOrWrite() {
        return local.get();
    }
    
    public static void clear(){
    	local.remove();
    }
}
