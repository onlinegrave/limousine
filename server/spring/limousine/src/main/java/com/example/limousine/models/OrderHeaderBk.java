package com.example.limousine.models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import java.io.Serializable;
import java.time.LocalDate;

import java.time.LocalTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;

/**
 * @author dambarpun
 */
@Entity
@Table(name = "orderheader_bk")
@Data
public class OrderHeaderBk {
  @Id
  @Embedded
  private OrderHeaderBkId orderHeaderBkId;

  @Column(name = "islatest", nullable = false)
  private Integer isLatest;

  @Column(name = "displayorderid", nullable = false, length = 20)
  private String displayOrderId;

  @Column(name = "ordertype", nullable = false)
  private Integer orderType;

  @Column(name = "ridetype", nullable = false)
  private Integer rideType;

  @Column(name = "vehicletype", nullable = false)
  private Integer vehicleType;

  @Column(name = "reservedate", nullable = false)
  private LocalDate reserveDate;

  @Column(name = "reservetime", nullable = false)
  private LocalTime reserveTime;

  @Column(name = "estorderduration", nullable = false)
  private Integer estOrderDuration;

  @Column(name = "assignedvehicleid", nullable = false)
  private Integer assignedVehicleId;

  @Column(name = "assigneddriverid", nullable = false, length = 20)
  private String assignedDriverId;

  @Column(name = "pickuploc", nullable = false, length = 500)
  private String pickUpLoc;

  @Column(name = "dropoffloc", nullable = false, length = 500)
  private String dropOffLoc;

  @Column(name = "customerid", nullable = false, length = 20)
  private String customerId;

  @Column(name = "passengercompany", nullable = false, length = 100)
  private String passengerCompany;

  @Column(name = "salesref", nullable = false, length = 100)
  private String salesRef;

  @Column(name = "passengercount", nullable = false)
  private Integer passengerCount;

  @Column(name = "luggagescount", nullable = false)
  private Integer luggagesCount;

  @Column(name = "isvip", nullable = false)
  private Integer isVip;

  @Column(name = "ismeetassist", nullable = false)
  private Integer isMeetAssist;

  @Column(name = "requirebabyseat", nullable = false)
  private Integer requireBabySeat;

  @Column(name = "stopover1", nullable = false, length = 500)
  private String stopOver1;

  @Column(name = "stopover2", nullable = false, length = 500)
  private String stopOver2;

  @Column(name = "stopover3", nullable = false, length = 500)
  private String stopOver3;

  @Column(name = "flightno", nullable = false, length = 20)
  private String flightNo;

  @Column(name = "flightschedule")
  private LocalTime flightSchedule;

  @Column(name = "flightstatus", length = 100)
  private String flightStatus;

  @Column(name = "ordercharge", nullable = false)
  private Double orderCharge;

  @Column(name = "additioncharge", nullable = false)
  private Double addtionCharge;

  @Column(name = "firstremind", nullable = false)
  private Integer firstRemind;

  @Column(name = "repeatremind", nullable = false)
  private Integer repeatRemind;

  @Column(name = "zone", length = 100)
  private String zone;

  @Column(name = "addinstruction", length = 1000)
  private String addInstruction;

  @Column(name = "complaint", length = 1000)
  private String complaint;

  @Column(name = "voicenote", nullable = false, length = 100)
  private String voiceNote;

  @Column(name = "remarks", nullable = false, length = 1000)
  private String remarks;

  @Column(name = "updatedby", length = 20)
  private String updatedBy;

  @Column(name = "updateddate")
  private Date updatedDate;

  @Embeddable
  @Data
  public static class OrderHeaderBkId implements Serializable {
    private static final long serialVersionUID = 223372036854772327L;

    public OrderHeaderBkId(String companyId, Long orderId, Integer version) {
      this.companyId = companyId;
      this.orderId = orderId;
      this.version = version;
    }

    @Column(name = "companyid", nullable = false, length = 20)
    private String companyId;

    @Column(name = "orderid", nullable = false)
    private Long orderId;

    @Column(name = "version", nullable = false)
    private Integer version;
  }

}