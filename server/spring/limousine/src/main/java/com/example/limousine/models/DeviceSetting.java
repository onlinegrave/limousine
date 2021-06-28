package com.example.limousine.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "devicesetting")
public class DeviceSetting {

  @Id
  @Column(name = "companyid", nullable = false, length = 20)
  public String companyId;

  @Column(name = "trackerinterval", nullable = false)
  public Integer trackerInterval;

  @Column(name = "trackerstartmode", nullable = false)
  public Integer trackerStartMode;

  @Column(name = "shutdowninterval", nullable = false)
  public Integer shutDownInterval;

  @Column(name = "screensaverinterval", nullable = false)
  public Integer screenSaverInterval;

  @Column(name = "messengerinterval", nullable = false)
  public Integer messengerInterval;

  @Column(name = "checkorderinterval", nullable = false)
  public Integer checkOrderInterval;

  @Column(name = "bufferinginterval", nullable = false)
  public Integer bufferingInterval;

  @Column(name = "connectmode", nullable = false)
  public Integer connectMode;

  @Column(name = "wifissid", length = 50)
  public String wifiSsid;

  @Column(name = "wifipassword", length = 20)
  public String wifiPassword;

}
