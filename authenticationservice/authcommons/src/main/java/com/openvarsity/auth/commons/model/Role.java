package com.openvarsity.auth.commons.model;

import com.openvarsity.auth.commons.collections.Permissions;
import com.openvarsity.auth.commons.enums.RoleEnum;

import java.util.List;

public interface Role {
    Permissions getPermission();
    RoleEnum getRoleEnum();
}
