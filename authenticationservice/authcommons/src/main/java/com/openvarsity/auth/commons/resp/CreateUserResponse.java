package com.openvarsity.auth.commons.resp;

import lombok.Data;

@Data
public class CreateUserResponse extends AbstractAuthenticationResponse {
    private String userId;
}
