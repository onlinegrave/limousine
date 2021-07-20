package com.example.limousine.models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;

/**
 * @author dambarpun
 */
@Entity
@Table(name = "ordercontact_import")
@Data
public class OrderContactImport {
  @Id
  @Embedded
  private OrderContactImportId orderContactImportId;

  @Column(name = "contactname", nullable = false, length = 100)
  private String contactName;

  @Column(name = "contacttel1", nullable = false, length = 20)
  private String contactTel1;

  @Column(name = "contacttel2", nullable = false, length = 20)
  private String contactTel2;

  @Column(name = "contactemail", nullable = false, length = 50)
  private String contactEmail;

  @Column(name = "ispassenger", nullable = false)
  private Integer isPassenger;

  @Embeddable
  @Data
  public static class OrderContactImportId implements Serializable {
    public static final long serialVersionUID = 1113720368547877L;

    public OrderContactImportId(String companyId, Long orderId, Integer version, Integer seqNo) {
      this.companyId = companyId;
      this.orderId = orderId;
      this.version = version;
      this.seqNo = seqNo;
    }

    @Column(name = "companyid", nullable = false, length = 20)
    private String companyId;

    @Column(name = "orderid", nullable = false)
    private Long orderId;

    @Column(name = "version", nullable = false)
    private Integer version;

    @Column(name = "seqno", nullable = false)
    private Integer seqNo;
  }

}
