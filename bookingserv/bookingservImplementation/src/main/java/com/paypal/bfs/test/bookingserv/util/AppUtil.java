package com.paypal.bfs.test.bookingserv.util;

import java.util.ArrayList;
import java.util.List;

import com.paypal.bfs.test.bookingserv.api.model.Address;
import com.paypal.bfs.test.bookingserv.api.model.Booking;
import com.paypal.bfs.test.bookingserv.entities.AddressDao;
import com.paypal.bfs.test.bookingserv.entities.BookingDao;

public class AppUtil {
	public static List<Booking> convertIntoJsonReference(List<BookingDao> bookingDao) {
		List<Booking> bookings = new ArrayList<>();
		
		for(BookingDao dao:bookingDao) {
			Booking booking = new Booking();
			booking.setId(dao.getId());
			booking.setFirstName(dao.getFirstName());
			booking.setLastName(dao.getLastName());
			booking.setDateOfBirth(dao.getDateOfBirth().toString());
			booking.setCheckIn(dao.getCheckIn().toString());
			booking.setCheckOut(dao.getCheckOut().toString());
			booking.setDeposit(dao.getDeposit());
			booking.setTotalPrice(dao.getTotalPrice());
			booking.setAddress(convertIntoJsonReference(dao.getAddress()));
			bookings.add(booking);
		}
		
		return bookings;
	}
	
	public static Address convertIntoJsonReference(AddressDao dao) {
		Address address = new Address();
		address.setLine1(dao.getLine1());
		address.setLine2(dao.getLine2());
		address.setCity(dao.getCity());
		address.setState(dao.getState());
		address.setCountry(dao.getCountry());
		address.setZipCode(dao.getZipCode());
		return address;
	}


	public static BookingDao convertIntoDataModel(Booking booking) {
		return BookingDao.builder()
				.firstName(booking.getFirstName())
				.lastName(booking.getLastName())
				.dateOfBirth(DateUtil.toLocalDate(booking.getDateOfBirth()))
				.checkIn(DateUtil.toLocalDateTime(booking.getCheckIn()))
				.checkOut(DateUtil.toLocalDateTime(booking.getCheckOut()))
				.address(AddressDao.builder()
						.line1(booking.getAddress().getLine1())
						.line2(booking.getAddress().getLine2())
						.city(booking.getAddress().getCity())
						.country(booking.getAddress().getCountry())
						.state(booking.getAddress().getState())
						.zipCode(booking.getAddress().getZipCode())
						.build())
				.build();
	}

}
