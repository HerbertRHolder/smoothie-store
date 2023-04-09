package com.store.smoothies;

import com.store.smoothies.services.UserDetailsLoader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {





    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
       http

        /* Login configuration */
              .formLogin()
                      .loginPage("/login")
                      .defaultSuccessUrl("/") // user's home page, it can be any URL
                      .permitAll() // Anyone can go to the login page
                      /* Logout configuration */
                      .and()
                      .logout()
                      .logoutUrl("/logout")
                      .logoutSuccessUrl("/")
                      .invalidateHttpSession(true)
                      .deleteCookies("JSESSIONID")
                      /* Pages that can be viewed without having to log in */
                      .and()
                      .authorizeHttpRequests()
                      .requestMatchers("/", "/register","/about" ,"/collection", "/collection/**", "/css/**", "/js/**", "/img/**","/icons/**","https://www.linkedin.com/in/herbertrholder/") // changed from .requestMatchers to .antMatchers
                      .permitAll()
                      /* Pages that require authentication */
                      .and()
                      .authorizeHttpRequests()
                      .requestMatchers( // changed from .requestMatchers to .antMatchers
                      "/profile","/product" // only authenticated users can access these pages
                      )
                     .authenticated();
                    return http.build();
    }



}

// http
//         .authorizeHttpRequests(authorize -> authorize
//         .anyRequest().authenticated()
//         )
//         .formLogin(withDefaults())
//         .httpBasic(withDefaults());
//         return http.build();
//



























