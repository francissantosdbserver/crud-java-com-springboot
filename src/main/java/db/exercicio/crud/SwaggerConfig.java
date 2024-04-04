package db.exercicio.crud;

//
//import jakarta.servlet.ServletContext;
//import org.springframework.beans.factory.InitializingBean;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
//import org.springframework.web.servlet.mvc.method.RequestMappingInfoHandlerMapping;
//import springfox.documentation.builders.PathSelectors;
//import springfox.documentation.builders.RequestHandlerSelectors;
//import springfox.documentation.spi.DocumentationType;
//import springfox.documentation.spi.service.RequestHandlerProvider;
//import springfox.documentation.spring.web.WebMvcRequestHandler;
//import springfox.documentation.spring.web.plugins.Docket;
//import springfox.documentation.spring.web.plugins.DocumentationPluginsBootstrapper;
//import springfox.documentation.spring.web.plugins.WebMvcRequestHandlerProvider;
//import springfox.documentation.spring.web.readers.operation.HandlerMethodResolver;
//import springfox.documentation.swagger2.annotations.EnableSwagger2;
//
//import java.util.List;
//import java.util.Optional;
//import java.util.Set;
//
//import static java.util.stream.Collectors.toList;
//import static springfox.documentation.RequestHandler.byPatternsCondition;
//import static springfox.documentation.spring.web.paths.Paths.ROOT;
//
//@EnableSwagger2
//public class SwaggerConfig {
////
////    @Bean
////    public InitializingBean removeSpringfoxHandlerProvider(DocumentationPluginsBootstrapper bootstrapper) {
////        return () -> bootstrapper.getHandlerProviders().removeIf(WebMvcRequestHandlerProvider.class::isInstance);
////    }
////    @Bean
////    public RequestHandlerProvider customRequestHandlerProvider(Optional<ServletContext> servletContext, HandlerMethodResolver methodResolver, List<RequestMappingInfoHandlerMapping> handlerMappings) {
////        String contextPath = servletContext.map(ServletContext::getContextPath).orElse(ROOT);
////        return () -> handlerMappings.stream()
////                .filter(mapping -> !mapping.getClass().getSimpleName().equals("IntegrationRequestMappingHandlerMapping"))
////                .map(mapping -> mapping.getHandlerMethods().entrySet())
////                .flatMap(Set::stream)
////                .map(entry -> new WebMvcRequestHandler(contextPath, methodResolver, tweakInfo(entry.getKey()), entry.getValue()))
////                .sorted(byPatternsCondition())
////                .collect(toList());
////    }
////    RequestMappingInfo tweakInfo(RequestMappingInfo info) {
////        if (info.getPathPatternsCondition() == null) return info;
////        String[] patterns = info.getPathPatternsCondition().getPatternValues().toArray(String[]::new);
////        return info.mutate().options(new RequestMappingInfo.BuilderConfiguration()).paths(patterns).build();
////    }
//
//    @Bean
//    public Docket scheduleApi() {
//        return new Docket(DocumentationType.SWAGGER_2)
//                .select()
//                .apis(RequestHandlerSelectors.any())
//                .paths(PathSelectors.any())
//                .build();
//    }
//}


import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    private static final String BEARER_AUTH = "Bearer ";

    @Bean
    public OpenAPI testOpenAPIDefinition() {

        return new OpenAPI()
                .info(new io.swagger.v3.oas.models.info.Info()
                        .title("API - Lar Certo Imóveis")
                        .contact(new Contact()
                                .name("Anderson Fuhr").email("andersonfuhr@yahoo.com.br"))
                        .description("Aplicação para controle de imóveis")
                        .version("v0.0.1"))
                .externalDocs(new ExternalDocumentation()
                        .description("Repositório Desta API no GitHub")
                        .url("https://github.com/fuhr-br"))
                .addSecurityItem(new SecurityRequirement()
                        .addList(BEARER_AUTH))
                .components(new Components()
                        .addSecuritySchemes(BEARER_AUTH, new SecurityScheme()
                                .name(BEARER_AUTH)
                                .type(SecurityScheme.Type.HTTP)
                                .scheme("bearer")
                                .bearerFormat("JWT")));
    }

}