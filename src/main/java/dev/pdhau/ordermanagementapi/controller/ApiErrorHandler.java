package dev.pdhau.ordermanagementapi.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import dev.pdhau.ordermanagementapi.exception.AddOrderFailedException;
import dev.pdhau.ordermanagementapi.exception.ParameterInvalidException;
import dev.pdhau.ordermanagementapi.response.Error;
import dev.pdhau.ordermanagementapi.response.ResponseCode;

@RestControllerAdvice
public class ApiErrorHandler {

    @ExceptionHandler(ParameterInvalidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Error handleParameterInvalidException(ParameterInvalidException exception) {

        return new Error(ResponseCode.validate_error, exception.getErrorDetails());
    }

    @ExceptionHandler(AddOrderFailedException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Error handleAddOrderFailedException(AddOrderFailedException exception) {

        return new Error(ResponseCode.system_error, exception.getErrorDetails());
    }
}