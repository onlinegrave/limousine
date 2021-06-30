package com.example.limousine.repositories;

import com.example.limousine.models.UserGroup;
import com.example.limousine.models.UserGroup.UserGroupId;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserGroupRepository extends JpaRepository<UserGroup, UserGroupId> {

}
