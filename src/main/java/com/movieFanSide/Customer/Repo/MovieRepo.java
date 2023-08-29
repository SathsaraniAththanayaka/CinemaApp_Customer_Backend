package com.movieFanSide.Customer.Repo;

import com.movieFanSide.Customer.Entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;
@EnableJpaRepositories
@Repository
public interface MovieRepo extends JpaRepository<Movie, Integer> {
    List<Movie> findAll();
    Movie findByTitle(String title);
}
