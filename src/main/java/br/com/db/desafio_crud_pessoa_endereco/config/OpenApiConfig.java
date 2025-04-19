package br.com.db.desafio_crud_pessoa_endereco.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("API de Gerenciamento de Pessoas e Endereços")
                        .version("1.0.0")
                        .description("API REST com Spring Boot para gerenciar entidades Pessoa e Endereço")
                        .contact(new Contact()
                                .name("Yuri Capella")
                                .email("yuricapelladossantos@gmail.com"))
                        .license(new License()
                            .name("Apache 2.0")
                            .url("https://springdoc.org")));
    }
}
