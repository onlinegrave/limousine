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
@Table(name = "inspectionlog")
public class InspectionLog {
  @Id
  @Embedded
  public InspectionLogId inspectionLogId;

  @Column(name = "inspectiontime", nullable = false)
  public LocalTime inspectionTime;
  @Column(name = "mileage")
  public Integer mileage;

  @Column(name = "vehiclebody")
  public Integer vehicelBody;
  @Column(name = "windscreenwiper")
  public Integer windscreenWiper;
  @Column(name = "seatbelt")
  public Integer seatBelt;
  @Column(name = "tankwater")
  public Integer tankwater;
  @Column(name = "engineoil")
  public Integer engineOil;
  @Column(name = "tirepressure")
  public Integer tirePressure;

  @Column(name = "lighting")
  public Integer lighting;

  @Column(name = "dashboard")
  public Integer dashboard;

  @Column(name = "steeringwheel")
  public Integer steeringWheel;

  @Column(name = "aircondition")
  public Integer airCondition;

  @Column(name = "cardoor")
  public Integer carDoor;

  @Embeddable
  public class InspectionLogId implements Serializable {
    public static final long serialVersionUID = 223372036854779877L;
    @Column(name = "companyid", nullable = false, length = 20)
    public String companyId;
    @Column(name = "driverid", nullable = false, length = 20)
    public String driverId;
    @Column(name = "vehicleid", nullable = false)
    public Integer vehicleId;
    @Column(name = "inspectiontype", nullable = false)
    public Integer inspectionType;
    @Column(name = "inspectiondate", nullable = false)
    public LocalDate inspectionDate;
  }

}
