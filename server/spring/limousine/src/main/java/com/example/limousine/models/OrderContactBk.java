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
@Table(name = "ordercontact_bk")
@Data
public class OrderContactBk {

  @Id
  @Embedded
  private OrderContactBkId orderContactBkId;

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
  public static class OrderContactBkId implements Serializable {
    public static final long serialVersionUID = 111372036854772327L;

    public OrderContactBkId(String companyId, Long orderId, Integer version, Integer seqNo) {
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
