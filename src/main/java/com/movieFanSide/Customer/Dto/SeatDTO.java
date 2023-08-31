package com.movieFanSide.Customer.Dto;

public class SeatDTO {
    private String seatType;
    private int SeatNo;

    public SeatDTO(String seatType, int seatNo) {
        this.seatType = seatType;
        SeatNo = seatNo;
    }

    public SeatDTO() {
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
