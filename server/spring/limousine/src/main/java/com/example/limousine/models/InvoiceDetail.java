package com.example.limousine.models;

import lombok.Data;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author dambarpun
 */
@Entity
@Table(name = "invoicedetail")
@Data
public class InvoiceDetail {
  @Id
  @Embedded
  private InvoiceDetailId invoiceDetailId;

  @Column(name = "orderid", nullable = false)
  private Long orderId;

  @Column(name = "ordercharge", nullable = false)
  private Double orderCharge;

  @Column(name = "tollcharge", nullable = false)
  private Double tollCharge;

  @Column(name = "waitcharge", nullable = false)
  private Double waitCharge;

  @Column(name = "stopovercharge", nullable = false)
  private Double stopOverCharge;

  @Column(name = "additionchargename", nullable = false, length = 100)
  private String additionChargeName;

  @Column(name = "additioncharge", nullable = false)
  private Double additionCharge;

  @Column(name = "totalamount", nullable = false)
  private Double totalAmount;

  @Column(name = "remarks", nullable = false, length = 1000)
  private String remarks;

  @Embeddable
  @Data
  public static class InvoiceDetailId implements Serializable {
    public static final long serialVersionUID = 228726036854772327L;

    public InvoiceDetailId(String companyId, String invoiceId, Integer seqNo) {
      this.companyId = companyId;
      this.invoiceId = invoiceId;
      this.seqNo = seqNo;
    }

    @Column(name = "companyid", nullable = false, length = 20)
    private String companyId;

    @Column(name = "invoiceid", nullable = false, length = 20)
    private String invoiceId;

    @Column(name = "seqno", nullable = false)
    private Integer seqNo;
  }
}