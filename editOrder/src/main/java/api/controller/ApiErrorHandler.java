package api.controller;

import api.exception.ApiException;
import api.exception.ParameterInvalidException;
import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApiErrorHandler {

    private Logger log = Logger.getLogger(ApiErrorHandler.class);

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
    public Error handleHttpRequestMethodNotSupportedException(
            HttpRequestMethodNotSupportedException ex) {

        log.error("Invalid Method", ex);

        return new Error(HttpStatus.METHOD_NOT_ALLOWED.value(),
                HttpStatus.METHOD_NOT_ALLOWED.getReasonPhrase(),
                "Api with wrong method");
    }

    @ExceptionHandler(ParameterInvalidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Error handleHttpBadRequestException(
            ParameterInvalidException ex) {

        log.error("Invalid Parameter", ex);

        return new Error(HttpStatus.BAD_REQUEST.value(),
                HttpStatus.BAD_REQUEST.getReasonPhrase(),
                "Api with Invalid Parameter");
    }

    @ExceptionHandler(ApiException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Error handleHttpInternalServerException(
            ApiException ex) {

        log.error("DB ERROR", ex);

        return new Error(HttpStatus.INTERNAL_SERVER_ERROR.value(),
                HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(),
                ex.getMessage());
    }
}
