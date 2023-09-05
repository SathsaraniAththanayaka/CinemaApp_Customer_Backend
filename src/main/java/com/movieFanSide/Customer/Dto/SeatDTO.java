package com.movieFanSide.Customer.Dto;

public class SeatDTO {
    private String seatType;
    private int SeatNo;

    private Double price;

    public SeatDTO(String seatType, int seatNo) {
        this.seatType = seatType;
        this.SeatNo = seatNo;
       
    }

    public SeatDTO() {
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getSeatType() {
        return seatType;
    }

    public void setSeatType(String seatType) {
        this.seatType = seatType;
    }

    public int getSeatNo() {
        return SeatNo;
    }

    public void setSeatNo(int seatNo) {
        SeatNo = seatNo;
    }
}
