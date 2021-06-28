package com.example.limousine.models;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "lastposition")
public class LastPosition {

  @Id
  @Embedded
  public LastPositionId lastPosition;

  @Column(name = "vehicleid", nullable = true)
  public Integer vehicleId;

  @Column(name = "userid", length = 20)
  public String userId;

  @Column(name = "reporttime", nullable = false)
  public LocalDateTime reportTime;

  @Column(name = "fixtime")
  public LocalDateTime fixTime;

  @Column(name = "latitude", nullable = false)
  public Double latitude;

  @Column(name = "longitude", nullable = false)
  public Double longitude;

  @Column(name = "accuracy", nullable = false)
  public Integer accuracy;

  @Column(name = "speed")
  public Double speed;

  @Column(name = "bearing")
  public Double bearing;

  @Column(name = "source")
  public Integer source;

  @Embeddable
  public class LastPositionId implements Serializable {
    public static final long serialVersionUID = 223765036854772327L;
    @Column(name = "companyid", nullable = false, length = 20)
    public String companyId;

    @Column(name = "posid", nullable = false)
    public Long posId;
  }
}