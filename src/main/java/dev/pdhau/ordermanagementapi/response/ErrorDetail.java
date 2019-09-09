package dev.pdhau.ordermanagementapi.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorDetail {

    private String field;
    private String message;

    public ErrorDetail(String field, String message) {
        this.field = field;
        this.message = message;
    }
}
