package br.com.tevitto.controla_guincho;

import br.com.tevitto.controla_guincho.config.file.FileStorageProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

import java.time.LocalDateTime;

@SpringBootApplication
@EnableCaching
@EnableSpringDataWebSupport
@EnableConfigurationProperties({
        FileStorageProperties.class
})
public class Startup {

    public static void main(String[] args) {
        SpringApplication.run(Startup.class, args);

        System.out.println("> Iniciado  " + LocalDateTime.now());
    }
}
