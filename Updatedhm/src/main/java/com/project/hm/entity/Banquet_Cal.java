package com.project.hm.entity;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Banquet_Cal {

@Id
	private Integer id;
	private Double price;


	    
	@OneToOne()
	private RoomsCategory roomsCategory;



	@OneToOne()
	private BanquetHall banquetHall;



	@Enumerated(value=EnumType.STRING)
	private Thali thali;



	@OneToOne()
	private PlateRange platerange;


}
