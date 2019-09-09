package api.controller;

public class Error {

    private int status;
    private String message;
    private String detail;

    public Error(final int status, final String message, final String detail) {

        this.status = status;
        this.message = message;
        this.detail = detail;
    }

    public int getCode() {

        return status;
    }

    public void setCode(int status) {

        this.status = status;
    }

    public String getMessage() {

        return message;
    }

    public void setMessage(String message) {

        this.message = message;
    }

    public String getDetail() {

        return detail;
    }

    public void setDetail(String detail) {

        this.detail = detail;
    }
}
