package com.example.limousine.services;

import java.util.ArrayList;
import java.util.Optional;

import com.example.limousine.models.UserHeader;
import com.example.limousine.repositories.UserHeaderRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.jdbc.JdbcDaoImpl;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailService implements UserDetailsService {
  @Autowired
  private UserHeaderRepository userHeaderRespository;

  @Override
  public UserHeader loadUserByUsername(String username) throws UsernameNotFoundException {
    System.out.println(username);
    throw new UsernameNotFoundException(username);
    // Optional<UserHeader> optUserHeader =
    // userHeaderRespository.findByUsername(username);
    // if (!optUserHeader.isPresent()) {
    // throw new UsernameNotFoundException(username);
    // }
    // return optUserHeader.get();
  }

}
