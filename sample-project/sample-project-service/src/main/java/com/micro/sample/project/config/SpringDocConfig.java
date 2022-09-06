package com.micro.sample.project.config;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.collect.Lists;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.security.SecurityScheme.In;
import io.swagger.v3.oas.models.security.SecurityScheme.Type;
import io.swagger.v3.oas.models.servers.Server;

@Configuration
public class SpringDocConfig {

    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI().info(getInfo()).servers(getServers())
                .addSecurityItem(getSecurity()).components(getComponents());
    }

    public Components getComponents() {
        // 方式一
        SecurityScheme httpScheme = new SecurityScheme()
                .name("Authorization").type(Type.HTTP).in(In.HEADER).scheme("Bearer")
                .description("http授权模式，auth header：Authorization， 不需要Bearer前缀");

        // 方式二
//        SecurityScheme apiKeyScheme = new SecurityScheme().name("apiKey").type(Type.APIKEY)
//                .description("这是apikey的方式").scheme("bearer").bearerFormat("Jwt");
        return new Components().addSecuritySchemes("httpBearer", httpScheme);
    }

    public List<Server> getServers() {
        List<Server> servers = Lists.newArrayList();
        servers.add(new Server().url("http://127.0.0.1:9001/sample").description("127.0.0.1"));
        servers.add(new Server().url("http://localhost:9001/sample").description("localhost"));
        return servers;
    }

    public SecurityRequirement getSecurity() {
        return new SecurityRequirement().addList("httpBearer");
    }

    public Info getInfo() {
        return new Info().title("sample-project")
                .contact(getContact())
                .license(new License().url("https://sample.project.com"))
                .description("sample-project")
                .version("1.0.1");
    }

    public Contact getContact() {
        return new Contact().email("sample-project@outlook.com")
                .name("project").url("https://sample.project.com");
    }

}
