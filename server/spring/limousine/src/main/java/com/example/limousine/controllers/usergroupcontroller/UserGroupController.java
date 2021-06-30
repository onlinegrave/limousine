package com.example.limousine.controllers.usergroupcontroller;

import com.example.limousine.repositories.UserGroupRepository;

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
import com.example.limousine.models.UserGroup;
import com.example.limousine.models.UserGroup.UserGroupId;

@RestController
public class UserGroupController {
  private static final ModelMapper modelMapper = new ModelMapper();

  @Autowired
  private UserGroupRepository userGroupRepository;

  @GetMapping(value = "usergroups")
  public ResponseEntity<ApiResponse<List<UserGroup>>> all() {
    return ResponseEntity.ok()
        .body(new ApiResponse.Builder<List<UserGroup>>().withData(userGroupRepository.findAll()).build());
  }

  @GetMapping(value = "usergroups/{groupId}")
  public ResponseEntity<ApiResponse<UserGroup>> one(@PathVariable String groupId) {
    UserGroupId id = new UserGroupId("", groupId);
    Optional<UserGroup> customerHeader = userGroupRepository.findById(id);
    if (!customerHeader.isPresent()) {
      return ResponseEntity.ok().body(new ApiResponse.Builder<UserGroup>().withError("Not found").build());
    }
    return ResponseEntity.ok().body(new ApiResponse.Builder<UserGroup>().withData(customerHeader.get()).build());
  }

  @PostMapping(value = "usergroups/create")
  public ResponseEntity<ApiResponse<UserGroup>> create(@RequestBody UserGroupCreateDTO userGroupCreateDTO) {
    UserGroup userGroup = modelMapper.map(userGroupCreateDTO, UserGroup.class);
    userGroup.updatedDate = LocalDateTime.now();
    userGroupRepository.save(userGroup);
    return ResponseEntity.ok().body(new ApiResponse.Builder<UserGroup>().withData(userGroup).build());
  }

  @DeleteMapping(value = "usergroups/{groupId}")
  public ResponseEntity<String> destroy(@PathVariable String groupId) {
    userGroupRepository.findById(new UserGroupId("", groupId)).ifPresent(userGroup -> {
      userGroupRepository.delete(userGroup);
    });

    return ResponseEntity.ok().body(new String("ok"));
  }

  @PatchMapping(value = "usergroups/{groupId}")
  public ResponseEntity<ApiResponse<UserGroup>> edit(@PathVariable String groupId) {
    final Optional<UserGroup> optUserGroup = userGroupRepository.findById(new UserGroupId("", groupId));
    if (!optUserGroup.isPresent()) {
      return ResponseEntity.ok().body(new ApiResponse.Builder<UserGroup>().withError("Not found").build());
    }
    UserGroup ch = modelMapper.map(optUserGroup.get(), UserGroup.class);
    userGroupRepository.save(ch);
    return ResponseEntity.ok().body(new ApiResponse.Builder<UserGroup>().withData(ch).build());
  }
}
