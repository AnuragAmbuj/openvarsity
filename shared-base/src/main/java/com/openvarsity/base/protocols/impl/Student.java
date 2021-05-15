package com.openvarsity.base.protocols.impl;

import com.openvarsity.base.enums.UserType;
import com.openvarsity.base.protocols.User;

public class Student implements User {
    @Override
    public UserType getUserType() {
        return UserType.STUDENT;
    }
}
