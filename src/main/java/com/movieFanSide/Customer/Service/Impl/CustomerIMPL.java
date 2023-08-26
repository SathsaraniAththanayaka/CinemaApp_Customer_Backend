package com.movieFanSide.Customer.Service.Impl;

import com.movieFanSide.Customer.Dto.CustomerDTO;
import com.movieFanSide.Customer.Dto.LoginDTO;
import com.movieFanSide.Customer.Entity.Customer;
import com.movieFanSide.Customer.Repo.CustomerRepo;
import com.movieFanSide.Customer.Response.LoginResponse;
import com.movieFanSide.Customer.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerIMPL implements CustomerService {
    @Autowired
    private CustomerRepo customerRepo;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Override
    public String addCustomer(CustomerDTO customerDTO) {
        Customer customer1 = customerRepo.findByEmail(customerDTO.getEmail());

        if(customer1!= null){
            return  "Email already exists";
        }
        else{
            Customer customer = new Customer(
                    customerDTO.getCustomerid(),
                    customerDTO.getCustomerName(),
                    customerDTO.getEmail(),
                    this.passwordEncoder.encode(customerDTO.getPassword())
            );

            customerRepo.save(customer);

            return customer.getCustomerName();
        }



    }

    @Override
    public LoginResponse loginCustomer(LoginDTO loginDTO) {
        String msg = "";
        Customer customer1 = customerRepo.findByEmail(loginDTO.getEmail());
        if (customer1 != null) {
            String password = loginDTO.getPassword();
            String encodedPassword = customer1.getPassword();
            Boolean isPwdRight = passwordEncoder.matches(password, encodedPassword);
            if (isPwdRight) {
                Optional<Customer> customer = customerRepo.findOneByEmailAndPassword(loginDTO.getEmail(), encodedPassword);
                if (customer.isPresent()) {
                    return new LoginResponse("Login Success", true);
                } else {
                    return new LoginResponse("Login Failed", false);
                }
            } else {
                return new LoginResponse("password Not Match", false);
            }
        }else {
            return new LoginResponse("Email not exits", false);
        }
    }

    @Override
    public int getCustomerIdByEmail(String email) {
        Customer customer = customerRepo.findByEmail(email);
        if (customer != null) {
            return customer.getCustomerid();
        }
        return -1;

    }

    @Override
    public int editCustomer(CustomerDTO customerDTO) {
        Customer customer1 = customerRepo.findById(customerDTO.getCustomerid());
        customer1.setCustomerName(customerDTO.getCustomerName());
        customer1.setEmail(customerDTO.getEmail());
        customer1.setPassword(customer1.getPassword());

        customerRepo.save(customer1);
        return customer1.getCustomerid();
    }


}
