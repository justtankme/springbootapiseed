package com.company.project;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**  
* @ClassName: Application  
* @Description: 应用主类
* @author duanzhiwei
* @date 2018年1月16日 下午12:02:56  
*    
*/
@SpringBootApplication
@EnableTransactionManagement(order = 10)
public class Application extends SpringBootServletInitializer {
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(this.getClass());
    }

    //	@Value("${token.filter.unauthurl}")
    //	private String unAuthUrl;
    //	@Autowired
    //	private TokenService tokenService;
    //	@Bean
    //    public FilterRegistrationBean tokenFilterRegist() {
    //        FilterRegistrationBean registration = new FilterRegistrationBean();
    //        registration.setFilter(new TokenFilter(unAuthUrl, tokenService));
    //        registration.addUrlPatterns("/*");
    //        registration.setOrder(3);
    //        return registration;
    //    }

    public static void main(String[] args) {
        new SpringApplicationBuilder(Application.class).web(true).run(args);
    }
}
