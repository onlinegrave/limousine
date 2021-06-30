package com.example.limousine.config;

import java.util.Arrays;

import javax.sql.DataSource;

import com.example.limousine.services.MyUserDetailService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@EnableWebSecurity
public class MySecurityConfigurer extends WebSecurityConfigurerAdapter {

  @Autowired
  private MyUserDetailService userDetailService;

  @Autowired
  private DataSource dataSource;

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    super.configure(http);
    // http.cors().and().csrf().disable();
    // http.authorizeRequests().antMatchers("/admin").hasRole("ADMIN").antMatchers("/users").hasAnyRole("ADMIN",
    // "USER")`
    // .antMatchers("/").permitAll().anyRequest().authenticated().and().formLogin().loginPage("/login").permitAll()
    // .and().logout().permitAll();
  }

  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth.userDetailsService(userDetailService);
    // super.configure(auth);
    // auth.jdbcAuthentication().dataSource(dataSource);
    // auth.inMemoryAuthentication().withUser("foo").password("foo").roles("USER");
  }

  CorsConfigurationSource corsConfigurationSource() {
    CorsConfiguration configuration = new CorsConfiguration();
    configuration.setAllowedOrigins(Arrays.asList("*"));
    configuration.setAllowedMethods(Arrays.asList("*"));
    configuration.setAllowedHeaders(Arrays.asList("*"));
    configuration.setAllowCredentials(true);
    UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
    source.registerCorsConfiguration("/**", configuration);
    return source;
  }

  // @Bean
  // public PasswordEncoder passwordEncoder() {
  // // return NoOpPasswordEncoder.getInstance();
  // return new BCryptPasswordEncoder();
  // }
}
