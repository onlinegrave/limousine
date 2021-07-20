package com.example.limousine.controllers.userheadercontroller;

import com.example.limousine.controllers.userheadercontroller.dto.UserHeaderCreateDTO;
import com.example.limousine.controllers.userheadercontroller.dto.UserHeaderOneDTO;
import com.example.limousine.controllers.userheadercontroller.response.UserHeaderOneRes;
import com.example.limousine.repositories.UserHeaderRepository;

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
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Date;
import java.util.Optional;
import java.util.stream.Collectors;

import com.example.limousine.common.ApiResponse;
import com.example.limousine.models.UserHeader;
import com.example.limousine.models.UserHeader.UserHeaderId;

/**
 * @author dambarpun
 */
@RestController
public class UserHeaderController {
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private UserHeaderRepository userHeaderRepository;

    @GetMapping(value = "userheaders")
    public ResponseEntity<ApiResponse<Page<UserHeader>>> all(@RequestParam(name = "page", required = false, defaultValue = "0") int page, @RequestParam(name = "size", required = false, defaultValue = "10") int size, @RequestParam(name = "order", required = false, defaultValue = "asc") String order, @RequestParam(name = "orderBy", required = false, defaultValue = "userHeaderId.companyId") String... orderBy) {
        return ResponseEntity.ok()
                .body(new ApiResponse.Builder<Page<UserHeader>>().withData(
                        userHeaderRepository.findAll(PageRequest.of(page, size, Direction.fromString(order), orderBy)))
                        .build());
    }

    @GetMapping(value = "userheaders/{companyId}/{userId}")
    public ResponseEntity<ApiResponse<UserHeader>> one(@PathVariable(name = "companyId") String companyId, @PathVariable(name = "userId") String userId) {
        final Optional<UserHeader> optUserHeader = userHeaderRepository.findByUserHeaderIdCompanyIdAndUserHeaderIdUserId(companyId, userId);
        return optUserHeader.map(userHeader -> ResponseEntity.ok().body(new ApiResponse.Builder<UserHeader>().withData(userHeader).build())).orElseGet(() -> ResponseEntity.ok().body(new ApiResponse.Builder<UserHeader>().withError("Not found").build()));
    }

    @PostMapping(value = "userheaders/create")
    public ResponseEntity<ApiResponse<UserHeader>> create(@RequestBody UserHeaderCreateDTO userHeaderDTO) {
//        UserHeader userHeader = modelMapper.map(userHeaderCreateDTO, UserHeader.class);

        final UserHeader userHeader = new UserHeader();
        final UserHeaderId userHeaderId = new UserHeaderId(userHeaderDTO.getCompanyId(), userHeaderDTO.getUserId());
        userHeader.setUserHeaderId(userHeaderId);
        userHeader.setUsername(userHeaderDTO.getUsername());
        userHeader.setPassword(userHeaderDTO.getPassword());
        userHeader.setExpireDate(userHeaderDTO.getExpireDate());
        userHeader.setGroupId(userHeaderDTO.getGroupId());
        userHeader.setDeparment(userHeaderDTO.getDepartment());
        userHeader.setUserTel1(userHeaderDTO.getUserTel1());
        userHeader.setUserTel2(userHeaderDTO.getUserTel2());
        userHeader.setUserEmail(userHeaderDTO.getUserEmail());
        userHeader.setUserLanguage(userHeaderDTO.getUserLanguage());
        userHeader.setFlightRefreshInterval(userHeaderDTO.getFlightRefreshInterval());
        userHeader.setRemarks(userHeaderDTO.getRemarks());
        userHeader.setStatus(userHeaderDTO.getStatus());
        userHeader.setUpdatedBy(userHeaderDTO.getUpdatedBy());
        userHeader.setUpdatedDate(userHeaderDTO.getUpdatedDate());
        userHeader.setUpdatedDate(new Date());
        userHeaderRepository.save(userHeader);
        return ResponseEntity.ok().body(new ApiResponse.Builder<UserHeader>().withData(userHeader).build());
    }

    @DeleteMapping(value = "userheaders/{userId}")
    public ResponseEntity<ApiResponse<String>> destroy(@PathVariable String userId, @RequestBody String companyId) {
        final Optional<UserHeader> optUserHeader = userHeaderRepository.findById(new UserHeaderId(companyId, userId));
        if (!optUserHeader.isPresent()) {
            return ResponseEntity.ok().body(new ApiResponse.Builder<String>().withError("Not found").build());
        }
        userHeaderRepository.delete(optUserHeader.get());
        return ResponseEntity.ok().body(new ApiResponse.Builder<String>().withStatusOk().build());
    }

    @PatchMapping(value = "userheaders/{userId}")
    public ResponseEntity<ApiResponse<UserHeader>> edit(@PathVariable String userId, @RequestBody UserHeaderCreateDTO userHeaderDTO) {
        final Optional<UserHeader> optUserHeader = userHeaderRepository.findById(new UserHeaderId("", userId));
        if (!optUserHeader.isPresent()) {
            return ResponseEntity.ok().body(new ApiResponse.Builder<UserHeader>().withError("Not found").build());
        }
        final UserHeader userHeader = optUserHeader.get();
        final UserHeaderId userHeaderId = new UserHeaderId(userHeaderDTO.getCompanyId(), userHeaderDTO.getUserId());
        userHeader.setUserHeaderId(userHeaderId);
        userHeader.setUsername(userHeaderDTO.getUsername());
        userHeader.setPassword(userHeaderDTO.getPassword());
        userHeader.setExpireDate(userHeaderDTO.getExpireDate());
        userHeader.setGroupId(userHeaderDTO.getGroupId());
        userHeader.setDeparment(userHeaderDTO.getDepartment());
        userHeader.setUserTel1(userHeaderDTO.getUserTel1());
        userHeader.setUserTel2(userHeaderDTO.getUserTel2());
        userHeader.setUserEmail(userHeaderDTO.getUserEmail());
        userHeader.setUserLanguage(userHeaderDTO.getUserLanguage());
        userHeader.setFlightRefreshInterval(userHeaderDTO.getFlightRefreshInterval());
        userHeader.setRemarks(userHeaderDTO.getRemarks());
        userHeader.setStatus(userHeaderDTO.getStatus());
        userHeader.setUpdatedBy(userHeaderDTO.getUpdatedBy());
        userHeader.setUpdatedDate(userHeaderDTO.getUpdatedDate());
        userHeader.setUpdatedDate(new Date());
        userHeaderRepository.save(userHeader);
        return ResponseEntity.ok().body(new ApiResponse.Builder<UserHeader>().withData(userHeader).build());
    }
}
