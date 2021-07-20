package com.example.limousine.models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;

/**
 * @author dambarpun
 */
@Entity
@Table(name = "userprivilege")
@Data
public class UserPrivilege {

  @EmbeddedId
  private UserPrivilegeId userPrivilegeId;

  @Column(name = "actionid", nullable = false)
  private Integer actionId;

  @Embeddable
  @Data
  public static class UserPrivilegeId implements Serializable {
    public UserPrivilegeId(String companyId, String groupId, Integer screenId) {
      this.companyId = companyId;
      this.groupId = groupId;
      this.screenId = screenId;
    }

    @Column(name = "companyid", nullable = false, length = 20)
    private String companyId;

    @Column(name = "groupid", nullable = false, length = 10)
    private String groupId;

    @Column(name = "screenid", nullable = false)
    private Integer screenId;
  }
}
