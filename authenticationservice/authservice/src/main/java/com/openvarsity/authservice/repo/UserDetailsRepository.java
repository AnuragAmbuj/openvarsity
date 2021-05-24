package com.openvarsity.authservice.repo;

import com.openvarsity.authservice.entity.User;
import com.openvarsity.base.db.AbstractDataRepository;

import java.util.Optional;

public interface UserDetailsRepository extends AbstractDataRepository<User,Long> {

    Optional<User> findByUsername(String username);

}
