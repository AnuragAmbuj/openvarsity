package com.openvarsity.auth.commons.req;

import lombok.Data;

@Data
public class CreateUserRequest extends AbstractAuthenticationRequest {
    private String userName;
    private String password;
    private String email;
    private String mobileNumber;
}
