package com.movieFanSide.Customer.Dto;

public class BookingDTO {

    private int bookingID;

    private int customerID;

    private String name;

    private String customerEmail;

    private int showId;

    private String seatCategory;

    private int noOfBookedSeats;

    public BookingDTO(int bookingID, int customerID, String name, String customerEmail, int showId,
                      String seatCategory, int noOfBookedSeats) {
        this.bookingID = bookingID;
        this.customerID = customerID;
        this.name = name;
        this.customerEmail = customerEmail;
        this.showId = showId;
        this.seatCategory = seatCategory;
        this.noOfBookedSeats = noOfBookedSeats;
    }

    public BookingDTO(int bookingID, int customerID,int showId,
                      String seatCategory, int noOfBookedSeats) {
        this.bookingID = bookingID;
        this.customerID = customerID;
        this.showId = showId;
        this.seatCategory = seatCategory;
        this.noOfBookedSeats = noOfBookedSeats;
    }

    public BookingDTO() {
    }

    public int getBookingID() {
        return bookingID;
    }

    public void setBookingID(int bookingID) {
        this.bookingID = bookingID;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public int getShowId() {
        return showId;
    }

    public void setShowId(int showId) {
        this.showId = showId;
    }

    public String getSeatCategory() {
        return seatCategory;
    }

    public void setSeatCategory(String seatCategory) {
        this.seatCategory = seatCategory;
    }

    public int getNoOfBookedSeats() {
        return noOfBookedSeats;
    }

    public void setNoOfBookedSeats(int noOfBookedSeats) {
        this.noOfBookedSeats = noOfBookedSeats;
    }
}
