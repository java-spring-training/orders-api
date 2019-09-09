package dev.pdhau.ordermanagementapi.response;

public enum ResponseCode {
    success("success"),
    system_error("system_error"),
    validate_error("validate_error");

    private String value;

    private ResponseCode(String value) {
        this.value = value;
    }

    /**
     * @return the value
     */
    public String getValue() {
        return value;
    }
}
