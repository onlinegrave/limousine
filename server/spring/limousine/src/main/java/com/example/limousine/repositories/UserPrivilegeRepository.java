package com.example.limousine.repositories;

import com.example.limousine.models.UserPrivilege;
import com.example.limousine.models.UserPrivilege.UserPrivilegeId;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @author dambarpun
 */
public interface UserPrivilegeRepository extends JpaRepository<UserPrivilege, UserPrivilegeId> {
  /**
   * Find user privilege.
   * @param companyId
   * @param groupId
   * @param screenId
   * @return UserPrivilege
   */
  Optional<UserPrivilege> findByUserPrivilegeIdCompanyIdAndUserPrivilegeIdGroupIdAndUserPrivilegeIdScreenId(String companyId, String groupId, String screenId);
}
