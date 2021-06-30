package com.example.limousine.controllers.userheadercontroller;

import com.example.limousine.repositories.UserGroupRepository;
import com.example.limousine.repositories.UserHeaderRepository;

import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import com.example.limousine.common.ApiResponse;
import com.example.limousine.controllers.usergroupcontroller.dto.UserGroupCreateDTO;
import com.example.limousine.models.UserHeader;
import com.example.limousine.models.UserHeader.UserHeaderId;

@RestController
public class UserHeaderController {
  private static final ModelMapper modelMapper = new ModelMapper();

  @Autowired
  private UserHeaderRepository userHeaderRepository;

  @GetMapping(value = "userheaders")
  public ResponseEntity<ApiResponse<List<UserHeader>>> all() {
    return ResponseEntity.ok()
        .body(new ApiResponse.Builder<List<UserHeader>>().withData(userHeaderRepository.findAll()).build());
  }

  @GetMapping(value = "userheaders/{userId}")
  public ResponseEntity<ApiResponse<UserHeader>> one(@PathVariable String userId) {
    UserHeaderId id = new UserHeaderId("", userId);
    Optional<UserHeader> customerHeader = userHeaderRepository.findById(id);
    if (!customerHeader.isPresent()) {
      return ResponseEntity.ok().body(new ApiResponse.Builder<UserHeader>().withError("Not found").build());
    }
    return ResponseEntity.ok().body(new ApiResponse.Builder<UserHeader>().withData(customerHeader.get()).build());
  }

  @PostMapping(value = "userheaders/create")
  public ResponseEntity<ApiResponse<UserHeader>> create(@RequestBody UserGroupCreateDTO userGroupCreateDTO) {
    UserHeader userHeader = modelMapper.map(userGroupCreateDTO, UserHeader.class);
    userHeader.updatedDate = LocalDateTime.now();
    userHeaderRepository.save(userHeader);
    return ResponseEntity.ok().body(new ApiResponse.Builder<UserHeader>().withData(userHeader).build());
  }

  @DeleteMapping(value = "userheaders/{userId}")
  public ResponseEntity<String> destroy(@PathVariable String userId) {
    userHeaderRepository.findById(new UserHeaderId("", userId)).ifPresent(userHeader -> {
      userHeaderRepository.delete(userHeader);
    });
    return ResponseEntity.ok().body(new String("ok"));
  }

  @PatchMapping(value = "userheaders/{userId}")
  public ResponseEntity<ApiResponse<UserHeader>> edit(@PathVariable String userId) {
    final Optional<UserHeader> optUserGroup = userHeaderRepository.findById(new UserHeaderId("", userId));
    if (!optUserGroup.isPresent()) {
      return ResponseEntity.ok().body(new ApiResponse.Builder<UserHeader>().withError("Not found").build());
    }
    UserHeader ch = modelMapper.map(optUserGroup.get(), UserHeader.class);
    userHeaderRepository.save(ch);
    return ResponseEntity.ok().body(new ApiResponse.Builder<UserHeader>().withData(ch).build());

  @GetMapping(value = "userheaderstest/{userId}}")
  public ResponseEntity<ApiResponse<UserHeader>> userid(@PathVariable String userId) {
    Optional<UserHeader> customerHeader = userHeaderRepository.findByUserHeaderIdUserId(userId);
    if (!customerHeader.isPresent()) {
      return ResponseEntity.ok().body(new ApiResponse.Builder<UserHeader>().withError("Not found").build());
    }
    return ResponseEntity.ok().body(new ApiResponse.Builder<UserHeader>().withData(customerHeader.get()).build());
  }
}
