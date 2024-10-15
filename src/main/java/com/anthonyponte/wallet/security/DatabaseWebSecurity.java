package com.anthonyponte.wallet.security;

import javax.sql.DataSource;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class DatabaseWebSecurity {

    @Bean
    UserDetailsManager getUserDetailsManager(DataSource source) {
        JdbcUserDetailsManager users = new JdbcUserDetailsManager(source);
        users.setUsersByUsernameQuery("SELECT username, password, estado correo "
                + "FROM usuario "
                + "WHERE username = ?");
        users.setAuthoritiesByUsernameQuery("SELECT u.username, p.descripcion "
                + "FROM usuario_perfil up "
                + "INNER JOIN usuario u ON u.id_usuario = up.id_usuario "
                + "INNER JOIN perfil p ON p.id_perfil = up.id_perfil "
                + "WHERE u.username = ?");
        return users;
    }

    @Bean
    SecurityFilterChain getSecurityFilterChain(HttpSecurity security) throws Exception {
        security.authorizeHttpRequests(auth -> auth
                .requestMatchers("/login").permitAll()
                .requestMatchers("/cuentas/**", "/cuenta/**").hasAnyAuthority("USUARIO")
                .requestMatchers("/transacciones/**", "/transaccion/**").hasAnyAuthority("USUARIO")
                .requestMatchers("/categorias/**", "/categoria/**").hasAnyAuthority("ADMINISTRADOR")
                .requestMatchers("/tipos/**", "/tipo/**").hasAnyAuthority("ADMINISTRADOR")
                .anyRequest().authenticated());
        security.formLogin(form -> form.loginPage("/login").permitAll());
        return security.build();
    }

    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
