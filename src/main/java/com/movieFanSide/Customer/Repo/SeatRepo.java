package com.movieFanSide.Customer.Repo;

import com.movieFanSide.Customer.Entity.SeatNo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@EnableJpaRepositories
@Repository
public interface SeatRepo extends JpaRepository<SeatNo,Integer> {
    List<SeatNo> findByScheduleScheduleid(int showid);

}
