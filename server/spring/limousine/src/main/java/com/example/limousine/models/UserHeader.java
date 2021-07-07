package com.example.limousine.models;

import javax.persistence.Table;
import javax.persistence.Id;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Collections;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
@Table(name = "userheader")
public class UserHeader {

  @EmbeddedId
  private UserHeaderId userHeaderId;

  @Column(name = "username", nullable = false, length = 100)
  private String userName;

  @Column(name = "password", nullable = false, length = 20)
  public String password;

  @Column(name = "expiredate")
  public LocalDate expireDate;

  @Column(name = "groupid", nullable = false, length = 20)
  public String groupId;

  @Column(name = "department", nullable = false, length = 100)
  public String deparment;

  @Column(name = "usertel1", nullable = false, length = 20)
  public String userTel1;

  @Column(name = "usertel2", nullable = false, length = 20)
  public String userTel2;

  @Column(name = "useremail", nullable = false, length = 50)
  public String userEmail;

  @Column(name = "userlanguage", nullable = false, length = 10)
  public String userLanguage;

  @Column(name = "flightrefreshinterval", nullable = false)
  public Integer flightRefreshInterval;

  @Column(name = "remarks", nullable = false, length = 1000)
  public String remarks;

  @Column(name = "status", nullable = false)
  public Integer status;

  @Column(name = "updatedby", nullable = false, length = 20)
  public String updatedBy;

  @Column(name = "updateddate")
  public LocalDateTime updatedDate;

  public String getUserName() {
    return this.userName;
  }

  public void setUserName(String username) {
    this.userName = username;
  }

  @Embeddable
  public static class UserHeaderId implements Serializable {

    public UserHeaderId() {
    }

    public UserHeaderId(String companyId, String userId) {
      this.companyId = companyId;
      this.userId = userId;
    }

    @Column(name = "companyid", nullable = false, length = 20)
    public String companyId;

    @Column(name = "userid", nullable = false, length = 20)
    public String userId;
  }
}
