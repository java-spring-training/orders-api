package api.controller;

public class CustomerResponse {

    private int status;

    public CustomerResponse(int status) {

        this.status = status;
    }

    public int getStatus() {

        return status;
    }

    public void setStatus(int status) {

        this.status = status;
    }
}
