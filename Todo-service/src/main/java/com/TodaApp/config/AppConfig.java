package com.TodaApp.config;


import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.servers.Server;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
@RequiredArgsConstructor
@OpenAPIDefinition(
        info = @Info(
                title = "OpenApi for Toda-App",
                version = "1.00",
                description = "Open api for Todo-service as a part of Toda-App",
                termsOfService = "Terms of service",
                contact = @Contact(
                        name = "amr",
                        email = "amr.elhady@gmail.com"
                ),
                license = @License(
                        name = "licence name",
                        url = "https://url.com"
                )
        ),
        servers = {
                @Server(
                        description = "local host",
                        url = "http://localhost:7070"
                )
        }
)

public class AppConfig {
    @Bean
    RestTemplate restTemplate() {
        return new RestTemplate();
    }



}
