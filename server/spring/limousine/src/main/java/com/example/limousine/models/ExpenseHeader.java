package com.example.limousine.models;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;


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
@Table(name = "expenseheader")
@Data
public class ExpenseHeader {

  @Id
  @Embedded
  private ExpenseHeaderId expenseHeaderId;

  @Column(name = "expensedate", nullable = false)
  private Date expenseDate;

  @Column(name = "orderid")
  private Long orderId;

  @Column(name = "driverid", length = 20)
  private String driverId;

  @Column(name = "vehicleid")
  private Integer vehicleId;

  @Column(name = "expensetype", nullable = false)
  private Integer expenseType;

  @Column(name = "description", nullable = false, length = 100)
  private String description;

  @Column(name = "expenseamount", nullable = false)
  private Double expenseAmount;

  @Column(name = "remarks", length = 1000)
  private String remarks;

  @Column(name = "status", nullable = false)
  private Integer status;

  @Column(name = "updatedby", length = 20)
  private String updatedBy;

  @Column(name = "updateddate")
  private Date updatedDate;

  @Embeddable
  @Data
  public static class ExpenseHeaderId implements Serializable {

    public ExpenseHeaderId(String companyId, Long expenseId) {
      this.companyId = companyId;
      this.expenseId = expenseId;
    }

    @Column(name = "companyid", nullable = false)
    private String companyId;

    @Column(name = "expenseid", nullable = false)
    private Long expenseId;
  }

}
