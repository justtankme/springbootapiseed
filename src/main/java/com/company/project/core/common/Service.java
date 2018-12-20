package com.company.project.core.common;

import org.apache.ibatis.exceptions.TooManyResultsException;
import tk.mybatis.mapper.entity.Condition;

import java.util.List;

/**
 * 
* @ClassName: Service  
* @Description: Service 层 基础接口，其他Service 接口 请继承该接口
* @author duanzhiwei
* @date 2018年1月16日 上午11:54:23  
*  
* @param <T>
 */
public interface Service<T> {
    /**  
    * 持久化
    * @Title: save  
    * @param @param model    参数
    * @return void    返回类型  
    * @throws  
    */
    void save(T model);

    /**  
    * 批量持久化
    * @Title: save  
    * @param @param models    参数
    * @return void    返回类型  
    * @throws  
    */
    void save(List<T> models);

    /**  
    * 通过主鍵刪除
    * @Title: deleteById  
    * @param @param id    参数
    * @return void    返回类型  
    * @throws  
    */
    void deleteById(String id);

    /**  
    * 批量刪除 eg：ids -> “1,2,3,4”
    * @Title: deleteByIds  
    * @param @param ids    参数
    * @return void    返回类型  
    * @throws  
    */
    void deleteByIds(String ids);

    /**  
    * 更新
    * @Title: update  
    * @param @param model    参数
    * @return void    返回类型  
    * @throws  
    */
    void update(T model);

    /**  
    * 通过ID查找
    * @Title: findById  
    * @param @param id
    * @param @return    参数
    * @return T    返回类型  
    * @throws  
    */
    T findById(String id);

    /**  
    * 通过Model中某个成员变量名称（非数据表中column的名称）查找,value需符合unique约束
    * @Title: findBy  
    * @param @param fieldName
    * @param @param value
    * @param @return
    * @param @throws TooManyResultsException    参数
    * @return T    返回类型  
    * @throws  
    */
    T findBy(String fieldName, Object value) throws TooManyResultsException;

    /**  
    * 通过多个ID查找//eg：ids -> “1,2,3,4”
    * @Title: findByIds  
    * @param @param ids
    * @param @return    参数
    * @return List<T>    返回类型  
    * @throws  
    */
    List<T> findByIds(String ids);

    /**  
    * 根据条件查找
    * @Title: findByCondition  
    * @param @param condition
    * @param @return    参数
    * @return List<T>    返回类型  
    * @throws  
    */
    List<T> findByCondition(Condition condition);

    /**  
    * 获取所有
    * @Title: findAll  
    * @param @return    参数
    * @return List<T>    返回类型  
    * @throws  
    */
    List<T> findAll();
}
