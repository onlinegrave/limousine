package com.example.limousine.controllers.customercontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

import com.example.limousine.common.ApiResponse;
import com.example.limousine.controllers.customercontroller.models.CustomerResponse;
import com.example.limousine.models.CustomerHeader;
import com.example.limousine.models.CustomerHeader.CustomerHeaderId;
import com.example.limousine.repositories.CustomerRespository;

@RestController
public class CustomerController {

  @Autowired
  private CustomerRespository customerRepository;

  @GetMapping(value = "companies/customers")
  public ResponseEntity<ApiResponse<List<CustomerHeader>>> all() {
    return ResponseEntity.ok()
        .body(new ApiResponse.Builder<List<CustomerHeader>>().withData(customerRepository.findAll()).build());
  }

  @GetMapping(value = "companies/{companyId}/customers/{customerId}")
  public ResponseEntity<ApiResponse<CustomerHeader>> one(@PathVariable String companyId,
      @PathVariable String customerId) {
    CustomerHeaderId id = new CustomerHeaderId();
    id.companyId = companyId;
    id.customerId = customerId;
    Optional<CustomerHeader> customerHeader = customerRepository.findById(id);
    if (!customerHeader.isPresent()) {
      return ResponseEntity.ok().body(new ApiResponse.Builder<CustomerHeader>().withError("Not found").build());
    }
    return ResponseEntity.ok().body(new ApiResponse.Builder<CustomerHeader>().withData(customerHeader.get()).build());
  }

  @PostMapping(value = "/customers/create")
  public ResponseEntity<CustomerResponse> create(@RequestBody CustomerHeader customerHeader) {
    customerRepository.save(customerHeader);
    return ResponseEntity.ok().body(new CustomerResponse());
  }

  @DeleteMapping(value = "companies/{companyId}/customers/{customerId}")
  public ResponseEntity<String> destroy(@PathVariable String companyId, @PathVariable String customerId) {
    return ResponseEntity.ok().body(new String("ok"));
  }

  @PatchMapping(value = "companies/{companyId}/customers/{customerId}")
  public ResponseEntity<String> edit(@PathVariable String company_id, @PathVariable String customer_id) {
    return ResponseEntity.ok().body(new String("ok"));
  }
}