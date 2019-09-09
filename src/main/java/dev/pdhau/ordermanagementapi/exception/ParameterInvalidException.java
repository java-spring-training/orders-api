package dev.pdhau.ordermanagementapi.exception;

import java.util.List;

import dev.pdhau.ordermanagementapi.response.ErrorDetail;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ParameterInvalidException extends Exception {

    private static final long serialVersionUID = 1L;

    private List<ErrorDetail> errorDetails;

    public ParameterInvalidException(String message) {
        super(message);
        this.errorDetails = null;
    }
}
