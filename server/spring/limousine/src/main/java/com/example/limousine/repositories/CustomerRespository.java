package com.example.limousine.repositories;

import com.example.limousine.models.CustomerHeader;
import com.example.limousine.models.CustomerHeader.CustomerHeaderId;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRespository extends JpaRepository<CustomerHeader,CustomerHeaderId>{}