package br.com.tevitto.controla_guincho.config.swagger;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    @Bean
    public GroupedOpenApi publicApi() {
        return GroupedOpenApi.builder()
                .group("controla-guincho-api")
                .pathsToMatch("/api/v1/**")
                .build();
    }

    @Bean
    public OpenAPI apiInfo() {
        return new OpenAPI()
                .info(new Info()
                        .title("teVitto API")
                        .description("teVitto API reference for developers")
                        .termsOfService("https://tevitto.com/")
                        .contact(new Contact()
                                .name("teVitto Inc.")
                                .url("https://tevitto.com")
                                .email("code@tevitto.com")).license(new License().name("teVitto MIT"))
                );
    }
}