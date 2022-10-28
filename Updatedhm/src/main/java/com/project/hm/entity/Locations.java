package com.project.hm.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity

public class Locations {

	   
	    @Id
		@GeneratedValue(strategy=GenerationType.AUTO)
	    
	    private Long id;
	    private String cityName;
	    private String address;
	    
//  @OneToOne(mappedBy ="location" )
//	    private HotelNames hotelNames;
	    }


