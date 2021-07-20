package com.example.limousine.models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import java.io.Serializable;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;

/**
 * @author dambarpun
 */
@Entity
@Table(name = "usergroup")
@Data
public class UserGroup {

  @EmbeddedId
  private UserGroupId userGroupId;

  @Column(name = "usertype", nullable = false)
  private Integer userType;

  @Column(name = "remarks", nullable = false, length = 500)
  private String remarks;

  @Column(name = "status", nullable = false)
  private Integer status;

  @Column(name = "updatedby")
  private String updatedBy;

  @Column(name = "updateddate")
  private Date updatedDate;

  @Embeddable
  @Data
  public static class UserGroupId implements Serializable {
    public UserGroupId() {
    }

    public UserGroupId(String companyId, String groupId) {
      this.companyId = companyId;
      this.groupId = groupId;
    }

    @Column(name = "companyid", nullable = false, length = 20)
    private String companyId;

    @Column(name = "groupid", nullable = false, length = 20)
    private String groupId;
  }
}
