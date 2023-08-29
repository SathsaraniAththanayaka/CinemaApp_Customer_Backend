package com.movieFanSide.Customer.Service;

import com.movieFanSide.Customer.Dto.CustomerDTO;
import com.movieFanSide.Customer.Dto.LoginDTO;
import com.movieFanSide.Customer.Dto.MovieDTO;
import com.movieFanSide.Customer.Response.LoginResponse;

import java.util.List;

public interface CustomerService {
    String addCustomer(CustomerDTO customerDTO);

    LoginResponse loginCustomer(LoginDTO loginDTO);

    int getCustomerIdByEmail(String email);

    int editCustomer(CustomerDTO customerDTO);

    List<MovieDTO> getMovies();
}
