package com.example.limousine.controllers.userprivilegecontroller;

import java.util.Date;
import java.util.Optional;

import com.example.limousine.common.ApiResponse;
import com.example.limousine.controllers.userheadercontroller.dto.UserHeaderCreateDTO;
import com.example.limousine.models.UserPrivilege;
import com.example.limousine.models.UserPrivilege;
import com.example.limousine.repositories.UserPrivilegeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author dambarpun
 */
@RestController
public class UserPrivilegeController {

  @Autowired
  private UserPrivilegeRepository userPrivilegeRepository;

  @GetMapping(value = "userprivileges")
  public ResponseEntity<ApiResponse<Page<UserPrivilege>>> all(@RequestParam(name = "page", required = false, defaultValue = "0") int page, @RequestParam(name = "size", required = false, defaultValue = "10") int size, @RequestParam(name = "order", required = false, defaultValue = "asc") String order, @RequestParam(name = "orderBy", required = false, defaultValue = "userHeaderId.companyId") String... orderBy) {
//        String[] orderByImp = new String[orderBy.length];
//        for (int i = 0; i < orderBy.length; i++) {
//            if ("companyId".equals(orderBy[i]) || "userId".equals(orderBy[i])) {
//                orderByImp[i] = "userHeaderId.".concat(orderBy[i]);
//            } else {
//                orderByImp[i] = orderBy[i];
//            }
//        }
//        orderBy = Arrays.stream(orderBy).map(s -> {
//            switch (s) {
//                case "companyId":
//                case "userId":
//                    s = "userHeaderId.".concat(s);
//                default:
//                    return s;
//            }
//        }).collect(Collectors.toList()).toArray(new String[orderBy.length]);
    return ResponseEntity.ok()
        .body(new ApiResponse.Builder<Page<UserPrivilege>>().withData(
            userPrivilegeRepository.findAll(PageRequest.of(page, size, Sort.Direction.fromString(order), orderBy)))
            .build());
  }

  @GetMapping(value = "userprivileges/{companyId}/{groupId}/{screenId}")
  public ResponseEntity<ApiResponse<UserPrivilege>> one(@PathVariable(name = "companyId") String companyId, @PathVariable(name = "screenId") String screenId, @PathVariable(name = "groupId") String groupId) {
    final Optional<UserPrivilege> optUserPrivilege = userPrivilegeRepository.findByUserPrivilegeIdCompanyIdAndUserPrivilegeIdGroupIdAndUserPrivilegeIdScreenId(companyId, groupId, screenId);
    if (!optUserPrivilege.isPresent()) {
      return ResponseEntity.ok().body(new ApiResponse.Builder<UserPrivilege>().withError("Not found").build());
    }
    return ResponseEntity.ok().body(new ApiResponse.Builder<UserPrivilege>().withData(optUserPrivilege.get()).build());
  }

//  @PostMapping(value = "userprivileges/create")
//  public ResponseEntity<ApiResponse<UserPrivilege>> create(@RequestBody UserHeaderCreateDTO userHeaderDTO) {
//        UserPrivilege userHeader = modelMapper.map(userHeaderCreateDTO, UserPrivilege.class);
//    userPrivilegeRepository.save(userHeader);
//    return ResponseEntity.ok().body(new ApiResponse.Builder<UserPrivilege>().withData(userHeader).build());
//  }

  @DeleteMapping(value = "userprivileges/{userId}")
  public ResponseEntity<ApiResponse<String>> destroy(@PathVariable Integer screenId, @RequestBody String companyId, @RequestBody String groupId) {
    final Optional<UserPrivilege> optUserPrivilege = userPrivilegeRepository.findById(new UserPrivilege.UserPrivilegeId(companyId, groupId, screenId));
    if (!optUserPrivilege.isPresent()) {
      return ResponseEntity.ok().body(new ApiResponse.Builder<String>().withError("Not found").build());
    }
    userPrivilegeRepository.delete(optUserPrivilege.get());
    return ResponseEntity.ok().body(new ApiResponse.Builder<String>().withStatusOk().build());
  }

//  @PatchMapping(value = "userheaders/{userId}")
//  public ResponseEntity<ApiResponse<UserPrivilege>> edit(@PathVariable String userId, @RequestBody UserHeaderCreateDTO userHeaderDTO) {
//    final Optional<UserPrivilege> optUserPrivilege = userHeaderRepository.findById(new UserPrivilege.UserHeaderId("", userId));
//    if (!optUserPrivilege.isPresent()) {
//      return ResponseEntity.ok().body(new ApiResponse.Builder<UserPrivilege>().withError("Not found").build());
//    }
//    final UserPrivilege userHeader = optUserPrivilege.get();
//    final UserPrivilege.UserHeaderId userHeaderId = new UserPrivilege.UserHeaderId(userHeaderDTO.getCompanyId(), userHeaderDTO.getUserId());
//    userHeader.setUserHeaderId(userHeaderId);
//    userHeader.setUsername(userHeaderDTO.getUsername());
//    userHeader.setPassword(userHeaderDTO.getPassword());
//    userHeader.setExpireDate(userHeaderDTO.getExpireDate());
//    userHeader.setGroupId(userHeaderDTO.getGroupId());
//    userHeader.setDeparment(userHeaderDTO.getDepartment());
//    userHeader.setUserTel1(userHeaderDTO.getUserTel1());
//    userHeader.setUserTel2(userHeaderDTO.getUserTel2());
//    userHeader.setUserEmail(userHeaderDTO.getUserEmail());
//    userHeader.setUserLanguage(userHeaderDTO.getUserLanguage());
//    userHeader.setFlightRefreshInterval(userHeaderDTO.getFlightRefreshInterval());
//    userHeader.setRemarks(userHeaderDTO.getRemarks());
//    userHeader.setStatus(userHeaderDTO.getStatus());
//    userHeader.setUpdatedBy(userHeaderDTO.getUpdatedBy());
//    userHeader.setUpdatedDate(userHeaderDTO.getUpdatedDate());
//    userHeader.setUpdatedDate(new Date());
//    userHeaderRepository.save(userHeader);
//    return ResponseEntity.ok().body(new ApiResponse.Builder<UserPrivilege>().withData(userHeader).build());
//  }
}