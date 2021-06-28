package com.example.limousine.models;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "expenseheader")
public class ExpenseHeader {

  @Id
  @Embedded
  public ExpenseHeaderId expenseHeaderId;

  @Column(name = "expensedate", nullable = false)
  public LocalDateTime expenseDate;

  @Column(name = "orderid")
  public Long orderId;

  @Column(name = "driverid", length = 20
  public String driverId;

  @Column(name = "vehicleid")
  public Integer vehicleId;

  @Column(name = "expensetype", nullable = false)
  public Integer expenseType;

  @Column(name = "description", nullable = false, length = 100)
  public String description;

  @Column(name = "expenseamount", nullable = false)
  public Double expenseAmount;

  @Column(name = "remarks", length = 1000)
  public String remarks;

  @Column(name = "status", nullable = false)
  public Integer status;

  @Column(name = "updatedby", length = 20)
  public String updatedBy;

  @Column(name = "updateddate")
  public LocalDateTime updatedDate;

  @Embeddable
  public class ExpenseHeaderId implements Serializable {
    public static final long serialVersionUID = 223372036854772327L;
    @Column(name = "companyid", nullable = false)
    public String companyId;

    @Column(name = "expenseid", nullable = false)
    public Long expenseId;
  }
}
