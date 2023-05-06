package com.kina.admin.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * 全局异常处理器，处理整个web controller的异常
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler({ArithmeticException.class, NullPointerException.class})
    public String handlerArithException(Exception e) {
        return "login";
    }
}
