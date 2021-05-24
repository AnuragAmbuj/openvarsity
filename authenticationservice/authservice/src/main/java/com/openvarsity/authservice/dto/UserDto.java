package com.openvarsity.authservice.dto;

import com.openvarsity.authservice.entity.Role;
import com.openvarsity.base.db.AbstractDataDto;
import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = {"username","email","password"})
@EqualsAndHashCode(callSuper = true)
public class UserDto extends AbstractDataDto {
    private String username;
    private String password;
    private String email;
    private boolean enabled;
    private boolean accountNonExpired;
    private boolean credentialsNonExpired;
    private boolean accountNonLocked;
    private List<Role> roles;
}
