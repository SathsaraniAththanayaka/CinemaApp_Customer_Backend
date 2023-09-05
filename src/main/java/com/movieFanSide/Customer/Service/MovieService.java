package com.movieFanSide.Customer.Service;

import com.movieFanSide.Customer.Dto.BookingConfirmDTO;
import com.movieFanSide.Customer.Dto.MovieDTO;

public interface MovieService {
    String addMovie(MovieDTO movieDTO);

    void addConfirmedBooking(BookingConfirmDTO bookingConfirmDTO);

}
