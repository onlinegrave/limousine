package com.example.limousine.controllers.customerheadercontroller.dto;

import javax.validation.constraints.NotNull;

public class CustomerHeaderCreateDTO {

  @NotNull
  public String companyId;

  @NotNull
  public String customerId;

  @NotNull
  public String customerName;

  @NotNull
  public String contactPerson;

  @NotNull
  public String contactTel1;

  @NotNull
  public String contactTel2;

  @NotNull
  public String contactEmail;

  @NotNull
  public String paymentType;

  @NotNull
  public String discountPercent;

  @NotNull
  public String remarks;

  @NotNull
  public Integer status;

}
