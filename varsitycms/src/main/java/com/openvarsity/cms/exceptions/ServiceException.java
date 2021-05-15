package com.openvarsity.cms.exceptions;

import com.openvarsity.base.exception.AbstractRuntimeException;

public class ServiceException extends AbstractRuntimeException {

    private CMSErrorCode errorCode;

    public ServiceException(CMSErrorCode error){
        this.errorCode = error;
    }

    @Override
    public String getErrorCode() {
        return errorCode.getErrorCode();
    }

    @Override
    public String getErrorMessage() {
        return errorCode.getErrorMessage();
    }
}
