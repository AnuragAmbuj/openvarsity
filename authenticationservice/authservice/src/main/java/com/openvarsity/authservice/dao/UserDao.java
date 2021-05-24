package com.openvarsity.authservice.dao;

import com.openvarsity.authservice.dto.UserDto;
import com.openvarsity.base.db.AbstractDao;

import java.util.Optional;

public interface UserDao extends AbstractDao<UserDto,Long> {
    Optional<UserDto> findUserByUsername(String username);
}
