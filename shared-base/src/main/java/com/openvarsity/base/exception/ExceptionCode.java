package com.openvarsity.base.exception;

import lombok.Data;

public enum ExceptionCode {

    GENERIC_EXCEPTION("ER-001","An undocumented general error has occurred. We will check it and resolve as soon as we can");


    private String errorCode;
    private String errorMessage;

    ExceptionCode(String errorCode, String errorMessage){
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
