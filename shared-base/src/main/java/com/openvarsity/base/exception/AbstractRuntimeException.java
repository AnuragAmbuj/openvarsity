package com.openvarsity.base.exception;

public abstract class AbstractRuntimeException extends RuntimeException{
    private String errorCode = ExceptionCode.GENERIC_EXCEPTION.getErrorCode();
    private String errorMessage = ExceptionCode.GENERIC_EXCEPTION.getErrorMessage();
    private Throwable cause;

    public void setCause(Throwable cause){
        this.cause = cause;
    }

    public String getErrorCode(){
        return this.errorCode;
    }

    public String getErrorMessage(){
        return this.errorMessage;
    }

    @Override
    public Throwable getCause(){
        return this.cause;
    }
}
