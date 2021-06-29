package com.example.limousine.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import java.time.LocalDateTime;

import javax.persistence.Column;

@Entity
@Table(name = "companyheader")
public class CompanyHeader {

  public CompanyHeader() {
  }

  @Id
  @Column(name = "companyid", nullable = false, unique = true)
  public String companyId;

  @Column(name = "companyname", nullable = false)
  public String companyName;

  @Column(name = "companytype", nullable = false)
  public Integer comapanyType;

  @Column(name = "billingaddress", nullable = false)
  public String billingAddress;

  @Column(name = "contactaddress", nullable = false)
  public String contactAddress;

  @Column(name = "contactperson1", nullable = false)
  public String contactPerson1;

  @Column(name = "contactperson2", nullable = false)
  public String contactPerson2;

  @Column(name = "contacttelA1", nullable = false)
  public String contactTelA1;

  @Column(name = "contacttelB1", nullable = false)
  public String contactTelB1;

  @Column(name = "contactemail1", nullable = false)
  public String contactEmail1;

  @Column(name = "contactemail2", nullable = false)
  public String contactEmail2;

  @Column(name = "contacttela2", nullable = false)
  public String contactTelA2;

  @Column(name = "contacttelb2", nullable = false)
  public String contactTelB2;

  @Column(name = "companylogo")
  public String comapnyLogo;

  @Column(name = "standardorderimport", nullable = false)
  public Integer standardOrderImport;

  @Column(name = "remarks", nullable = false, length = 1000)
  public String remarks;

  @Column(name = "status")
  public Integer status;

  @Column(name = "updatedby")
  public String updatedBy;

  @Column(name = "updateddate", columnDefinition = "TIMESTAMP")
  public LocalDateTime updatedDate;

}