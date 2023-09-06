package com.movieFanSide.Customer.Repo;

import com.movieFanSide.Customer.Entity.Theater;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@EnableJpaRepositories
@Repository
public interface TheaterRepo extends JpaRepository<Theater,Integer> {
    //List<Theater> findByMovieMovieid(int movieid);
}
