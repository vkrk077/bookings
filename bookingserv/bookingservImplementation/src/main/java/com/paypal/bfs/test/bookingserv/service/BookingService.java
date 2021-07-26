package com.paypal.bfs.test.bookingserv.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.paypal.bfs.test.bookingserv.api.model.Booking;
import com.paypal.bfs.test.bookingserv.repository.BookingRepository;
import com.paypal.bfs.test.bookingserv.util.AppUtil;

import exception.BookingAlreadyExistsException;

@Service
public class BookingService {
	
	@Autowired
	private BookingRepository bookingRepository;

	
    public ResponseEntity<Booking> create(Booking booking) throws Exception {
    	try {
    		bookingRepository.save(AppUtil.convertIntoDataModel(booking));
    		return new ResponseEntity<Booking>(booking,HttpStatus.CREATED);
    	}
    	catch(DataIntegrityViolationException exception) {
    		throw new BookingAlreadyExistsException("Booking already exists");
    	}
    }


	public ResponseEntity<List<Booking>> getAllBookings() {

		return new ResponseEntity<List<Booking>>(AppUtil.convertIntoJsonReference(bookingRepository.findAll()),HttpStatus.OK);
	}

}
