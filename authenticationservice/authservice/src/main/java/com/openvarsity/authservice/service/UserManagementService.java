package com.openvarsity.authservice.service;

import com.openvarsity.auth.commons.req.CreateUserRequest;
import com.openvarsity.auth.commons.resp.CreateUserResponse;

public interface UserManagementService {

    CreateUserResponse createUser(CreateUserRequest request);


}
