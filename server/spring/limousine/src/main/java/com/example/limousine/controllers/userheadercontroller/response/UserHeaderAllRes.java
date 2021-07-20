package com.example.limousine.controllers.userheadercontroller.response;

import lombok.Data;

import java.util.Date;

/**
 * @author dambarpun
 */
@Data
public class UserHeaderAllRes {
    private String companyId;
    private String userId;
    private String username;
    private String password;
    private Date expireDate;
    private String groupId;
    private String department;
    private String userTel1;
    private String userTel2;
    private String userEmail;
    private String userLanguage;
    private Integer flightRefreshInterval;
    private String remarks;
    private Integer status;
    private String updatedBy;
    private Date updatedDate;
}
