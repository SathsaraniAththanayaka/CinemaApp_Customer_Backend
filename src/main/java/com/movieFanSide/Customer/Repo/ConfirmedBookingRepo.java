package com.movieFanSide.Customer.Repo;

import com.movieFanSide.Customer.Entity.ConfirmedBookings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@EnableJpaRepositories
@Repository
public interface ConfirmedBookingRepo extends JpaRepository<ConfirmedBookings,Integer> {
    ConfirmedBookings findByBookingid(int bookingid);
}
