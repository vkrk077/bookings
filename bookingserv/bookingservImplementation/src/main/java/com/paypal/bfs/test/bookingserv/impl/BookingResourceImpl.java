package com.paypal.bfs.test.bookingserv.impl;

import com.paypal.bfs.test.bookingserv.api.BookingResource;
import com.paypal.bfs.test.bookingserv.api.model.Booking;
import com.paypal.bfs.test.bookingserv.service.BookingService;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookingResourceImpl implements BookingResource {
	@Autowired
	private BookingService bookingService;

	
    @Override
    public ResponseEntity<Booking> create(Booking booking) throws Exception {
    	return bookingService.create(booking);
    }


	public ResponseEntity<List<Booking>> getAllBookings() {

		return bookingService.getAllBookings();
	}

}
