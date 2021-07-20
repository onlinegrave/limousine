package com.example.limousine.models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import java.io.Serializable;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.EmbeddedId;

/**
 * @author dambarpun
 */
@Entity
@Data
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
  public Date receiveTime;

  @Column(name = "buffertime", columnDefinition = "TIMESTAMP")
  public Date bufferTime;

  @Embeddable
  @Data
  public static class DeviceRequestId implements Serializable {

    @Column(name = "companyid")
    public String companyId;

    @Column(name = "logid")
    public Long logId;
  }
}