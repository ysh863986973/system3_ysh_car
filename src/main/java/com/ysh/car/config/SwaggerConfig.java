package com.ysh.car.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 易水寒
 * @version : 1.0.1
 * @date : 2019/12/10/17:40
 */
@Configuration
public class SwaggerConfig {
    //创建文档说明
    public ApiInfo createAI() {
        ApiInfo apiInfo = new ApiInfoBuilder().title("Yard项目后端数据接口")
                .description("包含Yard的主站和后台系统的所以接口信息，可以查看对应的接口信息和对接口进行测试")
                .contact(new Contact("Ysh", "http://www.baidu.com", "1756335900@qq.com")).build();

        return apiInfo;
    }

    //创建Swagger扫描信息
    @Bean
    public Docket createD() {
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(createAI()).select()
                .apis(RequestHandlerSelectors.basePackage("com.ysh.car")).build();
    }
}
