package com.example.cloud.feign;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration//等价于XML中配置beans，
@EnableSwagger2//表示开启Swagger，也可以Application.class 加上注解@EnableSwagger2
public class Swagger2 {

   //用@Bean标注方法等价于XML中配置bean。
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.example.cloud"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("新一代UI服务平台")
                .description("更多UI服务请关注：www.baidu.com")
                .termsOfServiceUrl("www.2345.com")
                .contact("QTS")
                .version("1.0")
                .build();
    }
}
