package com.company.project.core.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.company.project.core.common.DataSourceTypeEnum;

/**  
* @ClassName: SpecifiedDataSource  
* @Description: 手动指定数据源
* @author duanzhiwei
* @date 2018年1月24日 上午10:00:10  
*    
*/
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface SpecifiedDataSource {
    /**  
    * 指定数据源
    * @Title: dataSourceType  
    * @param @return    参数
    * @return DataSourceType    返回类型  
    * @throws  
    */
    DataSourceTypeEnum dataSourceType(); 
}
