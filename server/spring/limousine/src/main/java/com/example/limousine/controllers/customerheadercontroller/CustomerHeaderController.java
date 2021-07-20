package com.example.limousine.controllers.customerheadercontroller;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.convention.MatchingStrategies;
import org.modelmapper.spi.MatchingStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ch.qos.logback.core.joran.action.Action;
import lombok.NonNull;

import java.io.StringBufferInputStream;

import java.util.List;
import java.util.Optional;

import com.example.limousine.common.ApiResponse;
import com.example.limousine.controllers.customerheadercontroller.dto.CustomerHeaderCreateDTO;
import com.example.limousine.controllers.customerheadercontroller.dto.CustomerHeaderDestroyDTO;
import com.example.limousine.controllers.customerheadercontroller.dto.CustomerHeaderEditDTO;
import com.example.limousine.controllers.customerheadercontroller.dto.CustomerHeaderOneDTO;
import com.example.limousine.controllers.customerheadercontroller.models.CustomerResponse;
import com.example.limousine.models.CustomerHeader;
import com.example.limousine.models.CustomerHeader.CustomerHeaderId;
import com.example.limousine.repositories.CustomerHeaderRespository;
import com.google.gson.Gson;

/**
 * @author dambarpun
 */
@RestController
public class CustomerHeaderController {

  // @Autowired
  // public AbstractUserDetailsAuthenticationProvider authProvider;

  // @Autowired
  // public SecurityContextHolder securityContext;

  @Autowired
  private ModelMapper modelMapper;

  @Autowired
  private Gson gson;

  @Autowired
  private CustomerHeaderRespository customerHeaderRepository;

  @GetMapping(value = "customerheaders", params = { "page", "size", "orderBy", "order" })
  public ResponseEntity<ApiResponse<Page<CustomerHeader>>> all(@RequestParam("page") int page,
                                                               @RequestParam("size") int size, @RequestParam("order") String order, @RequestParam("orderBy") String... orderBy) {
    return ResponseEntity.ok().body(new ApiResponse.Builder<Page<CustomerHeader>>().withData(
        customerHeaderRepository.findAll(PageRequest.of(page, size, Direction.fromString(order), orderBy)))
        .build());
  }

  @GetMapping(value = "customerheaders/{customerId}")
  public ResponseEntity<ApiResponse<CustomerHeader>> one(@PathVariable String customerId,
      @RequestBody CustomerHeaderOneDTO customerHeaderDto) {
    final Optional<CustomerHeader> customerHeader = customerHeaderRepository
        .findByCustomerHeaderIdCompanyIdAndCustomerHeaderIdCustomerId(customerHeaderDto.companyId, customerId);
    if (!customerHeader.isPresent()) {
      return ResponseEntity.ok().body(new ApiResponse.Builder<CustomerHeader>().withError("Not found").build());
    }
    return ResponseEntity.ok().body(new ApiResponse.Builder<CustomerHeader>().withData(customerHeader.get()).build());
  }

  @PostMapping(value = "customerheaders")
  public ResponseEntity<Object> create(@RequestBody CustomerHeaderCreateDTO customerHeaderDto) {
    // modelMapper.addMappings(new PropertyMap<CustomerHeaderCreateDTO,
    // CustomerHeader>() {
    // @Override
    // protected void configure() {
    // final CustomerHeaderId customerHeaderId = new
    // CustomerHeaderId(source.getCompanyId(), source.getCustomerId());
    // destination.setCustomerHeaderId(customerHeaderId);
    // }
    // });
    // modelMapper.addMappings(mapper ->
    // mapper.map(Source::getCompanyId,Destination::getCompanyHeaderId().getCompanyId()));
    // modelMapper.addMappings(src -> src.getPerson().getFirstName(), (dest, v) ->
    // dest.getCustomer().setName(v));
    // final CustomerHeaderId customerHeaderId = modelMapper.map(customerHeaderDto,
    // CustomerHeaderId.class);
    // modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
    // final CustomerHeader customerHeader = modelMapper.map(customerHeaderDto,
    // CustomerHeader.class);
    // modelMapper.addMappings(mapper -> mapper.map(src ->
    // src.getCustomer().getAge(), PersonDTO::setAge));
    // modelMapper.addMappings(mapper -> mapper.map(src -> src.getCompanyId(),
    // CustomerHeaderCreateDTO::setStatus));
    // final CustomerHeaderCreateDTO customerHeader1 =
    // modelMapper.map(customerHeaderDto, CustomerHeaderCreateDTO.class);
    final CustomerHeader customerHeader = new CustomerHeader();
    return ResponseEntity.ok().body(new ApiResponse.Builder<CustomerHeader>().withData(customerHeader).build());
    // customerHeader.updatedDate = Date.now();

    // Optional<CustomerHeader> optCustomerHeader = customerHeaderRepository
    // .findById(customerHeader.getCustomerHeaderId());

    // if (!optCustomerHeader.isPresent()) {
    // return ResponseEntity.ok().body(new
    // ApiResponse.Builder<CustomerHeader>().withError("Not found").build());
    // }

    // return ResponseEntity.ok().body(new
    // ApiResponse.Builder<CustomerHeader>().withData(customerHeader).build());
  }

  @DeleteMapping(value = "customerheaders/{customerId}")
  public ResponseEntity<String> destroy(@PathVariable String customerId,
      @RequestBody CustomerHeaderDestroyDTO customerHeaderDto) {
    return ResponseEntity.ok().body(new String("ok"));
  }

  @PatchMapping(value = "customerheaders/{customerId}")
  public ResponseEntity<ApiResponse<String>> edit(@PathVariable String customerId,
      @RequestBody CustomerHeaderEditDTO customerHeaderDto) {
    final Optional<CustomerHeader> customerHeader = customerHeaderRepository
        .findById(new CustomerHeaderId(customerHeaderDto.companyId, customerId));
    if (!customerHeader.isPresent()) {
      return ResponseEntity.ok().body(new ApiResponse.Builder<String>().withError("Not found").build());
    }

    return ResponseEntity.ok().body(new ApiResponse.Builder<String>().withStatusOk().build());
  }
}