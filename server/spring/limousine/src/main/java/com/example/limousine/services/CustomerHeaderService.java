package com.example.limousine.services;

import java.util.List;

import com.example.limousine.models.CustomerHeader;
import com.example.limousine.repositories.CustomerHeaderRespository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class CustomerHeaderService {
  @Autowired
  private CustomerHeaderRespository customerHeaderRespository;

  public List<CustomerHeader> findPaginated(int page, int size, String orderBy) {
    // Pageable pageable = PageRequest.of(page, size, direction, properties)
    // customerHeaderRespository.findAll(new Pageable)

    return null;
  }
}
