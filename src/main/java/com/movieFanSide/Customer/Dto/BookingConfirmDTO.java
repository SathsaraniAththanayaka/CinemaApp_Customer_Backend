package com.movieFanSide.Customer.Dto;

public class BookingConfirmDTO {
    private int bookingID;
    private int customerID;
    private int noOfBookedSeats;
    private String message;

    public BookingConfirmDTO(int bookingID, int customerID, int noOfBookedSeats, String message) {
        this.bookingID = bookingID;
        this.customerID = customerID;
        this.noOfBookedSeats = noOfBookedSeats;
        this.message = message;
    }

    public BookingConfirmDTO() {
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
