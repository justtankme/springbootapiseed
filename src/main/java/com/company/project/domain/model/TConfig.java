package com.company.project.domain.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "t_config")
public class TConfig {
    @Id
    @Column(name = "config_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer configId;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "config_key")
    private String configKey;

    @Column(name = "config_value")
    private String configValue;

    /**
     * @return config_id
     */
    public Integer getConfigId() {
        return configId;
    }

    /**
     * @param configId
     */
    public void setConfigId(Integer configId) {
        this.configId = configId;
    }

    /**
     * @return create_time
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * @return config_key
     */
    public String getConfigKey() {
        return configKey;
    }

    /**
     * @param configKey
     */
    public void setConfigKey(String configKey) {
        this.configKey = configKey;
    }

    /**
     * @return config_value
     */
    public String getConfigValue() {
        return configValue;
    }

    /**
     * @param configValue
     */
    public void setConfigValue(String configValue) {
        this.configValue = configValue;
    }
}