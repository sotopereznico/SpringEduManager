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
                .requestMatchers("/css/**").permitAll() 
                .requestMatchers("/api/**").permitAll() 
                .requestMatchers(HttpMethod.POST, "/cursos/guardar").hasRole("ADMIN") 
                .requestMatchers(HttpMethod.POST, "/evaluaciones/guardar").hasRole("ADMIN")
                .requestMatchers(HttpMethod.POST, "/estudiantes/eliminar", "/cursos/eliminar", "/evaluaciones/eliminar").hasRole("ADMIN")
                .anyRequest().authenticated() 
            )
            .formLogin(form -> form
                .loginPage("/login")
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