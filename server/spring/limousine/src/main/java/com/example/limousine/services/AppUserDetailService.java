package com.example.limousine.services;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class AppUserDetailService implements UserDetailsService {

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    return new UserDetails() {

      @Override
      public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
      }

      @Override
      public String getPassword() {
        return "foo";
      }

      @Override
      public String getUsername() {
        return "foo";
      }

      @Override
      public boolean isAccountNonExpired() {
        // TODO Auto-generated method stub
        return false;
      }

      @Override
      public boolean isAccountNonLocked() {
        // TODO Auto-generated method stub
        return false;
      }

      @Override
      public boolean isCredentialsNonExpired() {
        // TODO Auto-generated method stub
        return false;
      }

      @Override
      public boolean isEnabled() {
        // TODO Auto-generated method stub
        return false;
      }

    };
  }

}
