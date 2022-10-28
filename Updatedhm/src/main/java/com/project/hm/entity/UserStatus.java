package com.project.hm.entity;

import java.time.LocalDate;

import javax.persistence.Id;
import javax.persistence.OneToOne;

public class UserStatus {

	@Id
	private Integer id;
	private LocalDate checkIn;
	private LocalDate checkOut;
	private Integer days;
	
	@OneToOne
	private RoomDetails roomDetails;
	
	@OneToOne
	private UserRegistration userRegistration;
}
