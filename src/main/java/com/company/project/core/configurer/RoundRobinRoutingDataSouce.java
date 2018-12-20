package com.company.project.core.configurer;

import java.util.concurrent.atomic.AtomicInteger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.company.project.core.common.DataSourceType;

/**  
* @ClassName: RoundRobinRoutingDataSouce  
* @Description: 读写分离+负载均衡实现类
* @author duanzhiwei
* @date 2018年1月18日 下午1:07:14  
*    
*/
public class RoundRobinRoutingDataSouce extends AbstractRWRoutingDatasource {
    private static final Logger logger = LoggerFactory.getLogger(MybatisConfigurer.class);

    private AtomicInteger count = new AtomicInteger(0);

    private int readDsSize;

    public RoundRobinRoutingDataSouce(int size){
        this.readDsSize = size;
    }

    @Override
    protected int getReadDsSize() {
        return this.readDsSize;
    }

    @Override
    protected Object loadBalance() {
        //读库， 简单负载均衡
        int lookupKey = Math.abs(count.incrementAndGet()) % getReadDsSize();
        logger.debug("使用数据库read-"+(lookupKey));
        return lookupKey;
    }

    /**
     * 通过读取本地线程中设置的LookupKey，让AbstractRoutingDataSource从targetDataSources中选择对应的数据源。
     * 每次获取数据库连接都会执行该方法
     * targetDataSources在MybatisConfigurer中设置
     * @see org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource#determineCurrentLookupKey()
     */
    @Override
    protected Object determineCurrentLookupKey() {
        String typeKey = DataSourceContextHolder.getReadOrWrite();

        if(typeKey == null){
            //默认为写库
            logger.debug("未指定数据库，默认使用写数据库");
            return DataSourceType.write.getType();
//            throw new NullPointerException("数据库路由时，决定使用哪个数据库源类型不能为空...");
        }

        if (typeKey.equals(DataSourceType.write.getType())){
            logger.debug("使用写数据库");
            return DataSourceType.write.getType();
        }else{
            logger.debug("使用读数据库");
//            return loadBalance();
            return DataSourceType.read.getType();
        }
    }
}
