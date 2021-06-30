package com.example.limousine.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;

@Entity
@Table(name = "userprivilege")
public class UserPrivilege {

  @EmbeddedId
  public UserPrivilegeId userPrivilegeId;

  @Column(name = "actionid", nullable = false)
  public Integer actionId;

  @Embeddable
  public static class UserPrivilegeId implements Serializable {
    @Column(name = "companyid", nullable = false, length = 20)
    public String companyId;

    @Column(name = "groupid", nullable = false, length = 10)
    public String groupId;

    @Column(name = "screenid", nullable = false)
    public Integer screenId;
  }

}
