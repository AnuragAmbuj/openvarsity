package com.openvarsity.base.controller;

import com.openvarsity.base.exception.AbstractRuntimeException;
import com.openvarsity.base.response.ExceptionResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
public abstract class AbstractController {

    @ExceptionHandler(AbstractRuntimeException.class)
    public ExceptionResponse handleError(AbstractRuntimeException exception){
        log.error("Exception occurred::",exception);
        ExceptionResponse response = new ExceptionResponse();
        response.setErrorMessage(exception.getErrorMessage());
        response.setErrorCode(exception.getErrorCode());
        return response;
    }
}
