package com.company.project.core.common;


import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.apache.ibatis.exceptions.TooManyResultsException;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * 
* @ClassName: AbstractService  
* @Description: 基于通用MyBatis Mapper插件的Service接口的实现
* @author duanzhiwei
* @date 2018年1月16日 上午11:53:42  
*  
* @param <T>
 */
public abstract class AbstractIBaseService<T> implements IBaseService<T> {
}
