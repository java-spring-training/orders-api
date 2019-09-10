package api.controller;

public class CustomReponse {

    private int status;

    public CustomReponse(int status) {

        this.status = status;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}