package com.openvarsity.base.protocols.impl;

import com.openvarsity.base.enums.UserType;
import com.openvarsity.base.protocols.User;

public class Instructor implements User {
    @Override
    public UserType getUserType() {
        return UserType.INSTRUCTOR;
    }
}
