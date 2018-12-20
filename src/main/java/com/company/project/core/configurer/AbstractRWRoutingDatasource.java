package com.company.project.core.configurer;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;


/**  
* @ClassName: AbstractRWRoutingDatasource  
* @Description: 增加了对多个读库的支持，暂不使用
* @author duanzhiwei
* @date 2018年1月18日 下午1:04:24  
*    
*/
public abstract class AbstractRWRoutingDatasource extends AbstractRoutingDataSource {

    /**  
    * 获取读库数量
    * @Title: getReadDsSize  
    * @param @return    参数
    * @return int    返回类型  
    * @throws  
    */
    protected abstract int getReadDsSize();

    /**
     * 
    * 简单的负载均衡接口
    * @Title: loadBalance  
    * @param @return    参数
    * @return Object    返回类型  
    * @throws
     */
    protected abstract Object loadBalance();
}
