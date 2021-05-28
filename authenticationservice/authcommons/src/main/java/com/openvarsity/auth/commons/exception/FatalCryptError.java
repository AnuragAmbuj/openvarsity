package com.openvarsity.auth.commons.exception;

import lombok.Data;

@Data
public class FatalCryptError extends Error {

    public FatalCryptError(String message) {
        super(message);
    }

    public FatalCryptError() {
        super();
    }

    public FatalCryptError(String message, Throwable cause) {
        super(message, cause);
    }

    public FatalCryptError(Throwable cause) {
        super(cause);
    }

    protected FatalCryptError(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
