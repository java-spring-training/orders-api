package api.controller;

import api.exception.DataNotFoundException;
import api.exception.ParameterInvalidException;
import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.ws.rs.InternalServerErrorException;

@RestControllerAdvice
public class ApiErrorHandler {

    private Logger log = Logger.getLogger(ApiErrorHandler.class);

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
    public Error handleHttpRequestMethodNotSupportedException(
            HttpRequestMethodNotSupportedException ex) {

        log.error(String.format("Invalid Method. exception=[%s]", ex.getMessage()));
        return new Error(HttpStatus.METHOD_NOT_ALLOWED.value(), HttpStatus.METHOD_NOT_ALLOWED.getReasonPhrase(),
                "Method is not supported");
    }

    @ExceptionHandler(ParameterInvalidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Error handleParameterInvalidException(ParameterInvalidException ex) {

        log.error(String.format("Invalid input parameter. exception=[%s]", ex.getMessage()));
        return new Error(HttpStatus.BAD_REQUEST.value(), "Invalid request parameters", ex.getMessage());
    }

    @ExceptionHandler(DataNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Error handleDataNotFoundException(DataNotFoundException ex) {

        log.error(String.format("Data is not found. exception=[%s]", ex.getMessage()));
        return new Error(HttpStatus.NOT_FOUND.value(), "Data is not found", ex.getMessage());
    }

    @ExceptionHandler(InternalServerErrorException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Error handleInternalServerErrorException(InternalServerErrorException ex) {

        log.error(String.format("Internal server. exception=[%s]", ex.getMessage()));
        return new Error(HttpStatus.INTERNAL_SERVER_ERROR.value(), HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(),
                ex.getMessage());
    }
}
