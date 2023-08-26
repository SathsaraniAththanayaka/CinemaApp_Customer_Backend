package com.movieFanSide.Customer.Entity;

import javax.persistence.*;

@Entity
@Table(name = "customers")
public class Customer {
    @Id
    @Column(name="customer_id",length = 45)
    @GeneratedValue(strategy = GenerationType.AUTO)

    private int customerid;

    @Column(name="customer_name",length = 255)
    private String customerName;

    @Column(name="customer_email",length = 255)
    private String email;

    @Column(name="customer_password", length = 255)
    private String password;

    public Customer(int customerid, String customerName, String email, String password) {
        this.customerid = customerid;
        this.customerName = customerName;
        this.email = email;
        this.password = password;
    }

    public Customer() {

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
        return "Customer{" +
                "customerid=" + customerid +
                ", customerName='" + customerName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
