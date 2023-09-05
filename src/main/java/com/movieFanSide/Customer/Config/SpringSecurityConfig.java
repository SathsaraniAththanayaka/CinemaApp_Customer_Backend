package com.movieFanSide.Customer.Config;

import com.movieFanSide.Customer.Service.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import javax.annotation.Resource;
import java.util.Arrays;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig {
    @Resource
    CustomUserDetailsService customUserDetailsService;

    @Autowired
    PasswordEncoder passwordEncoder;


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        return http.cors().and().csrf().disable().authorizeRequests()
                .antMatchers("/customer/register","/customer/login").permitAll()
                .antMatchers("/customer/edit").authenticated()
                .antMatchers("/customer/details","/customer/confirm","/customer/bookings","/customer/kafka/publish","/customer/kafka/bookingsConfirm","/customer/kafka/bookings","/customer/movie","/customer/shows","/customer/seat").permitAll()
                .anyRequest().authenticated()
                .and()
                .httpBasic() // Use HTTP Basic authentication
                .and()
                .formLogin()
                .and()



        .build();

    }

    @Bean
    AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider provider
                = new DaoAuthenticationProvider();
        provider.setUserDetailsService(customUserDetailsService);
        provider.setPasswordEncoder(passwordEncoder);
        return  provider;
    }

    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.addAllowedOrigin("http://localhost:3000"); // Allow requests from frontend
        config.addAllowedMethod("*"); // Allow all HTTP methods
        config.addAllowedHeader("*"); // Allow all headers
        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }

}
