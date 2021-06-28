package com.example.limousine.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "invoicedetail")
public class InvoiceDetail {
  @Id
  @Embedded
  public InvoiceDetailId invoiceDetailId;

  @Column(name = "orderid", nullable = false)
  public Long orderId;

  @Column(name = "ordercharge", nullable = false)
  public Double orderCharge;

  @Column(name = "tollcharge", nullable = false)
  public Double tollCharge;

  @Column(name = "waitcharge", nullable = false)
  public Double waitCharge;

  @Column(name = "stopovercharge", nullable = false)
  public Double stopOverCharge;

  @Column(name = "additionchargename", nullable = false, length = 100)
  public String additionChargeName;

  @Column(name = "additioncharge", nullable = false)
  public Double additionCharge;

  @Column(name = "totalamount", nullable = false)
  public Double totalAmount;

  @Column(name = "remarks", nullable = false, length = 1000)
  public String remarks;

  @Embeddable
  public class InvoiceDetailId implements Serializable {
    public static final long serialVersionUID = 228726036854772327L;
    @Column(name = "companyid", nullable = false, length = 20)
    public String companyId;

    @Column(name = "invoiceid", nullable = false, length = 20)
    public String invoiceId;

    @Column(name = "seqno", nullable = false)
    public Integer seqNo;
  }
}