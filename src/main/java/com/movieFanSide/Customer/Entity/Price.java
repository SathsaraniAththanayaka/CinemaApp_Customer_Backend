package com.movieFanSide.Customer.Entity;

import javax.persistence.*;

@Entity
@Table(name = "price")
public class Price {
    @Id
    @Column(name = "price_id",length = 45)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int priceid;
    @ManyToOne
    @JoinColumn(name = "theater_id")
    private Theater theater;

    @Column(name = "seat_category",length = 255)
    private String seatCategory;

    @Column(name = "seat_price",length = 255)
    private Double price;

    public Price(int priceid, Theater theater, String seatCategory, Double price) {
        this.priceid = priceid;
        this.theater = theater;
        this.seatCategory = seatCategory;
        this.price = price;
    }

    public Price() {
    }

    public int getPriceid() {
        return priceid;
    }

    public void setPriceid(int priceid) {
        this.priceid = priceid;
    }

    public Theater getTheater() {
        return theater;
    }

    public void setTheater(Theater theater) {
        this.theater = theater;
    }

    public String getSeatCategory() {
        return seatCategory;
    }

    public void setSeatCategory(String seatCategory) {
        this.seatCategory = seatCategory;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
