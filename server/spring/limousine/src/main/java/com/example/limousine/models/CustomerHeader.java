package com.example.limousine.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import com.example.limousine.models.CustomerHeader.CustomerHeaderId;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;

@Entity
@IdClass(CustomerHeaderId.class)
@Table(name = "customerheader")
public class CustomerHeader {

  public CustomerHeader() {
  }

  @Id
  @Column(name = "customerid", nullable = false, unique = true)
  public String customerId;

  @Id
  @Column(name = "companyid", nullable = false)
  public String companyId;

  @Column(name = "customername", nullable = false, length = 100)
  public String customerName;

  @Column(name = "customertype", nullable = false)
  public Integer customerType;

  @Column(name = "contactperson", nullable = false, length = 100)
  public String contactPerson;

  @Column(name = "contacttel1", nullable = false, length = 20)
  public String contactTel1;

  @Column(name = "contacttel2", nullable = false, length = 20)
  public String contactTel2;

  @Column(name = "contactemail", nullable = false, length = 50)
  public String contactEmail;

  @Column(name = "paymenttype", nullable = false)
  public Integer paymentType;

  @Column(name = "discountpercent", nullable = false)
  public Double discountPercent;

  @Column(name = "remarks", nullable = false, length = 1000)
  public String remarks;

  @Column(name = "status", nullable = false)
  public Integer status;

  @Column(name = "updatedby")
  public String updatedBy;

  @Column(name = "updateddate", columnDefinition = "TIMESTAMP")
  public LocalDateTime updatedDate;

  public static class CustomerHeaderId implements Serializable {
    public static final long serialVersionUID = 1209720831232L;

    public CustomerHeaderId() {
    }

    public CustomerHeaderId(String companyId, String customerId) {
      this.companyId = companyId;
      this.customerId = customerId;
    }

    public String customerId;

    public String companyId;
  }
}