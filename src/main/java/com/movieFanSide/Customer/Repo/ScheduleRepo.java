package com.movieFanSide.Customer.Repo;

import com.movieFanSide.Customer.Entity.Schedule;
import com.movieFanSide.Customer.Entity.Theater;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@EnableJpaRepositories
@Repository
public interface ScheduleRepo extends JpaRepository<Schedule,Integer> {
    List<Schedule> findByTheaterTheaterid( int theaterid);
}
