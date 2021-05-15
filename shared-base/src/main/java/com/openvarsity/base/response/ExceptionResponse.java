package com.openvarsity.base.response;

import lombok.Data;

@Data
public class ExceptionResponse extends AbstractResponse{
    private String errorCode;
    private String errorMessage;
}
