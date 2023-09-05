package com.movieFanSide.Customer.CustomerController;

import com.movieFanSide.Customer.Dto.*;
import com.movieFanSide.Customer.Entity.Movie;
import com.movieFanSide.Customer.Response.LoginResponse;
import com.movieFanSide.Customer.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.CurrentSecurityContext;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000/", allowedHeaders = {"Access-Control-Allow-Origin"})
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;
    @PostMapping(path = "/register")
    public String saveCustomer(@RequestBody CustomerDTO customerDTO){
        String id = customerService.addCustomer(customerDTO);
        return id;
    }

    @PostMapping(path = "/login")
    public ResponseEntity<?> loginCustomer(@RequestBody LoginDTO loginDTO){
        LoginResponse loginResponse = customerService.loginCustomer(loginDTO);
        if (loginResponse.getStatus()) {
            int customerId = customerService.getCustomerIdByEmail(loginDTO.getEmail());
            loginResponse.setId(customerId);
        }
        return ResponseEntity.ok(loginResponse);
    }

    @PutMapping(path = "/edit")
    public int updateCustomer(@RequestBody CustomerDTO customerDTO){
        int id = customerService.editCustomer(customerDTO);
        return id;
    }

    @GetMapping(path = "/movie")
    public List<MovieDetailsDTO> getMovies(){
        return  customerService.getMovies();
    }

    @GetMapping(path = "/shows")
    public ShowDTO getShows(int movieid){
        return  customerService.getShows(movieid);
    }

    @GetMapping(path = "/seat")
    public List<SeatDTO> getSeats(int showid, int theaterid){
        return customerService.getSeats(showid,theaterid);
    }

    @PostMapping(path = "/bookings")
    public int addBookings(@RequestBody ReserveSeatDTO reserveSeatDTO){
        return customerService.addBooking(reserveSeatDTO);

    }

    @GetMapping(path = "/details")
    public String getName(int customerid){
        return customerService.getName(customerid);
    }

    @GetMapping(path = "/confirm")
    public String getConfirm(int bookingid){
        return customerService.getConfirm(bookingid);
    }

}
