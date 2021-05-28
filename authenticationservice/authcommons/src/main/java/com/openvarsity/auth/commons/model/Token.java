package com.openvarsity.auth.commons.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.openvarsity.auth.commons.exception.FatalCryptError;
import com.openvarsity.auth.commons.utils.AuthDigestUtil;
import lombok.Data;

import java.util.Date;

@Data
public class Token {
    private String userIdClaim;
    private Date dateClaim;


    @Override
    public String toString(){
        if(userIdClaim==null || dateClaim==null){
            throw new NullPointerException("Null claim objects");
        }
        try {
            return new ObjectMapper().writeValueAsString(this);
        } catch (JsonProcessingException e) {
            throw new FatalCryptError(e.getMessage());
        }
    }
}
