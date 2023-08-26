package com.movieFanSide.Customer.Repo;

import com.movieFanSide.Customer.Entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@EnableJpaRepositories
@Repository
public interface CustomerRepo extends JpaRepository<Customer,Integer> {
    Optional<Customer> findOneByEmailAndPassword(String email, String password);
    Customer findByEmail(String email);
    Customer findById(int id);
}
