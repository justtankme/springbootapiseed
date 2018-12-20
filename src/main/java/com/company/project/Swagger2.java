package com.company.project;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.company.project.core.common.ProjectConstant;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 
 * @author duanzhiwei
 *
 */
@Configuration
@EnableSwagger2
public class Swagger2 {
    Logger logger = LoggerFactory.getLogger(Swagger2.class);
    
    @Value(value = "${spring.swagger.enable}")
    private Boolean swaggerEnable;
    @Bean
    public Docket createRestApi() {
        logger.info("swagger组件开启状态：" + swaggerEnable);
        String baskPackage = "do.not.show.swagger";
//        if (swaggerEnable != null && swaggerEnable.booleanValue()) {
            baskPackage = ProjectConstant.CONTROLLER_PACKAGE;
//        }
        //增加全局token请求头
        List<Parameter> operationParameters = new ArrayList<>();
        Parameter e = new ParameterBuilder()
        		.name(ProjectConstant.TOKEN_HEADER)
        		.description("令牌")
        		.modelRef(new ModelRef("string"))
        		.parameterType("header")
        		.required(false)
        		.build();  
		operationParameters.add(e);
		return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage(baskPackage))
                .paths(PathSelectors.any())
                .build()
                .enable(swaggerEnable)
                .globalOperationParameters(operationParameters);
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Spring Boot中使用Swagger2构建RESTful APIs")
                .description("")
                .version("1.0")
                .build();
    }

}