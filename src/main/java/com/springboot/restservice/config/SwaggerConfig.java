package com.springboot.restservice.config;/* 
@Author : Yogesh Deshmukh
*/

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket api(){
        return  new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(getApiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.springboot.restservice"))
                .paths(PathSelectors.any())
                .build();
    }

    //Swagger Metadata : http://localhost:8080/v2/api-docs
    //Swagger UI URL : http://localhost:8080/swagger-ui.html

    private ApiInfo getApiInfo(){
        return new ApiInfoBuilder()
                .title("User Management Service")
                .description("Simple Spring Boot Basic Functionality")
                .version("1.0")
                .contact(new Contact("Yogesh Deshmukh", "https://www.linkedin.com/in/yogesh-deshmukh-02276397/","deshmukh.yogesh991@gmail.com"))
                .build();


    }
}
