package com.movieFanSide.Customer.Response;

public class LoginResponse {
    String message;
    Boolean status;
    int id;

    public LoginResponse(String message, Boolean status) {
        this.message = message;
        this.status = status;
        this.id = -1;
    }

    public LoginResponse() {

    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "LoginResponse{" +
                "message='" + message + '\'' +
                ", status=" + status +
                ", id=" + id +
                '}';
    }
}
