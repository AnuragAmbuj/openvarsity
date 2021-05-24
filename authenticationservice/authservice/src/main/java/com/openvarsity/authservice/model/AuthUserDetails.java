package com.openvarsity.authservice.model;

import com.openvarsity.authservice.dto.UserDto;
import com.openvarsity.authservice.entity.Role;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Authentication User Model that implements User Details
 * This connects by extending UserDto but implements in full
 * so that the code clarity and maintenance is easier.
 */
@Getter
@EqualsAndHashCode
@ToString
public class AuthUserDetails extends UserDto implements UserDetails {

    private UserDto userDto;

    public AuthUserDetails(UserDto userDto) {
        this.userDto = userDto;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        final List<GrantedAuthority> grantedAuthorityList = new ArrayList<>();
        userDto.getRoles().forEach(role -> addGrantedAuthority(grantedAuthorityList, role));
        return grantedAuthorityList;
    }

    private void addGrantedAuthority(List<GrantedAuthority> grantedAuthorityList, Role role) {
        grantedAuthorityList.add(new SimpleGrantedAuthority(role.getName()));
        role.getPermissions().forEach(permission -> grantedAuthorityList.add(new SimpleGrantedAuthority(permission.getName())));
    }

    @Override
    public String getPassword() {
        return userDto.getPassword();
    }

    @Override
    public String getUsername() {
        return userDto.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return userDto.isAccountNonExpired();
    }

    @Override
    public boolean isAccountNonLocked() {
        return userDto.isAccountNonLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return userDto.isCredentialsNonExpired();
    }

    @Override
    public boolean isEnabled() {
        return userDto.isEnabled();
    }
}
