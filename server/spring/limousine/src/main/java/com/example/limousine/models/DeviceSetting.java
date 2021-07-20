package com.example.limousine.models;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author dambarpun
 */
@Entity
@Table(name = "devicesetting")
@Data
public class DeviceSetting {

  @Id
  @Column(name = "companyid", nullable = false, length = 20)
  private String companyId;

  @Column(name = "trackerinterval", nullable = false)
  private Integer trackerInterval;

  @Column(name = "trackerstartmode", nullable = false)
  private Integer trackerStartMode;

  @Column(name = "shutdowninterval", nullable = false)
  private Integer shutDownInterval;

  @Column(name = "screensaverinterval", nullable = false)
  private Integer screenSaverInterval;

  @Column(name = "messengerinterval", nullable = false)
  private Integer messengerInterval;

  @Column(name = "checkorderinterval", nullable = false)
  private Integer checkOrderInterval;

  @Column(name = "bufferinginterval", nullable = false)
  private Integer bufferingInterval;

  @Column(name = "connectmode", nullable = false)
  private Integer connectMode;

  @Column(name = "wifissid", length = 50)
  private String wifiSsid;

  @Column(name = "wifipassword", length = 20)
  private String wifiPassword;
}
