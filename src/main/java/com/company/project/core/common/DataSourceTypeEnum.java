package com.company.project.core.common;

/**  
* @ClassName: DataSourceTypeEnum  
* @Description: 数据源枚举
* @author duanzhiwei
* @date 2018年1月24日 上午10:17:30  
*    
*/
public enum DataSourceTypeEnum {
    /**
     * write:主库，写
     */
    write("write", "主库"),
    /**
     * read:从库，读
     */
    read("read", "从库"),
    /**
     * log:日志库
     */
    log("log", "日志库"),
    /**
     * quartz:定时任务
     */
    quartz("quartz", "定时任务");
    
    private String type;

    private String name;

    DataSourceTypeEnum(String type, String name) {
        this.type = type;
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
