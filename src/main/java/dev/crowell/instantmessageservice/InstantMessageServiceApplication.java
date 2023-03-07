package dev.crowell.instantmessageservice;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.config.EnableWebFlux;

@SpringBootApplication
@EnableWebFlux
public class InstantMessageServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(InstantMessageServiceApplication.class, args);
    }

    @Bean
    ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Bean
    public OpenAPI springShopOpenAPI() {
        return new OpenAPI()
                .info(new Info().title("CrowellChat Instant Message API")
                        .description("The API for the CrowellChat instant message service.")
                        .version("v0.1.0")
                        .license(new License().name("MIT").url("https://mit-license.org/")))
                .externalDocs(new ExternalDocumentation()
                        .description("CrowellChat Documentation")
                        .url("https://crowell.dev/crowellchat"));
    }
}
