package com.example.limousine.models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Table;

/**
 * @author dambarpun
 */
@Entity
@Table(name = "docnumsetting")
@Data
public class DocNumSetting {

  @Id
  @Column(name = "companyid", nullable = false, unique = true)
  private String companyId;

  @Column(name = "lastorderid")
  private Long lastOrderId;

  @Column(name = "lastvehicleid")
  private Integer lastVehicleId;

  @Column(name = "lastposid")
  private Long lastPosId;
}
