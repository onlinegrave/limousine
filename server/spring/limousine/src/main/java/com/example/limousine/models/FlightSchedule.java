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
@Table(name = "flightschedule")
@Data
public class FlightSchedule {

  @Id
  @Embedded
  private FlightScheduleId flightScheduleId;

  @Column(name = "airline", nullable = false, length = 100)
  private String airline;

  @Column(name = "location", nullable = false, length = 100)
  private String location;

  @Column(name = "hall", nullable = false, length = 100)
  private String hall;

  @Column(name = "status", nullable = false)
  private String status;

  @Column(name = "lastupdate", nullable = false)
  private Date lastUpdate;

  @Embeddable
  @Data
  public static class FlightScheduleId implements Serializable {
    public FlightScheduleId(String airportCode, Integer flightType, String flightNo, Date flightDate, Date flightTime) {
      this.airportCode = airportCode;
      this.flightType = flightType;
      this.flightNo = flightNo;
      this.flightDate = flightDate;
      this.flightTime = flightTime;

    }

    @Column(name = "airportcode", nullable = false, length = 10)
    private String airportCode;

    @Column(name = "flighttype", nullable = false)
    private Integer flightType;

    @Column(name = "flightno", nullable = false, length = 10)
    private String flightNo;

    @Column(name = "flightdate", nullable = false)
    private Date flightDate;

    @Column(name = "flighttime", nullable = false, columnDefinition = "TIME")
    private Date flightTime;
  }
}