package com.example.limousine.models;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "driveractionhistory")
public class DriverActionHistory {

  @Id
  @Embedded
  public DriverActionHistoryId driverActionHistoryId;

  @Column(name = "vehicleid", nullable = false)
  public Integer vehicleId;

  @Column(name = "driverid", nullable = false, length = 20)
  public String driverId;

  @Column(name = "category", nullable = false, length = 20)
  public String category;

  @Column(name = "actiontype", nullable = false, length = 20)
  public String actionType;

  @Column(name = "actiondate", nullable = false)
  public LocalDate actionDate;

  @Column(name = "actiontime", nullable = false)
  public LocalTime actionTime;

  @Column(name = "mileage")
  public Integer mileage;

  @Column(name = "oilcompany", length = 100)
  public String oilCompany;

  @Column(name = "literprice")
  public Double literPrice;

  @Column(name = "refillliter")
  public Double refillLiter;

  @Column(name = "remarks")
  public String remarks;

  @Embeddable
  public class DriverActionHistoryId implements Serializable {
    public static final long serialVersionUID = 129387123192739L;
    @Column(name = "companyid", nullable = false, length = 20)
    public String companyId;

    @Column(name = "logid", nullable = false)
    public Long logId;
  }
}
