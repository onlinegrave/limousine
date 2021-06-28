package com.example.limousine.models;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.Table;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Table(name = "invoiceheader")
public class InvoiceHeader {

  @Id
  @Embedded
  public InvoiceHeaderId invoiceHeaderId;

  @Column(name = "invoicedate", nullable = false, length = 20)
  public LocalDate invoiceDate;

  @Column(name = "customerid", nullable = false, length = 20)
  public String customerId;

  @Column(name = "customername", nullable = false, length = 100)
  public String customerName;

  @Column(name = "discountpercent", nullable = false)
  public Double discountPercent;

  @Column(name = "adjustmentname", nullable = false, length = 100)
  public String adjustmentName;

  @Column(name = "adjustmentamount", nullable = false)
  public Double adjustmentAmount;

  @Column(name = "invoiceamount", nullable = false)
  public Double invoiceAmount;

  @Column(name = "remarks", nullable = false, length = 1000)
  public String remarks;

  @Column(name = "Status", nullable = false)
  public Integer status;

  @Column(name = "updatedby", length = 20)
  public String updatedBy;

  @Column(name = "updateddate")
  public LocalDateTime updatedDate;

  @Embeddable
  public class InvoiceHeaderId implements Serializable {
    public static final long serialVersionUID = 223372036854797627L;
    @Column(name = "companyid", nullable = false, length = 20)
    public String companyId;

    @Column(name = "invoiceid", nullable = false, length = 20)
    public String invoiceId;
  }
}