package dev.jhon0206.spring_shield.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

  @Bean
  PasswordEncoder encoder() {
    return new BCryptPasswordEncoder();
  }

  @Bean
  SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    http
        .authorizeHttpRequests(
            auth -> auth.requestMatchers("demo/public").permitAll() // Sin iniciar sesión
                // Sesión iniciada y autorización de ADMIN
                .requestMatchers("demo/admin").hasAuthority("ADMIN")
                // Sesión iniciada y autorización de VENDOR
                .requestMatchers("demo/vendor").hasAuthority("VENDOR")
                // Sesión iniciada y autorización de ADMIN o VENDOR
                .requestMatchers("demo/worker").hasAnyAuthority("ADMIN", "VENDOR")
                // Sesión iniciada y autorización de CLIENT
                .requestMatchers("demo/client").hasAuthority("CLIENT")
                // Solo basta tener sesión iniciada
                .anyRequest().authenticated())
        .formLogin(Customizer.withDefaults());

    return http.build();
  }
}
