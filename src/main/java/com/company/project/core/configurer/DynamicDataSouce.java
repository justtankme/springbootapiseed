package com.company.project.core.configurer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import com.company.project.core.common.DataSourceTypeEnum;

/**  
* @ClassName: RoundRobinRoutingDataSouce  
* @Description: 读写分离+负载均衡实现类
* @author duanzhiwei
* @date 2018年1月18日 下午1:07:14  
*    
*/
public class DynamicDataSouce extends AbstractRoutingDataSource {
    private static final Logger logger = LoggerFactory.getLogger(DynamicDataSouce.class);

    /**
     * 通过读取本地线程中设置的LookupKey，让AbstractRoutingDataSource从targetDataSources中选择对应的数据源。
     * 每次获取数据库连接都会执行该方法
     * targetDataSources在MybatisConfigurer中设置
     * @see org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource#determineCurrentLookupKey()
     */
    @Override
    protected Object determineCurrentLookupKey() {
        String typeKey = DataSourceContextHolder.get();
        if(typeKey == null){
            //默认为写库
            if (logger.isDebugEnabled()) {
                logger.debug("未指定数据库，默认使用写数据库");
            }
            return DataSourceTypeEnum.write.getType();
        }
        if (logger.isDebugEnabled()) {
            logger.debug("使用{}",DataSourceTypeEnum.valueOf(typeKey).getName());
        }
        return typeKey;
    }
}
