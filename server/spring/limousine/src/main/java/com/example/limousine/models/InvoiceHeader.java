package com.example.limousine.models;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.Table;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author dambarpun
 */
@Entity
@Table(name = "invoiceheader")
@Data
public class InvoiceHeader {

  @Id
  @Embedded
  private InvoiceHeaderId invoiceHeaderId;

  @Column(name = "invoicedate", nullable = false, length = 20)
  private LocalDate invoiceDate;

  @Column(name = "customerid", nullable = false, length = 20)
  private String customerId;

  @Column(name = "customername", nullable = false, length = 100)
  private String customerName;

  @Column(name = "discountpercent", nullable = false)
  private Double discountPercent;

  @Column(name = "adjustmentname", nullable = false, length = 100)
  private String adjustmentName;

  @Column(name = "adjustmentamount", nullable = false)
  private Double adjustmentAmount;

  @Column(name = "invoiceamount", nullable = false)
  private Double invoiceAmount;

  @Column(name = "remarks", nullable = false, length = 1000)
  private String remarks;

  @Column(name = "Status", nullable = false)
  private Integer status;

  @Column(name = "updatedby", length = 20)
  private String updatedBy;

  @Column(name = "updateddate")
  private Date updatedDate;

  @Embeddable
  @Data
  public static class InvoiceHeaderId implements Serializable {
    public static final long serialVersionUID = 223372036854797627L;

    public InvoiceHeaderId(String companyId, String invoiceId) {
      this.companyId = companyId;
      this.invoiceId = invoiceId;
    }

    @Column(name = "companyid", nullable = false, length = 20)
    private String companyId;

    @Column(name = "invoiceid", nullable = false, length = 20)
    private String invoiceId;
  }
}