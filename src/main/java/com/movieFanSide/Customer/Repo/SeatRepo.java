package com.movieFanSide.Customer.Repo;

import com.movieFanSide.Customer.Entity.SeatNo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeatRepo extends JpaRepository<SeatNo,Integer> {
}
