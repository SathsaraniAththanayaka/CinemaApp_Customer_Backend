package com.movieFanSide.Customer.Service;

import com.movieFanSide.Customer.Entity.Customer;
import com.movieFanSide.Customer.Repo.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private CustomerRepo customerRepo;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        final Customer customer = customerRepo.findByEmail(email);
        if(customer == null){
            throw new UsernameNotFoundException(email);
        }
        return new CustomUserDetails(customer);
    }
}
