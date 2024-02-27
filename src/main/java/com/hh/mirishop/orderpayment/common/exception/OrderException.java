package com.hh.mirishop.orderpayment.common.exception;

import lombok.Getter;

@Getter
public class OrderException extends RuntimeException {

    private final ErrorCode errorCode;
    private final String message;

    public OrderException(ErrorCode errorCode) {
        this.errorCode = errorCode;
        this.message = errorCode.getMessage();
    }
}
