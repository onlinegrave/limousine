package com.example.limousine.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;

@Entity
@Table(name = "orderheader_bk")
public class OrderHeaderBk {
  @Id
  @Embedded
  public OrderHeaderBkId orderHeaderBkId;

  @Column(name = "islatest", nullable = false)
  public Integer isLatest;

  @Column(name = "displayorderid", nullable = false, length = 20)
  public String displayOrderId;

  @Column(name = "ordertype", nullable = false)
  public Integer orderType;

  @Column(name = "ridetype", nullable = false)
  public Integer rideType;

  @Column(name = "vehicletype", nullable = false)
  public Integer vehicleType;

  @Column(name = "reservedate", nullable = false)
  public LocalDate reserveDate;

  @Column(name = "reservetime", nullable = false)
  public LocalTime reserveTime;

  @Column(name = "estorderduration", nullable = false)
  public Integer estOrderDuration;

  @Column(name = "assignedvehicleid", nullable = false)
  public Integer assignedVehicleId;

  @Column(name = "assigneddriverid", nullable = false, length = 20)
  public String assignedDriverId;

  @Column(name = "pickuploc", nullable = false, length = 500)
  public String pickUpLoc;

  @Column(name = "dropoffloc", nullable = false, length = 500)
  public String dropOffLoc;

  @Column(name = "customerid", nullable = false, length = 20)
  public String customerId;

  @Column(name = "passengercompany", nullable = false, length = 100)
  public String passengerCompany;

  @Column(name = "salesref", nullable = false, length = 100)
  public String salesRef;

  @Column(name = "passengercount", nullable = false)
  public Integer passengerCount;

  @Column(name = "luggagescount", nullable = false)
  public Integer luggagesCount;

  @Column(name = "isvip", nullable = false)
  public Integer isVip;

  @Column(name = "ismeetassist", nullable = false)
  public Integer isMeetAssist;

  @Column(name = "requirebabyseat", nullable = false)
  public Integer requireBabySeat;

  @Column(name = "stopover1", nullable = false, length = 500)
  public String stopOver1;

  @Column(name = "stopover2", nullable = false, length = 500)
  public String stopOver2;

  @Column(name = "stopover3", nullable = false, length = 500)
  public String stopOver3;

  @Column(name = "flightno", nullable = false, length = 20)
  public String flightNo;

  @Column(name = "flightschedule")
  public LocalTime flightSchedule;

  @Column(name = "flightstatus", length = 100)
  public String flightStatus;

  @Column(name = "ordercharge", nullable = false)
  public Double orderCharge;

  @Column(name = "additioncharge", nullable = false)
  public Double addtionCharge;

  @Column(name = "firstremind", nullable = false)
  public Integer firstRemind;

  @Column(name = "repeatremind", nullable = false)
  public Integer repeatRemind;

  @Column(name = "zone", length = 100)
  public String zone;

  @Column(name = "addinstruction", length = 1000)
  public String addInstruction;

  @Column(name = "complaint", length = 1000)
  public String complaint;

  @Column(name = "voicenote", nullable = false, length = 100)
  public String voiceNote;

  @Column(name = "remarks", nullable = false, length = 1000)
  public String remarks;

  @Column(name = "updatedby", length = 20)
  public String updatedBy;

  @Column(name = "updateddate")
  public LocalDateTime updatedDate;

  @Embeddable
  public class OrderHeaderBkId implements Serializable {
    public static final long serialVersionUID = 223372036854772327L;

    @Column(name = "companyid", nullable = false, length = 20)
    public String companyId;

    @Column(name = "orderid", nullable = false)
    public Long orderId;

    @Column(name = "version", nullable = false)
    public Integer version;
  }

  @Embeddable
  public class OrderHeaderId implements Serializable {

  }

}