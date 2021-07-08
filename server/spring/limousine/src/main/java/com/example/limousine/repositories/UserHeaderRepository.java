package com.example.limousine.repositories;

import java.util.Optional;

import com.example.limousine.models.UserHeader;
import com.example.limousine.models.UserHeader.UserHeaderId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserHeaderRepository extends JpaRepository<UserHeader, UserHeaderId> {

  Optional<UserHeader> findByUserHeaderIdUserId(String userid);

  Optional<UserHeader> findByUserHeaderIdUserIdAndPassword(String userid, String password);

  Optional<UserHeader> findByUserHeaderIdCompanyIdAndUserHeaderIdUserIdAndPassword(String companyId, String userId,
      String password);

}