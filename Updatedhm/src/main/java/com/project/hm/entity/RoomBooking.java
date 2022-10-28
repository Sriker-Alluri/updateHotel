package com.project.hm.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class RoomBooking {
	@Id
	private Long id;
	private LocalDate checkIn;
	private LocalDate checkOut;
	private Integer days;
	

}
