package dev.pdhau.ordermanagementapi.response;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Error {

    private ResponseCode code;
    private List<ErrorDetail> details;

    public Error(ResponseCode code, List<ErrorDetail> details) {
        this.code = code;
        this.details = details;
    }
}
