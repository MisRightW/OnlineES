//package com.haigui.config;
//
//import io.swagger.annotations.ApiOperation;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import springfox.documentation.builders.ApiInfoBuilder;
//import springfox.documentation.builders.PathSelectors;
//import springfox.documentation.builders.RequestHandlerSelectors;
//import springfox.documentation.service.ApiInfo;
//import springfox.documentation.spi.DocumentationType;
//import springfox.documentation.spring.web.plugins.Docket;
//import springfox.documentation.swagger2.annotations.EnableSwagger2;
//
///**
// * @author fengl
// */
//@Configuration
//@EnableSwagger2
//@Slf4j
//public class SwaggerConfig {
//
//    @Bean
//    public Docket createRestApi() {
//        log.info("开始加载Swagger配置");
//        return new Docket(DocumentationType.SWAGGER_2)
//                .apiInfo(apiInfo())
//                .select()
////                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))  //添加ApiOperiation注解的被扫描
//                .apis(RequestHandlerSelectors.basePackage("com.haigui.controller"))  //添加ApiOperiation注解的被扫描
//                .paths(PathSelectors.any())
//                .build();
//    }
//
//    private ApiInfo apiInfo() {
//        return new ApiInfoBuilder().title("执恢档案管理系统接口").description("执恢档案管理系统接口文档").license("8888")
//                .build();
//    }
//
//}
