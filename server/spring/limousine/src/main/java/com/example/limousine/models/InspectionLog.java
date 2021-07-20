package com.example.limousine.models;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
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
@Table(name = "inspectionlog")
@Data
public class InspectionLog {
  @Id
  @Embedded
  private InspectionLogId inspectionLogId;

  @Column(name = "inspectiontime", nullable = false, columnDefinition = "TIME")
  private Date inspectionTime;
  @Column(name = "mileage")
  private Integer mileage;

  @Column(name = "vehiclebody")
  private Integer vehicelBody;
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

  @Embeddable
  @Data
  public static class InspectionLogId implements Serializable {
    public static final long serialVersionUID = 223372036854779877L;

    public InspectionLogId(String companyId, String driverId, Integer vehicleId, Integer inspectionType, Date inspectionDate) {
      this.companyId = companyId;
      this.driverId = driverId;
      this.vehicleId = vehicleId;
      this.inspectionType = inspectionType;
      this.inspectionDate = inspectionDate;
    }


    @Column(name = "companyid", nullable = false, length = 20)
    private String companyId;
    @Column(name = "driverid", nullable = false, length = 20)
    public String driverId;
    @Column(name = "vehicleid", nullable = false)
    public Integer vehicleId;
    @Column(name = "inspectiontype", nullable = false)
    public Integer inspectionType;
    @Column(name = "inspectiondate", nullable = false)
    public Date inspectionDate;
  }

}
