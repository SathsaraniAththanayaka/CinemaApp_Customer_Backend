package com.movieFanSide.Customer.Service.Impl;

import com.movieFanSide.Customer.Dto.*;
import com.movieFanSide.Customer.Entity.*;
import com.movieFanSide.Customer.Repo.*;
import com.movieFanSide.Customer.Response.LoginResponse;
import com.movieFanSide.Customer.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

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
    private SeatRepo seatRepo;

    @Autowired
    private PriceRepo priceRepo;

    @Autowired BookingRepo bookingRepo;

    @Autowired
    private ConfirmedBookingRepo confirmedBookingRepo;

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
    public List<MovieDetailsDTO> getMovies() {
        List<Movie> movies = movieRepo.findAll();
        List<MovieDetailsDTO> movieDetailsDTOs = new ArrayList<>();

        for(Movie movie : movies){
            MovieDetailsDTO movieDetailsDTO = new MovieDetailsDTO();
            movieDetailsDTO.setMovieid(movie.getMovieid());
            movieDetailsDTO.setImage(movie.getImage());
            movieDetailsDTO.setTitle(movie.getTitle());
            movieDetailsDTO.setDescription(movie.getDescription());
            movieDetailsDTO.setLanguage(movie.getLanguage());
            movieDetailsDTO.setDuration(movie.getDuration());
            movieDetailsDTO.setReleaseDate(movie.getReleaseDate());

            movieDetailsDTOs.add(movieDetailsDTO);
        }
        return movieDetailsDTOs;
    }

    @Override
    public ShowDTO getShows(int movieid) {
        List<Schedule> schedules = scheduleRepo.findByMovieMovieid(movieid);

        Map<Integer, Map<String, List<Schedule>>> theaterDateMap = new HashMap<>();

        for (Schedule schedule : schedules) {
            int theaterId = schedule.getTheater().getTheaterid();
            String date = schedule.getDate();

            theaterDateMap.computeIfAbsent(theaterId, k -> new HashMap<>())
                    .computeIfAbsent(date, k -> new ArrayList<>())
                    .add(schedule);
        }

        List<ShowDTO.Theater> showTheaters = new ArrayList<>();

        for (Map.Entry<Integer, Map<String, List<Schedule>>> theaterEntry : theaterDateMap.entrySet()) {
            int theaterId = theaterEntry.getKey();
            Theater theater = theaterRepo.findById(theaterId).orElse(null);

            if (theater != null) {
                ShowDTO.Theater showTheater = new ShowDTO.Theater();
                showTheater.setTheaterid(theaterId);
                showTheater.setTheaterName(theater.getName());
                showTheater.setTheaterCity(theater.getCity());

                List<ShowDTO.Date> showDates = new ArrayList<>();

                for (Map.Entry<String, List<Schedule>> dateEntry : theaterEntry.getValue().entrySet()) {
                    ShowDTO.Date showDate = new ShowDTO.Date();
                    showDate.setDate(dateEntry.getKey());

                    List<ShowDTO.Time> showTimes = new ArrayList<>();
                    for (Schedule schedule : dateEntry.getValue()) {
                        ShowDTO.Time showTime = new ShowDTO.Time();
                        showTime.setTime(schedule.getTime());
                        showTime.setScheduleid(String.valueOf(schedule.getScheduleid()));
                        showTimes.add(showTime);
                    }

                    showDate.setTimes(showTimes);
                    showDates.add(showDate);
                }

                showTheater.setDates(showDates);
                showTheaters.add(showTheater);
            }
        }

        ShowDTO showDTO = new ShowDTO();
        showDTO.setMovieid(movieid);
        showDTO.setTheaters(showTheaters);

        return showDTO;
    }

    @Override
    public List<SeatDTO> getSeats(int showid,int theaterId) {
        List<SeatNo> seats = seatRepo.findByScheduleScheduleid(showid);
        List<SeatDTO> seatDTOs = new ArrayList<>();

        for (SeatNo seat : seats){
            SeatDTO seatDTO = new SeatDTO(
                    seat.getSeatType(),
                    seat.getSeatNo()
            );

            Price seatPrice = priceRepo.findByTheaterTheateridAndSeatCategory(theaterId, seat.getSeatType());
            seatDTO.setPrice(seatPrice.getPrice());
            seatDTOs.add(seatDTO);
        }

        return seatDTOs;
    }

    @Override
    public int addBooking(ReserveSeatDTO reserveSeatDTO) {
        Booking booking = new Booking(
                reserveSeatDTO.getBookingid(),
                reserveSeatDTO.getShowid(),
                reserveSeatDTO.getSeatCategory(),
                reserveSeatDTO.getNoOfSeats(),
                reserveSeatDTO.getCustomerid()
        );

        bookingRepo.save(booking);

        return booking.getBookingid();
    }

    @Override
    public String getName(int customerid) {
        Customer customer = customerRepo.findById(customerid);
        return customer.getCustomerName();
    }

    @Override
    public String getConfirm(int bookingid) {
        ConfirmedBookings confirmedBookings = confirmedBookingRepo.findByBookingid(bookingid);
        return confirmedBookings.getMessage();
    }


}
