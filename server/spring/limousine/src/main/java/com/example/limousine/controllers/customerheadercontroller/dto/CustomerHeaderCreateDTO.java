package com.example.limousine.controllers.customerheadercontroller.dto;

import lombok.Data;
import lombok.NonNull;

@Data
public class CustomerHeaderCreateDTO {

  @NonNull
  public String companyId;

  @NonNull
  public String customerId;

  @NonNull
  public String customerName;

  @NonNull
  public String contactPerson;

  @NonNull
  public String contactTel1;

  @NonNull
  public String contactTel2;

  @NonNull
  public String contactEmail;

  @NonNull
  public Integer paymentType;

  @NonNull
  public Double discountPercent;

  @NonNull
  public String remarks;

  @NonNull
  public Integer status;

}
