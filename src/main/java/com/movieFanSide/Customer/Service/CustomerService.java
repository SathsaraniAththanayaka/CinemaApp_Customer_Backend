package com.movieFanSide.Customer.Service;

import com.movieFanSide.Customer.Dto.*;
import com.movieFanSide.Customer.Response.LoginResponse;

import java.util.List;

public interface CustomerService {
    String addCustomer(CustomerDTO customerDTO);

    LoginResponse loginCustomer(LoginDTO loginDTO);

    int getCustomerIdByEmail(String email);

    int editCustomer(CustomerDTO customerDTO);

    List<MovieDetailsDTO> getMovies();

    ShowDTO getShows(int movieid);

    List<SeatDTO> getSeats(int showid);
}
