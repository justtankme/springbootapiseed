package com.company.project;

import com.company.project.core.common.ProjectConstant;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.*;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.RequestParameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author duanzhiwei
 *
 */
@Configuration
@EnableOpenApi
public class Swagger {
    Logger logger = LoggerFactory.getLogger(Swagger.class);

    @Bean
    public Docket createRestApi() {

        //增加全局token请求头
        List<RequestParameter> operationParameters = new ArrayList<>();
        RequestParameter requestParameter = new RequestParameterBuilder()
        		.name(ProjectConstant.TOKEN_HEADER)
        		.description("令牌")
        		.required(false)
        		.build();
		operationParameters.add(requestParameter);
        return new Docket(DocumentationType.OAS_30)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                .paths(PathSelectors.any())
                .build()
                .globalRequestParameters(operationParameters)
                ;
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Swagger3接口文档")
                .description("更多请咨询服务开发者")
                .contact(new Contact("duanzhiwei", "http://www.dogedoge.com", "714817269@qq.com"))
                .version("1.0")
                .build();
    }
}