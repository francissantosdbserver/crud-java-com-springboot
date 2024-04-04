package db.exercicio.crud.service;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@Configuration
@EnableWebSecurity
public class WebSecurityConfiguration {
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().requestMatchers("/swagger-ui/**", "/v3/api-docs/**").anyRequest();
    }
}