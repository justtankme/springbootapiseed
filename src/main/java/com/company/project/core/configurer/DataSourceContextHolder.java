package com.company.project.core.configurer;

import com.company.project.core.common.DataSourceTypeEnum;

/**
 * 
* @ClassName: DataSourceContextHolder  
* @Description: 本地线程，数据源上下文。
* @author duanzhiwei
* @date 2018年1月18日 下午12:55:52  
*
 */
public class DataSourceContextHolder {

    /**
     * DATASOURCE_TYPE:用线程本地环境变量保存数据源的key
     */
    private static final ThreadLocal<String> DATASOURCE_TYPE = new ThreadLocal<String>();

    public static ThreadLocal<String> getLocal() {
        return DATASOURCE_TYPE;
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
        DATASOURCE_TYPE.set(DataSourceTypeEnum.read.getType());
    }

    /**
    * 数据库切换到写库
    * @Title: setWrite  
    * @param     参数
    * @return void    返回类型  
    * @throws
     */
    public static void setWrite() {
        DATASOURCE_TYPE.set(DataSourceTypeEnum.write.getType());
    }

    /**  
    * 数据库切换到指定数据源
    * @Title: set  
    * @param @param dataSourceType    参数
    * @return void    返回类型  
    * @throws  
    */
    public static void set(DataSourceTypeEnum dataSourceType) {
        DATASOURCE_TYPE.set(dataSourceType.getType());
    }

    /**  
    * 获取当前线程中设置的数据库类型
    * @Title: getReadOrWrite  
    * @param @return    参数
    * @return String    返回类型  
    * @throws  
    */
    public static String get() {
        return DATASOURCE_TYPE.get();
    }

    public static void clear() {
        DATASOURCE_TYPE.remove();
    }
}
