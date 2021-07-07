package com.example.limousine.config;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.validation.MessageCodesResolver;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.config.annotation.AsyncSupportConfigurer;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.validation.Validator;

@EnableWebMvc
@Configuration
@ComponentScan(basePackageClasses = MyWebMvcConfiguration.class)
public class MyWebMvcConfiguration implements WebMvcConfigurer {

  // @Bean
  // @Override
  // public UserDetailsService userDetailsService() {
  // UserDetails user =
  //
  // User.withDefaultPasswordEncoder().username("user").password("password").roles("USER").build();
  // return new InMemoryUserDetailsManager(user);
  // }

  @Override
  public void configurePathMatch(PathMatchConfigurer configurer) {
  }

  @Override
  public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
  }

  @Override
  public void configureAsyncSupport(AsyncSupportConfigurer configurer) {
  }

  @Override
  public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
  }

  @Override
  public void addFormatters(FormatterRegistry registry) {
  }

  @Override
  public void addInterceptors(InterceptorRegistry registry) {
  }

  @Override
  public void addCorsMappings(CorsRegistry registry) {
    registry.addMapping("/**").allowedMethods("PUT", "PATCH", "POST");
  }

  @Override
  public void addViewControllers(ViewControllerRegistry registry) {
    // registry.addViewController("/home").setViewName("home");
    // registry.addViewController("/").setViewName("home");
    // registry.addViewController("/hello").setViewName("hello");
    // registry.addViewController("/login").setViewName("login");
  }

  @Override
  public void configureViewResolvers(ViewResolverRegistry registry) {
  }

  @Override
  public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
  }

  @Override
  public void addReturnValueHandlers(List<HandlerMethodReturnValueHandler> handlers) {
  }

  @Override
  public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
  }

  @Override
  public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
  }

  @Override
  public void configureHandlerExceptionResolvers(List<HandlerExceptionResolver> resolvers) {
  }

  @Override
  public void extendHandlerExceptionResolvers(List<HandlerExceptionResolver> resolvers) {
  }

  @Override
  public Validator getValidator() {
    return null;
  }

  @Override
  public MessageCodesResolver getMessageCodesResolver() {
    return null;
  }
}