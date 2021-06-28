package com.example.limousine.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Table;

@Entity
@Table(name = "docnumsetting")
public class DocNumSetting {

  @Id
  @Column(name = "companyid", nullable = false, unique = true)
  public String companyId;

  @Column(name = "lastorderid")
  public Long lastOrderId;

  @Column(name = "lastvehicleid")
  public Integer lastVehicleId;

  @Column(name = "lastposid")
  public Long lastPosId;
}
