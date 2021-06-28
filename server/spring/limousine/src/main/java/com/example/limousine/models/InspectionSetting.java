package com.example.limousine.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "inspectionsetting")
public class InspectionSetting {

  @Id
  @Column(name = "companyid", nullable = false, length = 20)
  public String companyId;

  @Column(name = "haslogininspection", nullable = false)
  public Integer hasLoginInspection;

  @Column(name = "haslogoutinspection", nullable = false)
  public Integer hasLogoutInspection;

  @Column(name = "mileage", nullable = false)
  public Integer mileage;

  @Column(name = "vehiclebody", nullable = false)
  public Integer vehicleBody;

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
}
