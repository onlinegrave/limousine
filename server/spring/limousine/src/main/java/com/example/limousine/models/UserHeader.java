package com.example.limousine.models;

import lombok.Data;

import javax.persistence.Table;
import javax.persistence.Id;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Data
@Entity
@Table(name = "userheader")
public class UserHeader {

  @EmbeddedId
  private UserHeaderId userHeaderId;

  @Column(name = "username", nullable = false, length = 100)
  private String username;

  @Column(name = "password", nullable = false, length = 20)
  private String password;

  @Column(name = "expiredate")
  private Date expireDate;

  @Column(name = "groupid", nullable = false, length = 20)
  private String groupId;

  @Column(name = "department", nullable = false, length = 100)
  private String deparment;

  @Column(name = "usertel1", nullable = false, length = 20)
  private String userTel1;

  @Column(name = "usertel2", nullable = false, length = 20)
  private String userTel2;

  @Column(name = "useremail", nullable = false, length = 50)
  private String userEmail;

  @Column(name = "userlanguage", nullable = false, length = 10)
  private String userLanguage;

  @Column(name = "flightrefreshinterval", nullable = false)
  private Integer flightRefreshInterval;

  @Column(name = "remarks", nullable = false, length = 1000)
  private String remarks;

  @Column(name = "status", nullable = false)
  private Integer status;

  @Column(name = "updatedby", nullable = false, length = 20)
  private String updatedBy;

  @Column(name = "updateddate")
  private Date updatedDate;

  @Data
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
