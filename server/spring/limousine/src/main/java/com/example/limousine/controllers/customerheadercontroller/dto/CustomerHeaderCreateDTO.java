package com.example.limousine.controllers.customerheadercontroller.dto;

import lombok.Data;
import lombok.NonNull;

/**
 * @author dambarpun
 */
@Data
public class CustomerHeaderCreateDTO {
  private String companyId;
  private String customerId;
  private String customerName;
  private String contactPerson;
  private String contactTel1;
  private String contactTel2;
  private String contactEmail;
  private Integer paymentType;
  private Double discountPercent;
  private String remarks;
  private Integer status;
}
