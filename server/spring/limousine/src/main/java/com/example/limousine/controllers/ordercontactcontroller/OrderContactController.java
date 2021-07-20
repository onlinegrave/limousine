package com.example.limousine.controllers.ordercontactcontroller;

import com.example.limousine.common.ApiResponse;
import com.example.limousine.controllers.BaseController;
import com.example.limousine.controllers.customerheadercontroller.dto.CustomerHeaderCreateDTO;
import com.example.limousine.controllers.customerheadercontroller.dto.CustomerHeaderDestroyDTO;
import com.example.limousine.controllers.customerheadercontroller.dto.CustomerHeaderEditDTO;
import com.example.limousine.controllers.customerheadercontroller.dto.CustomerHeaderOneDTO;
import com.example.limousine.models.CustomerHeader;
import com.example.limousine.repositories.CustomerHeaderRespository;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * @author dambarpun
 */
@RestController
public class OrderContactController extends BaseController {

  @Autowired
  private CustomerHeaderRespository customerHeaderRepository;

  @GetMapping(value = "ordercontacts", params = {"page", "size", "orderBy", "order"})
  public ResponseEntity<ApiResponse<Page<CustomerHeader>>> all(@RequestParam("page") int page, @RequestParam("size") int size, @RequestParam("order") String order, @RequestParam("orderBy") String... orderBy) {
    return ResponseEntity.ok().body(new ApiResponse.Builder<Page<CustomerHeader>>().withData(
        customerHeaderRepository.findAll(PageRequest.of(page, size, Sort.Direction.fromString(order), orderBy)))
        .build());
  }

  @GetMapping(value = "ordercontacts/{customerId}")
  public ResponseEntity<ApiResponse<CustomerHeader>> one(@PathVariable String customerId, @RequestBody CustomerHeaderOneDTO customerHeaderDto) {
    final Optional<CustomerHeader> customerHeader = customerHeaderRepository
        .findByCustomerHeaderIdCompanyIdAndCustomerHeaderIdCustomerId(customerHeaderDto.companyId, customerId);
    if (!customerHeader.isPresent()) {
      return ResponseEntity.ok().body(new ApiResponse.Builder<CustomerHeader>().withError("Not found").build());
    }
    return ResponseEntity.ok().body(new ApiResponse.Builder<CustomerHeader>().withData(customerHeader.get()).build());
  }

  @PostMapping(value = "ordercontacts")
  public ResponseEntity<Object> create(@RequestBody CustomerHeaderCreateDTO customerHeaderDto) {
    final CustomerHeader customerHeader = new CustomerHeader();
    return ResponseEntity.ok().body(new ApiResponse.Builder<CustomerHeader>().withData(customerHeader).build());
  }

  @DeleteMapping(value = "ordercontacts/{customerId}")
  public ResponseEntity<String> destroy(@PathVariable String customerId, @RequestBody CustomerHeaderDestroyDTO customerHeaderDto) {
    return ResponseEntity.ok().body(new String("ok"));
  }

  @PatchMapping(value = "ordercontacts/{customerId}")
  public ResponseEntity<ApiResponse<String>> edit(@PathVariable String customerId,
                                                  @RequestBody CustomerHeaderEditDTO customerHeaderDto) {
    final Optional<CustomerHeader> customerHeader = customerHeaderRepository
        .findById(new CustomerHeader.CustomerHeaderId(customerHeaderDto.companyId, customerId));
    if (!customerHeader.isPresent()) {
      return ResponseEntity.ok().body(new ApiResponse.Builder<String>().withError("Not found").build());
    }
    return ResponseEntity.ok().body(new ApiResponse.Builder<String>().withStatusOk().build());
  }
}
