package com.movieFanSide.Customer.Dto;

public class ReserveSeatDTO {
    private int bookingid;
    private int customerid;
    private int showid;

    private String seatCategory;

    private int noOfSeats;

    public ReserveSeatDTO(int bookingid, int customerid, int showid, String seatCategory, int noOfSeats) {
        this.bookingid = bookingid;
        this.customerid = customerid;
        this.showid = showid;
        this.seatCategory = seatCategory;
        this.noOfSeats = noOfSeats;
    }

    public ReserveSeatDTO() {
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
}
