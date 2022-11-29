package kz.hackathon.meeting.security.config;

import kz.hackathon.meeting.security.filters.JwtAuthenticationFilter;
import kz.hackathon.meeting.security.filters.JwtAuthorizationFilter;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@RequiredArgsConstructor
@EnableWebSecurity
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class JwtSecurityConfig {
    UserDetailsService userDetailsServiceImpl;

    PasswordEncoder passwordEncoder;

    AuthenticationProvider refreshTokenAuthenticationProvider;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity,
                                                   JwtAuthenticationFilter jwtAuthenticationFilter,
                                                   JwtAuthorizationFilter jwtAuthorizationFilter) throws Exception {
        httpSecurity.cors();
        httpSecurity.csrf().disable();
        httpSecurity.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        httpSecurity.authorizeHttpRequests().requestMatchers("/api/auth/token/**", "/", "/api/open-api",
                "/api/registration/").anonymous();
        httpSecurity.authorizeHttpRequests().requestMatchers("/api/users/**").hasAuthority("USER");
        httpSecurity.authorizeHttpRequests().requestMatchers("/api/admin/**").hasAuthority("ADMIN");

//        httpSecurity.securityMatcher("/api/auth/token/**", "/", "/api/open-api",
//                "/api/registration/");
//        httpSecurity.authorizeRequests().sec("/api/auth/token/**", "/", "/api/open-api",
//                "/api/registration/").permitAll();
//        httpSecurity.authorizeRequests().antMatchers("/api/admin/**").hasAuthority("ADMIN");

        httpSecurity.addFilter(jwtAuthenticationFilter);
        httpSecurity.addFilterBefore(jwtAuthorizationFilter, UsernamePasswordAuthenticationFilter.class);
        return httpSecurity.build();
    }


    @Autowired
    public void bindUserDetailsServiceAndPasswordEncoder(AuthenticationManagerBuilder builder) throws Exception {
        builder.authenticationProvider(refreshTokenAuthenticationProvider);
        builder.userDetailsService(userDetailsServiceImpl).passwordEncoder(passwordEncoder);
    }

}
