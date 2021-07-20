package com.example.limousine.models;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author dambarpun
 */
@Data
@Entity
@Table(name = "driveractionhistory")
public class DriverActionHistory {

  @Id
  @Embedded
  private DriverActionHistoryId driverActionHistoryId;

  @Column(name = "vehicleid", nullable = false)
  private Integer vehicleId;

  @Column(name = "driverid", nullable = false, length = 20)
  private String driverId;

  @Column(name = "category", nullable = false, length = 20)
  private String category;

  @Column(name = "actiontype", nullable = false, length = 20)
  private String actionType;

  @Column(name = "actiondate", nullable = false)
  private LocalDate actionDate;

  @Column(name = "actiontime", nullable = false)
  private LocalTime actionTime;

  @Column(name = "mileage")
  private Integer mileage;

  @Column(name = "oilcompany", length = 100)
  private String oilCompany;

  @Column(name = "literprice")
  private Double literPrice;

  @Column(name = "refillliter")
  private Double refillLiter;

  @Column(name = "remarks")
  private String remarks;

  @Embeddable
  @Data
  public static class DriverActionHistoryId implements Serializable {
    public DriverActionHistoryId(String companyId, Long logId) {
      this.companyId = companyId;
      this.logId = logId;
    }

    @Column(name = "companyid", nullable = false, length = 20)
    private String companyId;

    @Column(name = "logid", nullable = false)
    private Long logId;
  }
}
