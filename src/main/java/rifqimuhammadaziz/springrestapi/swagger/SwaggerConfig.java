package rifqimuhammadaziz.springrestapi.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    /*
    API Documentation
    http://localhost:8080/swagger-ui/index.html
     */

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("rifqimuhammadaziz.springrestapi.controller"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        ApiInfo apiInfo = new ApiInfo(
                "RestAPI",
                "This page is documentation for Spring RestAPI by Rifqi Muhammad Aziz",
                "V1.0.0",
                "Term of Service URL",
                new Contact("Rifqi Muhammad Aziz", "rifqimuhammadaziz@gmail.com", "rifqimuhammadaziz@gmail.com"),
                "Spring Framework & Apache License",
                "spring.io",
                Collections.emptyList()
        );
        return apiInfo;
    }
}
