package com.movieFanSide.Customer.Entity;

import javax.persistence.*;

@Entity
@Table(name = "seat_availability")
public class SeatNo {
    @Id
    @Column(name = "availability_id",length = 45)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int availabilityid;

    @ManyToOne
    @JoinColumn(name = "schedule_id")
    private Schedule schedule;

    @Column(name = "seatType",length = 45)
    private String seatType;

    @Column(name = "seatNo",length = 45)
    private int seatNo;

    public int getAvailabilityid() {
        return availabilityid;
    }

    public void setAvailabilityid(int availabilityid) {
        this.availabilityid = availabilityid;
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }

    public String getSeatType() {
        return seatType;
    }

    public void setSeatType(String seatType) {
        this.seatType = seatType;
    }

    public int getSeatNo() {
        return seatNo;
    }

    public void setSeatNo(int seatNo) {
        this.seatNo = seatNo;
    }

    public SeatNo(int availabilityid, Schedule schedule, String seatType, int seatNo) {
        this.availabilityid = availabilityid;
        this.schedule = schedule;
        this.seatType = seatType;
        this.seatNo = seatNo;
    }

    public SeatNo() {
    }
}
