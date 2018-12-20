package com.company.project.core.common;

import tk.mybatis.mapper.common.BaseMapper;
import tk.mybatis.mapper.common.ConditionMapper;
import tk.mybatis.mapper.common.IdsMapper;
import tk.mybatis.mapper.common.special.InsertListMapper;

/**
 * 
* @ClassName: Mapper  
* @Description: 定制版MyBatis Mapper插件接口，如需其他接口参考官方文档自行添加。
* @author duanzhiwei
* @date 2018年1月16日 上午11:53:33  
*  
* @param <T>
 */
public interface Mapper<T>
        extends
        BaseMapper<T>,
        ConditionMapper<T>,
        IdsMapper<T>,
        InsertListMapper<T> {
}
