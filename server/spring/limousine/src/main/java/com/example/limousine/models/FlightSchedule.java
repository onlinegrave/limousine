package com.example.limousine.models;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "flightschedule")
public class FlightSchedule {

  @Id
  @Embedded
  public FlightScheduleId flightScheduleId;

  @Column(name = "airline", nullable = false, length = 100)
  public String airline;

  @Column(name = "location", nullable = false, length = 100)
  public String location;

  @Column(name = "hall", nullable = false, length = 100)
  public String hall;

  @Column(name = "status", nullable = false)
  public String status;

  @Column(name = "lastupdate", nullable = false)
  public LocalDateTime lastUpdate;

  @Embeddable
  public class FlightScheduleId implements Serializable {
    public static final long serialVersionUID = 223372036854987777L;

    @Column(name = "airportcode", nullable = false, length = 10)
    public String airportCode;

    @Column(name = "flighttype", nullable = false)
    public Integer flightType;

    @Column(name = "flightno", nullable = false, length = 10)
    public String flightNo;

    @Column(name = "flightdate", nullable = false)
    public LocalDate flightDate;

    @Column(name = "flighttime", nullable = false)
    public LocalTime flightTime;
  }
}