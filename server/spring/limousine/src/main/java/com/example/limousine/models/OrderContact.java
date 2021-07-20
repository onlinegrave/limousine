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
@Table(name = "ordercontact")
@Data
public class OrderContact {
  @Id
  @Embedded
  private OrderContactId orderContactId;

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
  public static class OrderContactId implements Serializable {

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