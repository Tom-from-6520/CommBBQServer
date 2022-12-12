package com.example.cbbq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;

@Configuration
public class SecurityConfig {
    // @Qualifier("orgDetailsServiceImpl")
    // @Autowired
    // private UserDetailsService userDetailsService;
    // @Autowired
    // private OrgAuthSuccessHandler authSuccessHandler;

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean 
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        // http
        //     .authorizeRequests()
        //         .antMatchers("/resources/**", "/org/registration").permitAll()
        //         .anyRequest().authenticated()
        //         .and()
        //     .formLogin()
        //         .loginPage("/org/login")
        //         .successHandler(authSuccessHandler)
        //         .permitAll()
        //         .and()
        //     .logout()
        //         .permitAll();
        http.cors().and().csrf().disable();
        return http.build();
    }

    @Bean 
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
        return authConfig.getAuthenticationManager();
    }

    @Bean
    public AuthenticationSuccessHandler successHandler() {
        SimpleUrlAuthenticationSuccessHandler handler = new SimpleUrlAuthenticationSuccessHandler("/success");
        handler.setUseReferer(true);
        return handler;
    }
}