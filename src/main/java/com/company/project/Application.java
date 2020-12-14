package com.company.project;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceAutoConfigure;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**  
* @ClassName: Application  
* @Description: 应用主类
* @author duanzhiwei
* @date 2018年1月16日 下午12:02:56  
*    
*/
//多数据源组件需要排除原生Druid的快速配置类
@SpringBootApplication(exclude = DruidDataSourceAutoConfigure.class)
@MapperScan("com.company.project.*.mapper")
public class Application{
    public static void main(String[] args) {
    	SpringApplication.run(Application.class, args);
    }
}
