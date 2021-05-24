package com.openvarsity.authservice.service;

import com.openvarsity.authservice.dao.UserDao;
import com.openvarsity.authservice.dto.UserDto;
import com.openvarsity.authservice.model.AuthUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AccountStatusUserDetailsChecker;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserDao userDao;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        final Optional<UserDto> userDtoOptional = userDao.findUserByUsername(s);
        userDtoOptional.orElseThrow(()->new UsernameNotFoundException("Username or Password invalid!"));
        final UserDto userDto = userDtoOptional.get();
        final UserDetails userDetails = new AuthUserDetails(userDto);
        new AccountStatusUserDetailsChecker().check(userDetails);
        return userDetails;
    }
}
