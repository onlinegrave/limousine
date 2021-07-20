package com.example.limousine.controllers.userheadercontroller.dto;

import lombok.Data;

import java.util.Date;

/**
 * @author dambarpun
 */
@Data
public class UserHeaderCreateDTO {
    private String companyId;
    private String userId;
    private String username;
    private String password;
    public Date expireDate;
    public String groupId;
    public String department;
    public String userTel1;
    public String userTel2;
    public String userEmail;
    public String userLanguage;
    public Integer flightRefreshInterval;
    public String remarks;
    public Integer status;
    public String updatedBy;
    public Date updatedDate;
}
