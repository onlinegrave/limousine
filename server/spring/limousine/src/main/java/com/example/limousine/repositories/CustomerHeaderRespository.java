package com.example.limousine.repositories;

import java.util.Optional;

import com.example.limousine.models.CustomerHeader;
import com.example.limousine.models.CustomerHeader.CustomerHeaderId;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerHeaderRespository extends JpaRepository<CustomerHeader, CustomerHeaderId> {
  public Optional<CustomerHeader> findByCustomerHeaderIdCompanyIdAndCustomerHeaderIdCustomerId(String companyId,
      String customerId);
}