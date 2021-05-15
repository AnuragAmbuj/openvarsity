package com.openvarsity.cms.exceptions;

public enum CMSErrorCode {

    NO_SUCH_COURSE("ERR-CR404","No such course! Kindly try with a different identifier value");

    private String errorCode;
    private String errorMessage;

    CMSErrorCode(String errorCode, String errorMessage){
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
