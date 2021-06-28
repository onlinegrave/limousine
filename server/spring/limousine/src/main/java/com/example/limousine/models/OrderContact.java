package com.example.limousine.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ordercontact")
public class OrderContact {
  @Id
  @Embedded
  public OrderContactId orderContactId;

  @Column(name = "contactname", nullable = false, length = 100)
  public String contactName;

  @Column(name = "contacttel1", nullable = false, length = 20)
  public String contactTel1;

  @Column(name = "contacttel2", nullable = false, length = 20)
  public String contactTel2;

  @Column(name = "contactemail", nullable = false, length = 50)
  public String contactEmail;

  @Column(name = "ispassenger", nullable = false)
  public Integer isPassenger;

  @Embeddable
  public class OrderContactId implements Serializable {
    public static final long serialVersionUID = 223372036854775807L;
    @Column(name = "companyid", nullable = false, length = 20)
    public String companyId;

    @Column(name = "orderid", nullable = false)
    public Long orderId;

    @Column(name = "version", nullable = false)
    public Integer version;

    @Column(name = "seqno", nullable = false)
    public Integer seqNo;
  }

}