package com.movieFanSide.Customer.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "booking_confirmed")
public class ConfirmedBookings {
    @Id
    @Column(name="booking_id",length = 45)
    private int bookingid;

    @Column(name="customer_id",length = 45)
    private int customerid;

    @Column(name="bookedSeats",length = 45)
    private int noOfBookedSeats;

    @Column(name="message",length = 225)
    private String message;

    public ConfirmedBookings(int bookingid, int customerid, int noOfBookedSeats, String message) {
        this.bookingid = bookingid;
        this.customerid = customerid;
        this.noOfBookedSeats = noOfBookedSeats;
        this.message = message;
    }

    public ConfirmedBookings() {
    }

    public int getBookingid() {
        return bookingid;
    }

    public void setBookingid(int bookingid) {
        this.bookingid = bookingid;
    }

    public int getCustomerid() {
        return customerid;
    }

    public void setCustomerid(int customerid) {
        this.customerid = customerid;
    }

    public int getNoOfBookedSeats() {
        return noOfBookedSeats;
    }

    public void setNoOfBookedSeats(int noOfBookedSeats) {
        this.noOfBookedSeats = noOfBookedSeats;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
