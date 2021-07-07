package com.example.limousine.controllers.customerheadercontroller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ch.qos.logback.core.joran.action.Action;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import com.example.limousine.common.ApiResponse;
import com.example.limousine.controllers.customerheadercontroller.dto.CustomerHeaderCreateDTO;
import com.example.limousine.controllers.customerheadercontroller.models.CustomerResponse;
import com.example.limousine.models.CustomerHeader;
import com.example.limousine.models.CustomerHeader.CustomerHeaderId;
import com.example.limousine.repositories.CustomerRespository;

@RestController
public class CustomerHeaderController {

  // @Autowired
  // public AbstractUserDetailsAuthenticationProvider authProvider;

  // @Autowired
  // public SecurityContextHolder securityContext;

  private static final ModelMapper modelMapper = new ModelMapper();

  @Autowired
  private CustomerRespository customerRepository;

  @GetMapping(value = "customers")
  public ResponseEntity<ApiResponse<List<CustomerHeader>>> all() {
    // public ResponseEntity<ApiResponse<Object>> all() {
    // Object principal =
    // SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    // if (principal instanceof UserDetails) {
    // return ResponseEntity.ok()
    // .body(new ApiResponse.Builder<Object>().withData(((UserDetails)
    // principal).toString()).build());
    // }
    // return ResponseEntity.ok().body(new ApiResponse.Builder<Object>()
    // .withData(SecurityContextHolder.getContext().getAuthentication().getDetails()).build());
    return ResponseEntity.ok()
        .body(new ApiResponse.Builder<List<CustomerHeader>>().withData(customerRepository.findAll()).build());
  }

  @GetMapping(value = "customers/{customerId}")
  public ResponseEntity<ApiResponse<CustomerHeader>> one(@PathVariable String companyId,
      @PathVariable String customerId) {
    CustomerHeaderId id = new CustomerHeaderId(companyId, customerId);
    Optional<CustomerHeader> customerHeader = customerRepository.findById(id);
    if (!customerHeader.isPresent()) {
      return ResponseEntity.ok().body(new ApiResponse.Builder<CustomerHeader>().withError("Not found").build());
    }
    return ResponseEntity.ok().body(new ApiResponse.Builder<CustomerHeader>().withData(customerHeader.get()).build());
  }

  @PostMapping(value = "customers/create")
  public ResponseEntity<ApiResponse<CustomerHeader>> create(@RequestBody CustomerHeaderCreateDTO customerHeaderDto) {
    CustomerHeader customerHeader = modelMapper.map(customerHeaderDto, CustomerHeader.class);
    customerHeader.updatedDate = LocalDateTime.now();

    Optional<CustomerHeader> optCustomerHeader = customerRepository
        .findById(new CustomerHeaderId(customerHeader.companyId, customerHeader.customerId));

    if (!optCustomerHeader.isPresent()) {
      return ResponseEntity.ok().body(new ApiResponse.Builder<CustomerHeader>().withError("Not found").build());
    }

    return ResponseEntity.ok().body(new ApiResponse.Builder<CustomerHeader>().withData(customerHeader).build());
  }

  @DeleteMapping(value = "customers/{customerId}")
  public ResponseEntity<String> destroy(@PathVariable String companyId, @PathVariable String customerId) {
    return ResponseEntity.ok().body(new String("ok"));
  }

  @PatchMapping(value = "customers/{customerId}")
  public ResponseEntity<ApiResponse<CustomerHeader>> edit(@PathVariable String companyId,
      @PathVariable String customerId) {
    final Optional<CustomerHeader> customerHeader = customerRepository
        .findById(new CustomerHeaderId(companyId, customerId));
    if (!customerHeader.isPresent()) {
      return ResponseEntity.ok().body(new ApiResponse.Builder<CustomerHeader>().withError("Not found").build());
    }
    CustomerHeader ch = modelMapper.map(customerHeader.get(), CustomerHeader.class);
    customerRepository.save(ch);
    return ResponseEntity.ok().body(new ApiResponse.Builder<CustomerHeader>().withData(ch).build());
  }
}