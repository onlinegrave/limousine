package com.example.limousine.controllers.customercontroller.dto;

import javax.validation.constraints.NotNull;

public class CustomerHeaderCreateDTO {
  @NotNull
  public String customerId;

  @NotNull
  public String companyId;

  public String customerType;

  @NotNull
  public String customerName;

  @NotNull
  public String contactPerson;

  @NotNull

  @NotNull
  public String updatedBy;

