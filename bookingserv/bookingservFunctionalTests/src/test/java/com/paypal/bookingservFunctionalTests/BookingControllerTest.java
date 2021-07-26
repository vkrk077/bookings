package com.paypal.bookingservFunctionalTests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class BookingControllerTest {
	@LocalServerPort
	private int port;
	
	
	private TestRestTemplate restTemplate;
	
	@Test
	public void bookingResourceReturnsSuccessfulResponse() {
		
		String bookingJson = "{\n"
				+ "    \"first_name\": \"ravikiran\",\n"
				+ "    \"last_name\": \"krishnaprasad\",\n"
				+ "    \"date_of_birth\": \"06-02-1988\",\n"
				+ "    \"check_in\": \"12-06-2021 05:30\",\n"
				+ "    \"check_out\": \"12-06-2021 14:30\",\n"
				+ "    \"total_price\": 12.32,\n"
				+ "    \"deposit\": 32,\n"
				+ "    \"address\": {\n"
				+ "        \"line1\": \"SS\",\n"
				+ "        \"line2\": \"SS\",\n"
				+ "        \"city\": \"SS\",\n"
				+ "        \"state\": \"SS\",\n"
				+ "        \"country\": \"SS\",\n"
				+ "        \"zip_code\": \"SS\"\n"
				+ "    }\n"
				+ "}";
		

		
		String bookingResponse =restTemplate.postForObject("http://localhost:"+port+"/v1/bfs/booking", bookingJson, null, String.class);
		assertEquals(bookingResponse, bookingJson);
	
	}
	
	@Test
	public void bookingResourceReturnsErrorOnDuplicateResourceCreation() {
		
	}
	
	@Test
	public void getAllBookingResourceShouldReturnAllResources() {
		
	}

}
