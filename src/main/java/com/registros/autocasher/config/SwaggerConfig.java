
package com.registros.autocasher.config;


import java.util.ArrayList;
import org.springframework.context.annotation.Bean;

import org.springframework.context.annotation.Configuration;
import static springfox.documentation.builders.PathSelectors.regex;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
        public Docket registroApi(){
            return new Docket(DocumentationType.SWAGGER_2)
                    .select()
                    .apis(RequestHandlerSelectors.basePackage("com.registros.autocasher"))
                    .paths(regex("/api.*"))
                    .build()
                    .apiInfo(metaInfo());
        }
        
        private ApiInfo metaInfo(){
            ApiInfo apiInfo = new ApiInfo(
                    "Registros API REST",
                    "API REST de cadastro de registros.",
                    "1.0",
                    "Terms of Service",
                    new Contact("Amauri Barros", "https://www.github.com/melobarros", "barros.amauri@yahoo.com.br"),
                    "Apache Licence Version 2.0",
                    "https://www.apache.org",
                    new ArrayList<VendorExtension>()
            );
            
            return apiInfo;
        }
}
