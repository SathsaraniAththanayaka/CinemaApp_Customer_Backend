package com.movieFanSide.Customer.Service.Impl;

import com.movieFanSide.Customer.Dto.CustomerDTO;
import com.movieFanSide.Customer.Dto.LoginDTO;
import com.movieFanSide.Customer.Dto.MovieDTO;
import com.movieFanSide.Customer.Entity.Customer;
import com.movieFanSide.Customer.Entity.Movie;
import com.movieFanSide.Customer.Entity.Schedule;
import com.movieFanSide.Customer.Entity.Theater;
import com.movieFanSide.Customer.Repo.CustomerRepo;
import com.movieFanSide.Customer.Repo.ScheduleRepo;
import com.movieFanSide.Customer.Repo.MovieRepo;
import com.movieFanSide.Customer.Repo.TheaterRepo;
import com.movieFanSide.Customer.Response.LoginResponse;
import com.movieFanSide.Customer.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerIMPL implements CustomerService {
    @Autowired
    private CustomerRepo customerRepo;

    @Autowired
    private MovieRepo movieRepo;

    @Autowired
    private TheaterRepo theaterRepo;

    @Autowired
    private ScheduleRepo scheduleRepo;
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

    @Override
    public List<MovieDTO> getMovies() {
        return null;
    }

//    @Override
//    public List<MovieDTO> getMovies() {
//        List<Movie> movies = movieRepo.findAll();
//        List<MovieDTO> movieDTOs = new ArrayList<>();
//
//        for (Movie movie : movies) {
//            MovieDTO movieDTO = new MovieDTO();
//            movieDTO.setMovieid(movie.getMovieid());
//            movieDTO.setImage(movie.getImage());
//            movieDTO.setTitle(movie.getTitle());
//            movieDTO.setDescription(movie.getDescription());
//            movieDTO.setLanguage(movie.getLanguage());
//            movieDTO.setDuration(movie.getDuration());
//            movieDTO.setReleaseDate(movie.getReleaseDate());
//
//            List<MovieDTO.Theater> theaterDTOs = new ArrayList<>();
//            List<Theater> theaters = theaterRepo.findByMovieMovieid(movie.getMovieid());
//            for (Theater theater : theaters) {
//                MovieDTO.Theater theaterDTO = new MovieDTO.Theater();
//                theaterDTO.setTheaterid(theater.getTheaterid());
//                theaterDTO.setName(theater.getName());
//                theaterDTO.setCity(theater.getCity());
//
//                List<MovieDTO.Schedule> scheduleDTOs = new ArrayList<>();
//                List<Schedule> schedules = scheduleRepo.findByTheaterTheaterid(theater.getTheaterid());
//                for(Schedule schedule: schedules){
//                    MovieDTO.Schedule scheduleDTO = new MovieDTO.Schedule();
//                    scheduleDTO.setScheduleid(schedule.getScheduleid());
//                    scheduleDTO.setDate(schedule.getDate());
//                    scheduleDTO.setTimes(schedule.getTimes());
//                    scheduleDTOs.add(scheduleDTO);
//                }
//                theaterDTO.setSchedule(scheduleDTOs);
//                theaterDTOs.add(theaterDTO);
//            }
//            movieDTO.setPlaces(theaterDTOs);
//
//            movieDTOs.add(movieDTO);
//        }
//        return movieDTOs;
//    }


}
