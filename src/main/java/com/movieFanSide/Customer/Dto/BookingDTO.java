package com.movieFanSide.Customer.Dto;

public class BookingDTO {
    private String showID;
    private String type;

    private int seatNo;

    public BookingDTO(String showID, String type, int seatNo) {
        this.showID = showID;
        this.type = type;
        this.seatNo = seatNo;
    }

    public BookingDTO() {
    }

    public String getShowID() {
        return showID;
    }

    public void setShowID(String showID) {
        this.showID = showID;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getSeatNo() {
        return seatNo;
    }

    public void setSeatNo(int seatNo) {
        this.seatNo = seatNo;
    }
}
