package com.openvarsity.auth.commons.model;

import lombok.Data;

import java.util.Date;

@Data
public class User{
    private String userId;
    private String userName;
    private String password;
    private String email;
    private String mobileNumber;
    private boolean active;
    private boolean expired;
    private boolean verified;
    private Date updatedOn;
}
