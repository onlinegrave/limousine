package com.example.limousine.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import com.example.limousine.models.CustomerHeader.CustomerHeaderId;

import lombok.Data;

import java.io.Serializable;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.EmbeddedId;

@Entity
@Table(name = "customerheader")
@Data
public class CustomerHeader {
  public CustomerHeader() {
  }

  @EmbeddedId
  private CustomerHeaderId customerHeaderId;

  @Column(name = "customername", nullable = false, length = 100)
  private String customerName;

  @Column(name = "customertype", nullable = false)
  private Integer customerType;

  @Column(name = "contactperson", nullable = false, length = 100)
  private String contactPerson;

  @Column(name = "contacttel1", nullable = false, length = 20)
  private String contactTel1;

  @Column(name = "contacttel2", nullable = false, length = 20)
  private String contactTel2;

  @Column(name = "contactemail", nullable = false, length = 50)
  private String contactEmail;

  @Column(name = "paymenttype", nullable = false)
  private Integer paymentType;

  @Column(name = "discountpercent", nullable = false)
  private Double discountPercent;

  @Column(name = "remarks", nullable = false, length = 1000)
  private String remarks;

  @Column(name = "status", nullable = false)
  private Integer status;

  @Column(name = "updatedby")
  private String updatedBy;

  @Column(name = "updateddate", columnDefinition = "TIMESTAMP")
  private Date updatedDate;

  @Embeddable
  @Data
  public static class CustomerHeaderId implements Serializable {
    public static final long serialVersionUID = 1209720831232L;

    public CustomerHeaderId() {
    }

    public CustomerHeaderId(String companyId, String customerId) {
      this.companyId = companyId;
      this.customerId = customerId;
    }

    @Column(name = "customerid", nullable = false, length = 20)
    public String customerId;

    @Column(name = "companyid", nullable = false, length = 20)
    public String companyId;

    public String getCustomerId() {
      return this.customerId;
    }

    public String getCompanyId() {
      return this.companyId;
    }

    public void setCustomerId(String customerId) {
      this.customerId = customerId;
    }

    public void setCompanyId(String companyId) {
      this.companyId = companyId;
    }
  }
}