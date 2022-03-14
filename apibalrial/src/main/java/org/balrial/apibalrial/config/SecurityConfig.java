package org.balrial.apibalrial.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().
                sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).
                and().
                authorizeRequests().
                antMatchers(HttpMethod.GET, "/api/**").permitAll().
                antMatchers(HttpMethod.POST, "/api/**").permitAll().
                antMatchers(HttpMethod.PUT, "/api/**").permitAll().
                antMatchers(HttpMethod.DELETE, "/api/**").permitAll().
                anyRequest().permitAll();
        //     .addFilterAfter(new JWTAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class)
        //     .authorizeRequests()
        //     .antMatchers("/webjars/*","/swagger-ui/","/login").permitAll()
        //     .anyRequest().authenticated();
    }
}
