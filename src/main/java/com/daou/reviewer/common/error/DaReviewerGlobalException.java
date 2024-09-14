package com.daou.reviewer.common.error;

public class DaReviewerGlobalException extends RuntimeException{

    public DaReviewerGlobalException() {
        super();
    }

    public DaReviewerGlobalException(String message) {
        super(message);
    }

    public DaReviewerGlobalException(String message, Throwable cause) {
        super(message, cause);
    }
}
