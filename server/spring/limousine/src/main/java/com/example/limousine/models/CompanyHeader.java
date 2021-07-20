package com.example.limousine.models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import java.util.Date;

import javax.persistence.Column;

/**
 * @author dambarpun
 */
@Entity
@Table(name = "companyheader")
@Data
public class CompanyHeader {

  public CompanyHeader() {
  }

  @Id
  @Column(name = "companyid", nullable = false, unique = true)
  private String companyId;

  @Column(name = "companyname", nullable = false)
  private String companyName;

  @Column(name = "companytype", nullable = false)
  private Integer comapanyType;

  @Column(name = "billingaddress", nullable = false)
  private String billingAddress;

  @Column(name = "contactaddress", nullable = false)
  private String contactAddress;

  @Column(name = "contactperson1", nullable = false)
  private String contactPerson1;

  @Column(name = "contactperson2", nullable = false)
  private String contactPerson2;

  @Column(name = "contacttelA1", nullable = false)
  private String contactTelA1;

  @Column(name = "contacttelB1", nullable = false)
  private String contactTelB1;

  @Column(name = "contactemail1", nullable = false)
  private String contactEmail1;

  @Column(name = "contactemail2", nullable = false)
  private String contactEmail2;

  @Column(name = "contacttela2", nullable = false)
  private String contactTelA2;

  @Column(name = "contacttelb2", nullable = false)
  private String contactTelB2;

  @Column(name = "companylogo")
  private String comapnyLogo;

  @Column(name = "standardorderimport", nullable = false)
  private Integer standardOrderImport;

  @Column(name = "remarks", nullable = false, length = 1000)
  private String remarks;

  @Column(name = "status")
  private Integer status;

  @Column(name = "updatedby")
  private String updatedBy;

  @Column(name = "updateddate", columnDefinition = "TIMESTAMP")
  private Date updatedDate;

}