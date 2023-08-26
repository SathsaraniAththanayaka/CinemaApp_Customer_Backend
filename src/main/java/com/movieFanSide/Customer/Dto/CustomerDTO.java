package com.movieFanSide.Customer.Dto;

public class CustomerDTO {
    private int customerid;
    private String customerName;
    private String email;
    private String password;

    public CustomerDTO(int customerid, String customerName, String email, String password) {
        this.customerid = customerid;
        this.customerName = customerName;
        this.email = email;
        this.password = password;
    }

    public CustomerDTO() {

    }

    public int getCustomerid() {
        return customerid;
    }

    public void setCustomerid(int customerid) {
        this.customerid = customerid;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "CustomerDTO{" +
                "customerid=" + customerid +
                ", customerName='" + customerName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
