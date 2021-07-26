package com.paypal.bfs.test.bookingserv.api;



import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.paypal.bfs.test.bookingserv.api.model.Booking;

public interface BookingResource {
    /**
     * Create {@link Booking1} resource
     *
     * @param booking the booking object
     * @return the created booking
     */
    @PostMapping("/v1/bfs/booking")
    ResponseEntity<Booking> create(@RequestBody Booking booking) throws Exception;

    @GetMapping("/v1/bfs/bookings")
    ResponseEntity<List<Booking>> getAllBookings();
}
