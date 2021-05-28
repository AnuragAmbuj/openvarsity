package com.openvarsity.auth.commons.roles;

import com.openvarsity.auth.commons.collections.Permissions;
import com.openvarsity.auth.commons.enums.RoleEnum;
import com.openvarsity.auth.commons.model.Permission;
import com.openvarsity.auth.commons.model.Role;

public class InstructorRole implements Role {

    @Override
    public Permissions getPermission() {
        return Permissions.of(Permission.EDIT_COURSE,
                Permission.CREATE_COURSE,
                Permission.COURSE_VIEWS_ANALYTICS,
                Permission.COMMENT_ACCESS,
                Permission.DELETE_COMMENT,
                Permission.DISCUSSION_ACCESS);
    }

    @Override
    public RoleEnum getRoleEnum() {
        return RoleEnum.INSTRUCTOR;
    }
}
