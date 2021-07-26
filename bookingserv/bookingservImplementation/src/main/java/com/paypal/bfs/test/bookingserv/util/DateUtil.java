package com.paypal.bfs.test.bookingserv.util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class DateUtil {

	public static LocalDate toLocalDate(String dateString) {
	
		return LocalDate.parse(dateString,DateTimeFormatter.ofPattern("dd-MM-yyyy"));
	}

	public static LocalDateTime toLocalDateTime(String time) {

		return LocalDateTime.parse(time,DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm"));
	}

}
