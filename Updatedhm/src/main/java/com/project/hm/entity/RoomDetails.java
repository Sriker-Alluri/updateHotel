package com.project.hm.entity;

import javax.persistence.Entity;


import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Data;
@Data
@Entity

public class RoomDetails {

	@Id
	private Long id;
	private Double price;
	private Integer roomNo;
	private String description;
	
	@OneToOne
	private RoomsCategory roomsCategory;
	
	@OneToOne
	private HotelNames hotelNames;
	

	
	
}
