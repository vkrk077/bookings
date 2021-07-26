
package com.paypal.bfs.test.bookingserv.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * Booking resource
 * <p>
 * Booking resource object
 * 
 */
@Data
@Builder
@Entity
@Table(uniqueConstraints = { @UniqueConstraint(name ="ux_fname_lname_dob", columnNames = { "firstName", "lastName","dateOfBirth" }) })
@AllArgsConstructor
@NoArgsConstructor
public class BookingDao implements Serializable{


	/**
	 * 
	 */
	private static final long serialVersionUID = 6839861657159048350L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String firstName;

    private String lastName;

    private LocalDate dateOfBirth;
  
    private LocalDateTime checkIn;
 
    private LocalDateTime checkOut;
   
    private Double totalPrice;
  
    private Double deposit;
   
    private AddressDao address;
    
  

}
