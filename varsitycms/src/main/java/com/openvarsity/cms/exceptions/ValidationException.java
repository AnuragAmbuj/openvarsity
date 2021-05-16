package com.openvarsity.cms.exceptions;

import com.openvarsity.base.exception.AbstractRuntimeException;

public class ValidationException extends AbstractRuntimeException {

    private String message;
    private String errorCode = "INVALID-PARAM-01";


    public ValidationException(String message){
        this.message = message;
    }

    @Override
    public String getErrorCode() {
        return errorCode;
    }

    @Override
    public String getErrorMessage() {
        return message;
    }
}
