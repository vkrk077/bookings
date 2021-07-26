package com.paypal.bfs.test.bookingserv.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Address resource
 * <p>
 * Address resource object
 * 
 */
@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AddressDao implements Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = -238759263417762977L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
	
	private String line1;
 
    private String line2;
   
    private String city;
   
    private String state;

    private String country;
 
    private String zipCode;

}
