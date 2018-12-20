package com.company.project.core.configurer;

import org.apache.commons.lang3.StringUtils;
import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.redisson.config.SentinelServersConfig;
import org.redisson.config.SingleServerConfig;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.company.project.core.properties.AddListTest;
import com.company.project.core.properties.RedissonProperties;

@Configuration
@ConditionalOnClass(Config.class)
public class RedissonAutoConfiguration {
    /**
     * 哨兵模式自动装配
     * @return
     */
    @Bean
    @ConditionalOnProperty(name="redisson.master-name")
    RedissonClient redissonSentinel(RedissonProperties redssionProperties) {
        Config config = new Config();
        SentinelServersConfig serverConfig = config.useSentinelServers().addSentinelAddress(redssionProperties.getSentinelAddresses())
                .setMasterName(redssionProperties.getMasterName())
                .setTimeout(redssionProperties.getTimeout())
                .setMasterConnectionPoolSize(redssionProperties.getMasterConnectionPoolSize())
                .setSlaveConnectionPoolSize(redssionProperties.getSlaveConnectionPoolSize());
        
        if(StringUtils.isNotBlank(redssionProperties.getPassword())) {
            serverConfig.setPassword(redssionProperties.getPassword());
        }
        return Redisson.create(config);
    }

    /**
     * 单机模式自动装配
     * @return
     */
    @Bean
    @ConfigurationProperties(prefix = "redisson.singleServerConfig")
    RedissonProperties getRedssionProperties() {
    		return new RedissonProperties();
    }
    @Bean
    @ConfigurationProperties
    AddListTest getRedssionPropertiesxx() {
    	return new AddListTest();
    }

    @Bean
    RedissonClient redissonSingle(RedissonProperties redssionProperties) {
        Config config = new Config();
        SingleServerConfig serverConfig = config.useSingleServer()
                .setAddress(redssionProperties.getAddress())
                .setTimeout(redssionProperties.getTimeout())
                .setConnectionPoolSize(redssionProperties.getConnectionPoolSize())
                .setConnectionMinimumIdleSize(redssionProperties.getConnectionMinimumIdleSize());
        
        if(StringUtils.isNotBlank(redssionProperties.getPassword())) {
            serverConfig.setPassword(redssionProperties.getPassword());
        }

        return Redisson.create(config);
    }
}