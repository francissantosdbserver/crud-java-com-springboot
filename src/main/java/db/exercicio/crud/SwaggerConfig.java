package db.exercicio.crud;

import io.swagger.v3.oas.models.OpenAPI;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI testOpenAPIDefinition() {

        return new OpenAPI();
    }
}

//                .info(new io.swagger.v3.oas.models.info.Info()
//                        .title("API - Lar Certo Imóveis")
//                        .contact(new Contact()
//                                .name("").email(""))
//                        .description("")
//                        .version("v0.0.1"))
//                .externalDocs(new ExternalDocumentation()
//                        .description("")
//                        .url(""))
//                .addSecurityItem(new SecurityRequirement()
//                        .addList(BEARER_AUTH))
//                .components(new Components()
//                        .addSecuritySchemes(BEARER_AUTH, new SecurityScheme()
//                                .name(BEARER_AUTH)
//                                .type(SecurityScheme.Type.HTTP)
//                                .scheme("bearer")
//                                .bearerFormat("JWT")));
