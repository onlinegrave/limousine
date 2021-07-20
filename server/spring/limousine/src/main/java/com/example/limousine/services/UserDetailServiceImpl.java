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

/**
 * @author dambarpun
 */
@Service
public class UserDetailServiceImpl implements UserDetailsService {
  private final int SPLIT_LEN = 2;
  @Autowired
  private UserHeaderRepository userHeaderRepository;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    String[] splitUsername  = username.split(" ");
    if(splitUsername.length != SPLIT_LEN) {
      throw new UsernameNotFoundException(username);
    }
    String companyId = splitUsername[0];
    String userId = splitUsername[1];
    final Optional<UserHeader> userHeader = userHeaderRepository.findByUserHeaderIdCompanyIdAndUserHeaderIdUserId(companyId, userId);
    if (!userHeader.isPresent()) {
      throw new UsernameNotFoundException(username);
    }
    return new User(username, userHeader.get().getPassword(), new ArrayList<>());
  }
}
