package com.openvarsity.cms.exceptions;

import com.openvarsity.base.exception.AbstractRuntimeException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.NOT_FOUND)
public class CMSNoSuchDataException extends AbstractRuntimeException {

    private String errorCode = "ERR-002";
    private String errorMessage = "No data found for this identifier. Please change the same and try again.";

    @Override
    public void setCause(Throwable cause) {
        super.setCause(cause);
    }

    @Override
    public String getErrorCode() {
        return errorCode;
    }

    @Override
    public String getErrorMessage() {
        return errorMessage;
    }

    @Override
    public Throwable getCause() {
        return super.getCause();
    }
}
