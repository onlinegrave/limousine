package com.example.limousine.filters;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.limousine.services.UserDetailServiceImpl;
import com.example.limousine.utils.JwtUtil;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

@Component
public class JwtFilter extends OncePerRequestFilter {
  private static final Logger LOGGER = LoggerFactory.getLogger(JwtFilter.class);
  private static final String AUTH_BEARER_START = "Bearer ";
  @Autowired
  private UserDetailServiceImpl userDetailServiceImpl;

  @Autowired
  private JwtUtil jwtUtil;

  @Override
  protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
      throws ServletException, IOException {
    LOGGER.info(String.format("Started jwt check : {%s}", request.getRequestURI()));
    final String authorizationHeader = request.getHeader("Authorization");

    String username = null;
    String jwt = null;
    if (authorizationHeader != null && authorizationHeader.startsWith(AUTH_BEARER_START)) {
      jwt = authorizationHeader.substring(7);
      username = jwtUtil.extractUsername(jwt);
    }
    if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
      UserDetails userDetails = this.userDetailServiceImpl.loadUserByUsername(username);
      if (jwtUtil.validateToken(jwt, userDetails)) {
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
            userDetails, null, userDetails.getAuthorities());
        usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
        SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
      }
    }

    filterChain.doFilter(request, response);

    LOGGER.info(String.format("Ending jwt check : {%s}", request.getRequestURI()));
  }
}
