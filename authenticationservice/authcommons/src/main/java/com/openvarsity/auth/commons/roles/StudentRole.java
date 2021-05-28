package com.openvarsity.auth.commons.roles;

import com.openvarsity.auth.commons.collections.Permissions;
import com.openvarsity.auth.commons.enums.RoleEnum;
import com.openvarsity.auth.commons.model.Permission;
import com.openvarsity.auth.commons.model.Role;

public class StudentRole implements Role {

    @Override
    public Permissions getPermission() {
        return Permissions.of(Permission.VIEW_COURSE_LIST,
                Permission.BUY_COURSE,
                Permission.VIEW_INSTRUCTOR_PROFILE,
                Permission.VIEW_INSTRUCTOR_PROFILE);
    }

    @Override
    public RoleEnum getRoleEnum() {
        return RoleEnum.STUDENT;
    }

}
