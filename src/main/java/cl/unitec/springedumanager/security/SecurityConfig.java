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

    @Bean
    public InMemoryUserDetailsManager userDetailsService() {
        // Usuarios idénticos a los del documento del profesor
        UserDetails usuario = User.withUsername("alumno@clase.cl")
            .password("{noop}1234")
            .roles("USER")
            .build();
        
        UserDetails administrador = User.withUsername("admin@clase.cl")
            .password("{noop}admin123")
            .roles("ADMIN", "USER")
            .build();
        
        return new InMemoryUserDetailsManager(usuario, administrador);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable())
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/css/**").permitAll() // 1. CSS libre para todos
                .requestMatchers("/api/**").permitAll() // 2. APIs libres
                .requestMatchers(HttpMethod.POST, "/cursos/guardar").hasRole("ADMIN") // Solo Admin
                .requestMatchers(HttpMethod.POST, "/evaluaciones/guardar").hasRole("ADMIN") // Solo Admin
                .requestMatchers(HttpMethod.POST, "/estudiantes/eliminar", "/cursos/eliminar", "/evaluaciones/eliminar").hasRole("ADMIN")
                .anyRequest().authenticated() // 3. Todo lo demás requiere login
            )
            .formLogin(form -> form
                .loginPage("/login") // Le decimos a Spring que use NUESTRA pantalla de login
                .permitAll()
                .defaultSuccessUrl("/estudiantes", true)
            )
            .logout(logout -> logout
                .logoutSuccessUrl("/login?logout")
                .permitAll()
            );
        
        return http.build();
    }
}