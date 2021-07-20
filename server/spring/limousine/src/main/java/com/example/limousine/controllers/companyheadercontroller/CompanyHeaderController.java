package com.example.limousine.controllers.companyheadercontroller;

import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;
import java.util.Optional;


import com.example.limousine.common.ApiResponse;
import com.example.limousine.controllers.usergroupcontroller.dto.UserGroupCreateDTO;
import com.example.limousine.models.CompanyHeader;
import com.example.limousine.models.UserHeader;
import com.example.limousine.models.UserHeader.UserHeaderId;
import com.example.limousine.repositories.CompanyHeaderRepository;

/**
 * @author dambarpun
 */
@RestController
public class CompanyHeaderController {

  @Autowired
  private ModelMapper modelMapper;

  @Autowired
  private CompanyHeaderRepository companyHeaderRepository;

  @GetMapping(value = "companyheaders")
  public ResponseEntity<ApiResponse<Page<CompanyHeader>>> all(@RequestParam("page") int page,
      @RequestParam(value = "size", required = false, defaultValue = "10") int size, @RequestParam(value = "order", required = false, defaultValue = "asc") String order, @RequestParam(value = "orderBy", required = false, defaultValue = "companyId") String... orderBy) {
    return ResponseEntity.ok().body(new ApiResponse.Builder<Page<CompanyHeader>>().withData(
        companyHeaderRepository.findAll(PageRequest.of(page, size, Direction.fromString(order), orderBy)))
        .build());
  }

  @GetMapping(value = "companyheaders/{companyId}")
  public ResponseEntity<ApiResponse<CompanyHeader>> one(@PathVariable String companyId) {
    Optional<CompanyHeader> companyHeader = companyHeaderRepository.findById(companyId);
    if (!companyHeader.isPresent()) {
      return ResponseEntity.ok().body(new ApiResponse.Builder<CompanyHeader>().withError("Not found").build());
    }
    return ResponseEntity.ok().body(new ApiResponse.Builder<CompanyHeader>().withData(companyHeader.get()).build());
  }

  @PostMapping(value = "companyheaders/create")
  public ResponseEntity<ApiResponse<CompanyHeader>> create(@RequestBody UserGroupCreateDTO userGroupCreateDTO) {
    CompanyHeader companyHeader = modelMapper.map(userGroupCreateDTO, CompanyHeader.class);
    companyHeaderRepository.save(companyHeader);
    return ResponseEntity.ok().body(new ApiResponse.Builder<CompanyHeader>().withData(companyHeader).build());
  }

  @DeleteMapping(value = "companyheaders/{companyId}")
  public ResponseEntity<String> destroy(@PathVariable String companyId) {
    companyHeaderRepository.findById(companyId).ifPresent(userHeader -> {
      companyHeaderRepository.delete(userHeader);
    });
    return ResponseEntity.ok().body(new String("ok"));
  }

  @PatchMapping(value = "companyheaders/{companyId}")
  public ResponseEntity<ApiResponse<CompanyHeader>> edit(@PathVariable String companyId) {
    final Optional<CompanyHeader> optUserGroup = companyHeaderRepository.findById(companyId);
    if (!optUserGroup.isPresent()) {
      return ResponseEntity.ok().body(new ApiResponse.Builder<CompanyHeader>().withError("Not found").build());
    }
    CompanyHeader ch = modelMapper.map(optUserGroup.get(), CompanyHeader.class);
    companyHeaderRepository.save(ch);
    return ResponseEntity.ok().body(new ApiResponse.Builder<CompanyHeader>().withData(ch).build());
  }
}
