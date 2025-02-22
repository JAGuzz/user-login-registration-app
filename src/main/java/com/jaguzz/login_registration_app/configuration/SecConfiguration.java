package com.jaguzz.login_registration_app.configuration;

import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.jaguzz.login_registration_app.service.UserService;

@Configuration
public class SecConfiguration {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth -> auth
                                .requestMatchers("/registration**",
                                "/js/**",
                                "/css/**",
                                "/img/**").permitAll().anyRequest().authenticated() // Permite acceso a todas las rutas indicadas
                )
                .formLogin(login -> login
                    .loginPage("/login")
                    .permitAll())
                .logout(logout -> logout
                    .invalidateHttpSession(true)
                    .clearAuthentication(true)
                    .logoutUrl("/logout")
                    .logoutSuccessUrl("/login?logout")
                    .permitAll())
                .csrf(csrf -> csrf.disable()); // Desactiva CSRF para evitar problemas en pruebas

        return http.build();
    }

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userService);
        authProvider.setPasswordEncoder(passwordEncoder);
        return authProvider;
    }

    @Autowired
    private UserService userService;

}
