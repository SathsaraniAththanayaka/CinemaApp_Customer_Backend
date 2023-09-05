package com.movieFanSide.Customer.Repo;

import com.movieFanSide.Customer.Entity.Price;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@EnableJpaRepositories
@Repository
public interface PriceRepo extends JpaRepository<Price,Integer> {
    Price findByTheaterTheateridAndSeatCategory(int theaterId, String seatCategory);
}
