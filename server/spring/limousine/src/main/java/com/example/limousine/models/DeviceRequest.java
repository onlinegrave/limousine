'package com.example.limousine.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.EmbeddedId;

@Entity
@Table(name = "devicerequest")
public class DeviceRequest {

  @EmbeddedId
  DeviceRequestId deviceRequestId;

  @Column(name = "deviceid", nullable = false, length = 20)
  public String deviceId;

  @Column(name = "requestid", nullable = false, length = 20)
  public String requestId;

  @Column(name = "userid", nullable = false, length = 20)
  public String userId;

  @Column(name = "actionkey", nullable = false, length = 50)
  public String actionKey;

  @Column(name = "receivetime", nullable = false)
  public LocalDateTime receiveTime;

  @Column(name = "buffertime", columnDefinition = "TIMESTAMP")
  public LocalDateTime bufferTime;

  @Embeddable
  public class DeviceRequestId implements Serializable {
    public static final long serialVersionUID = 298999036854772327L;
    @Column(name = "companyid")
    public String companyId;

    @Column(name = "logid")
    public Long logId;
  }
}