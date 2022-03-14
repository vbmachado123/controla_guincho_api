package br.com.tevitto.controla_guincho.config.swagger;


import br.com.tevitto.controla_guincho.data.model.User;
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
public class SwaggerConfigurations {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
//                .apis(RequestHandlerSelectors.basePackage("br.com.tevitto.controla_guincho"))
//                .paths(PathSelectors.ant("/**"))
                .build()
                .ignoredParameterTypes(User.class);
//                .globalOperationParameters(Arrays.asList(
//                        new ParameterBuilder()
//                                .name("Authorization")
//                                .description("Header para o token JWT")
//                                .modelRef(new ModelRef("string"))
//                                .parameterType("header")
//                                .required(false)
//                                .build()));
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("teVitto API")
                .description("teVitto API reference for developers")
                .termsOfServiceUrl("https://tevitto.com/")
                .contact(new Contact("teVitto Inc.", "https://tevitto.com", "code@tevitto.com")).license("teVitto MIT")
//                .contact("javainuse@gmail.com").license("JavaInUse License")
                .licenseUrl("code@tevitto.com").version("1.0.1").build();
    }


}

