package com.example.limousine.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

import com.example.limousine.models.UserHeader;
import com.example.limousine.repositories.UserHeaderRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AppUserDetailService implements UserDetailsService {
  @Autowired
  private UserHeaderRepository userHeaderRepository;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    final Optional<UserHeader> userHeader = userHeaderRepository.findByUserHeaderIdUserId(username);
    if (!userHeader.isPresent()) {
      throw new UsernameNotFoundException(username);
    }
    return new User(userHeader.get().getUserHeaderId().getUserId(), userHeader.get().getPassword(), new ArrayList<>());
  }

}
