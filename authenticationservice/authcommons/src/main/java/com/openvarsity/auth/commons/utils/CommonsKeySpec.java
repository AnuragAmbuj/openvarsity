package com.openvarsity.auth.commons.utils;

import lombok.Data;

@Data
public class CommonsKeySpec {
    private String secret;
    private String salt;
}
