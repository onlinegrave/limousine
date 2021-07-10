package com.example.limousine.controllers.userprivilegecontroller;

import java.util.List;

import com.example.limousine.common.ApiResponse;
import com.example.limousine.models.UserPrivilege;
import com.example.limousine.repositories.UserPrivilegeRepository;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserPrivilegeController {
  // private static final ModelMapper modelMapper = new ModelMapper();

  // @Autowired
  // private UserPrivilegeRepository userGroupRepository;

  // @GetMapping(value = "userprivileges")
  // public ResponseEntity<ApiResponse<List<UserPrivilege>>> all() {
  // return ResponseEntity.ok()
  // .body(new
  // ApiResponse.Builder<List<UserPrivilege>>().withData(userGroupRepository.findAll()).build());
  // }

  // @GetMapping(value = "userprivileges/{groupId}")
  // public ResponseEntity<ApiResponse<UserPrivilege>> one(@PathVariable String
  // groupId) {
  // UserGroupId id = new UserGroupId("", groupId);
  // Optional<UserPrivilege> customerHeader = userGroupRepository.findById(id);
  // if (!customerHeader.isPresent()) {
  // return ResponseEntity.ok().body(new
  // ApiResponse.Builder<UserPrivilege>().withError("Not found").build());
  // }
  // return ResponseEntity.ok().body(new
  // ApiResponse.Builder<UserPrivilege>().withData(customerHeader.get()).build());
  // }

  // @PostMapping(value = "userprivileges/create")
  // public ResponseEntity<ApiResponse<UserPrivilege>> create(@RequestBody
  // UserGroupCreateDTO userGroupCreateDTO) {
  // UserPrivilege userGroup = modelMapper.map(userGroupCreateDTO,
  // UserPrivilege.class);
  // userGroup.updatedDate = Date.now();
  // userGroupRepository.save(userGroup);
  // return ResponseEntity.ok().body(new
  // ApiResponse.Builder<UserPrivilege>().withData(userGroup).build());
  // }

  // @DeleteMapping(value = "userprivileges/{groupId}")
  // public ResponseEntity<String> destroy(@PathVariable String groupId) {
  // userGroupRepository.findById(new UserGroupId("",
  // groupId)).ifPresent(userGroup -> {
  // userGroupRepository.delete(userGroup);
  // });

  // return ResponseEntity.ok().body(new String("ok"));
  // }

  // @PatchMapping(value = "userprivileges/{groupId}")
  // public ResponseEntity<ApiResponse<UserPrivilege>> edit(@PathVariable String
  // groupId) {
  // final Optional<UserPrivilege> optUserGroup = userGroupRepository.findById(new
  // UserGroupId("", groupId));
  // if (!optUserGroup.isPresent()) {
  // return ResponseEntity.ok().body(new
  // ApiResponse.Builder<UserPrivilege>().withError("Not found").build());
  // }
  // UserPrivilege ch = modelMapper.map(optUserGroup.get(), UserPrivilege.class);
  // userGroupRepository.save(ch);
  // return ResponseEntity.ok().body(new
  // ApiResponse.Builder<UserPrivilege>().withData(ch).build());
  // }
}