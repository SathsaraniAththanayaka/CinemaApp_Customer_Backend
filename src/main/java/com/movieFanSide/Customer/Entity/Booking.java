package com.movieFanSide.Customer.Entity;

import javax.persistence.*;

@Entity
@Table(name = "booking")
public class Booking {
    @Id
    @Column(name="booking_id",length = 45)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int bookingid;

    @Column(name="show_id",length = 45)
    private int showid;

    @Column(name="seat_category",length = 255)
    private String seatCategory;

    @Column(name="no_of_seats",length = 255)
    private int noOfSeats;

    @Column(name="customer_id",length = 45)
    private int customerid;


    public Booking(int bookingid, int showid, String seatCategory, int noOfSeats, int customerid) {
        this.bookingid = bookingid;
        this.showid = showid;
        this.seatCategory = seatCategory;
        this.noOfSeats = noOfSeats;
        this.customerid = customerid;

    }

    public Booking() {
    }

    public int getBookingid() {
        return bookingid;
    }

    public void setBookingid(int bookingid) {
        this.bookingid = bookingid;
    }

    public int getShowid() {
        return showid;
    }

    public void setShowid(int showid) {
        this.showid = showid;
    }

    public String getSeatCategory() {
        return seatCategory;
    }

    public void setSeatCategory(String seatCategory) {
        this.seatCategory = seatCategory;
    }

    public int getNoOfSeats() {
        return noOfSeats;
    }

    public void setNoOfSeats(int noOfSeats) {
        this.noOfSeats = noOfSeats;
    }

    public int getCustomerid() {
        return customerid;
    }

    public void setCustomerid(int customerid) {
        this.customerid = customerid;
    }

}
