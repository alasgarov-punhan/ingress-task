package com.alasgarov.mspost.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "ms-post API",
                description = "This is a sample Rest api Service"),
        servers = @Server(url = "http://localhost:8080"))
public class OpenApiConfiguration {
}
