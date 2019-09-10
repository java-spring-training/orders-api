package order.management.api.controller;

import order.management.api.exception.ParameterInvalidException;

import java.sql.SQLException;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@RestControllerAdvice
public class ApiErrorHandler {

    private Logger log = Logger.getLogger(ApiErrorHandler.class);

    @ExceptionHandler(NoHandlerFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Error handleNoHandlerFoundException(NoHandlerFoundException ex) {

        log.error("Invalid URI", ex);

        return new Error(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.getReasonPhrase(),
                "Entry Api with wrong URI");
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Error handleHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException ex) {

        log.error("Invalid Method", ex);

        return new Error(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.getReasonPhrase(),
                "Entry Api with wrong method");
    }

    @ExceptionHandler(ParameterInvalidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Error handleParameterInvalidException(ParameterInvalidException ex) {

        log.error("Invalid Input parameter", ex);

        return new Error(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), ex.getMessage());
    }

    @ExceptionHandler(SQLException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Error handleSQLException(SQLException ex) {

        log.error("Internal Server Error", ex);

        return new Error(HttpStatus.INTERNAL_SERVER_ERROR.value(), HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(),
                "System Error");
    }
}
