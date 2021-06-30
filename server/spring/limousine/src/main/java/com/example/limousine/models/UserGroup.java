package com.example.limousine.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;

@Entity
@Table(name = "usergroup")
public class UserGroup {

  @EmbeddedId
  public UserGroupId userGroupId;

  @Column(name = "usertype", nullable = false)
  public Integer userType;

  @Column(name = "remarks", nullable = false, length = 500)
  public String remarks;

  @Column(name = "status", nullable = false)
  public Integer status;

  @Column(name = "updatedby")
  public String updatedBy;

  @Column(name = "updateddate")
  public LocalDateTime updatedDate;

  @Embeddable
  public static class UserGroupId implements Serializable {
    public UserGroupId() {
    }

    public UserGroupId(String companyId, String groupId) {
      this.companyId = companyId;
      this.groupId = groupId;
    }

    @Column(name = "companyid", nullable = false, length = 20)
    public String companyId;

    @Column(name = "groupid", nullable = false, length = 20)
    public String groupId;
  }
}
