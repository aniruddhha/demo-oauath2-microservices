package com.ani.security.config;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableWebSecurity
@Configuration
@AllArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {

//    private final PasswordEncoder encoder;
    private final DaoAuthenticationProvider provider;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable() // not recommended
                .authorizeRequests()
                .antMatchers("/", "index").permitAll()
//                .antMatchers("/api/machine/**").hasRole(AppRole.MACHINE.name())
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        super.configure(auth);
        auth.authenticationProvider(provider);
    }

    /*@Bean
    @Override
    protected UserDetailsService userDetailsService() {

        /*var machine = User.builder()
                .username("machine")
                .password(encoder.encode("123"))
//                .roles(AppRole.MACHINE.name())
                .authorities(AppRole.MACHINE.grantedAuthorities())
                .build();

        var worker = User.builder()
                .username("worker")
                .password(encoder.encode("123"))
                .authorities(AppRole.MACHINE_WORKER.grantedAuthorities())
                .build();

        return new InMemoryUserDetailsManager(
                machine, worker
        );
    }*/
}
