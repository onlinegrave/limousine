package com.example.limousine.repositories;

import com.example.limousine.models.UserPrivilege;
import com.example.limousine.models.UserPrivilege.UserPrivilegeId;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserPrivilegeRepository extends JpaRepository<UserPrivilege, UserPrivilegeId> {

}
