package com.example.limousine.models;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author dambarpun
 */
@Entity
@Table(name = "inspectionsetting")
@Data
public class InspectionSetting {

  @Id
  @Column(name = "companyid", nullable = false, length = 20)
  private String companyId;

  @Column(name = "haslogininspection", nullable = false)
  private Integer hasLoginInspection;

  @Column(name = "haslogoutinspection", nullable = false)
  private Integer hasLogoutInspection;

  @Column(name = "mileage", nullable = false)
  private Integer mileage;

  @Column(name = "vehiclebody", nullable = false)
  private Integer vehicleBody;

  @Column(name = "windscreenwiper")
  private Integer windscreenWiper;
  @Column(name = "seatbelt")
  private Integer seatBelt;
  @Column(name = "tankwater")
  private Integer tankwater;
  @Column(name = "engineoil")
  private Integer engineOil;
  @Column(name = "tirepressure")
  private Integer tirePressure;

  @Column(name = "lighting")
  private Integer lighting;

  @Column(name = "dashboard")
  private Integer dashboard;

  @Column(name = "steeringwheel")
  private Integer steeringWheel;

  @Column(name = "aircondition")
  private Integer airCondition;

  @Column(name = "cardoor")
  private Integer carDoor;
}
