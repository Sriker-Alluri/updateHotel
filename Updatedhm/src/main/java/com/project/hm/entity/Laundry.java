package com.project.hm.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Laundry {
    @Id
	private Integer id;
	private Boolean laundry;
	
	@OneToOne
	private RoomDetails roomDetails;
}
