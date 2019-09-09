package example.controller;

import java.sql.SQLException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class ApiErrorHandler {

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Error handleHttpRequestMethodNotSupportedException(
            HttpRequestMethodNotSupportedException ex) {

        log.error("Invalid Method", ex);

        return new Error(HttpStatus.NOT_FOUND.value(),
                         HttpStatus.NOT_FOUND.getReasonPhrase(),
                         "Entry Api with wrong method");
    }

    @ExceptionHandler(ParameterInvalidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Error handleParameterInvalidException(ParameterInvalidException ex) {

        log.error("Invalid Input parameter", ex);

        return new Error(HttpStatus.BAD_REQUEST.value(),
                         HttpStatus.BAD_REQUEST.getReasonPhrase(),
                         ex.getMessage());
    }

    @ExceptionHandler(SQLException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Error handlerSQLException(
            SQLException ex) {

        log.error("SQL Exception", ex);

        return new Error(HttpStatus.INTERNAL_SERVER_ERROR.value(),
                         HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(),
                         ex.getMessage());
    }

    @ExceptionHandler(DataAccessException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Error handlerDataAccessException(
            DataAccessException ex) {

        log.error("Data Access Exception", ex);

        return new Error(HttpStatus.INTERNAL_SERVER_ERROR.value(),
                         HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(),
                         ex.getMessage());
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Error handleException(
            Exception ex) {

        log.error("Unknown Exception", ex);

        return new Error(HttpStatus.INTERNAL_SERVER_ERROR.value(),
                         HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(),
                         ex.getMessage());
    }

}
