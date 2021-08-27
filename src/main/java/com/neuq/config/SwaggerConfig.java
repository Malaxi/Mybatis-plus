package com.neuq.config;

import io.swagger.annotations.Api;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

@Configuration
@EnableSwagger2//开启Swagger2
public class SwaggerConfig {
    @Bean //配置swagger2的Docket的bean实例
    public Docket api(Environment environment) {
        //设置自己想要判断的环境
        Profiles profiles = Profiles.of("dev","test");
        //判断当前项目环境是否处于自己想要判断的环境
        boolean flag = environment.acceptsProfiles(profiles);

        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                //通过当前项目所处环境判断是否启动Swagger,如果为false,则无法访问http://localhost:8080/swagger-ui.html
                .enable(flag)
                //配置API文档的分组
                .groupName("malax")
                //通过select方法来配置扫描接口
                .select()
                //************************很重要的配置****************************
                //RequestHandlerSelectors：配置扫描接口的方式
                //basePackage:扫描指定包下的接口
                .apis(RequestHandlerSelectors.basePackage("com.neuq.controller"))
                //PathSelectors：需要扫描的接口特征
                .paths(PathSelectors.any())
                //**************************************************************
                .build();
    }
    //配置Swagger的信息
    private ApiInfo apiInfo(){
        Contact contact = new Contact("Malax", "http://localhost:8080", "513341071@qq.com"); //作者信息
        return new ApiInfo(
                "Malax的Swagger API文档", // 标题
                "即使再小的帆也能远航", // 描述
                "v1.0", // 版本
                "http://terms.service.url", // 组织链接
                contact, // 作者信息
                "Apach 2.0 许可", // 许可
                "许可链接", // 许可连接
                new ArrayList<>()// 扩展
        );
    }

}

