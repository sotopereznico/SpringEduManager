package cl.unitec.springedumanager.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    // 1. Configuración de Usuarios en memoria
    @Bean
    public InMemoryUserDetailsManager userDetailsService() {
        // Usuario normal
        UserDetails usuario = User.withUsername("user")
            .password("{noop}user123") // {noop} indica que la contraseña no está encriptada (solo para pruebas)
            .roles("USER")
            .build();
        
        // Usuario administrador
        UserDetails administrador = User.withUsername("admin")
            .password("{noop}admin123")
            .roles("ADMIN", "USER")
            .build();
        
        return new InMemoryUserDetailsManager(usuario, administrador);
    }

    // 2. Configuración de Rutas y Permisos
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable()) // Deshabilitado temporalmente para permitir POST desde nuestros formularios simples
            .authorizeHttpRequests(auth -> auth
            	.requestMatchers("/api/**").permitAll()
                .requestMatchers(HttpMethod.POST, "/cursos/guardar").hasRole("ADMIN")
                .anyRequest().authenticated() 
            )
            .formLogin(form -> form
            	    .permitAll()
            	    .defaultSuccessUrl("/estudiantes", true))
            .logout(logout -> logout.permitAll());
        
        return http.build();
    }
}