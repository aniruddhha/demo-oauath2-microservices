package com.ani.machine.security;

import com.ani.machine.converter.KeycloakRealmRoleConverter;
import com.ani.machine.converter.UsernameSubClaimConverter;
import org.springframework.boot.autoconfigure.security.oauth2.resource.OAuth2ResourceServerProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.JwtDecoders;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.oauth2ResourceServer()
                .jwt()
                .jwtAuthenticationConverter(
                        jwtAuthenticationConverter()
                );

        http.authorizeRequests().anyRequest().authenticated();
    }

    private JwtAuthenticationConverter jwtAuthenticationConverter() {
        JwtAuthenticationConverter converter = new JwtAuthenticationConverter();
        converter.setJwtGrantedAuthoritiesConverter(new KeycloakRealmRoleConverter());
        return converter;
    }

    @Bean
    public JwtDecoder decodeByIssuerUri(OAuth2ResourceServerProperties properties) {
        String issuerUri = properties.getJwt().getIssuerUri();
        NimbusJwtDecoder decoder = (NimbusJwtDecoder) JwtDecoders.fromIssuerLocation(issuerUri);
        decoder.setClaimSetConverter(new UsernameSubClaimConverter());
        return decoder;
    }
}
