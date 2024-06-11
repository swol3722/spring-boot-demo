package dev.wolffcode.spring_boot_demo.configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
  @Bean
  public OpenAPI openAPI() {
    return new OpenAPI()
        .info(
            new Info()
                .title("Spring Boot Demo API Documentation")
                .version("0.0.1-SNAPSHOT")
                .description(
                    "This is a sample Spring Boot RESTful service using springdoc-openapi and OpenAPI 3.")
                .contact(new Contact().name("Shane Wolff").email("wolffshane@gmail.com")));
  }
}
