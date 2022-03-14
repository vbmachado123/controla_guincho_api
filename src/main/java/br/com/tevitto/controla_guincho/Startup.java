package br.com.tevitto.controla_guincho;

import br.com.tevitto.controla_guincho.config.file.FileStorageProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;

import java.time.LocalDateTime;

@SpringBootApplication
@EnableCaching
@EnableSpringDataWebSupport
@EnableAutoConfiguration
@ComponentScan
@EnableSwagger2
@EnableConfigurationProperties({
        FileStorageProperties.class
})
public class Startup {

    public static void main(String[] args) {
        SpringApplication.run(Startup.class, args);

        System.out.println("> Iniciado  " + LocalDateTime.now());
    }
}
