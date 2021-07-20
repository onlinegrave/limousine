package com.example.limousine.models;

import lombok.Data;

import java.io.Serializable;
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
@Table(name = "lastposition")
@Data
public class LastPosition {

  @Id
  @Embedded
  private LastPositionId lastPosition;

  @Column(name = "vehicleid", nullable = true)
  private Integer vehicleId;

  @Column(name = "userid", length = 20)
  private String userId;

  @Column(name = "reporttime", nullable = false)
  private Date reportTime;

  @Column(name = "fixtime")
  private Date fixTime;

  @Column(name = "latitude", nullable = false)
  private Double latitude;

  @Column(name = "longitude", nullable = false)
  private Double longitude;

  @Column(name = "accuracy", nullable = false)
  private Integer accuracy;

  @Column(name = "speed")
  private Double speed;

  @Column(name = "bearing")
  private Double bearing;

  @Column(name = "source")
  private Integer source;

  @Embeddable
  @Data
  public class LastPositionId implements Serializable {
    public static final long serialVersionUID = 223765036854772327L;

    public LastPositionId(String companyId, Long posId) {
      this.companyId = companyId;
      this.posId = posId;
    }

    @Column(name = "companyid", nullable = false, length = 20)
    private String companyId;

    @Column(name = "posid", nullable = false)
    private Long posId;
  }
}