package example.controller;

import lombok.AllArgsConstructor;
import lombok.Builder;

@Builder
@AllArgsConstructor
public class Error {
    private int code;
    private String detail;
    private String message;
}
