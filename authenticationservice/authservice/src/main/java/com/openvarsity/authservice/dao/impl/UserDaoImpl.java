package com.openvarsity.authservice.dao.impl;

import com.openvarsity.authservice.dao.UserDao;
import com.openvarsity.authservice.dto.UserDto;
import com.openvarsity.authservice.entity.User;
import com.openvarsity.authservice.repo.UserDetailsRepository;
import com.openvarsity.base.db.AbstractDaoImpl;
import com.openvarsity.base.mapper.ModelMappingUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserDaoImpl extends AbstractDaoImpl<UserDto,Long, User, UserDetailsRepository> implements UserDao {

    @Autowired
    private UserDetailsRepository userDetailsRepository;


    @Override
    @Cacheable(value = "users", key = "#username")
    public Optional<UserDto> findUserByUsername(String username) {
        return userDetailsRepository.findByUsername(username).map(this::toDto);
    }

    @Override
    protected UserDetailsRepository getRepository() {
        return userDetailsRepository;
    }

    @Override
    protected UserDto toDto(User entity) {
        return ModelMappingUtil.map(entity,UserDto.class);
    }

    @Override
    protected List<UserDto> toDto(List<User> entities) {
        return entities.stream().map(this::toDto).collect(Collectors.toList());
    }

    @Override
    protected User toEntity(UserDto dto) {
        return ModelMappingUtil.map(dto,User.class);
    }

    @Override
    protected List<User> toEntity(List<UserDto> dtos) {
        return dtos.stream().map(this::toEntity).collect(Collectors.toList());
    }
}
