package com.project.hm.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class DisplayActivities {

	@Id
    private Integer id;
    
    @OneToOne()
    private HotelNames hotelnames;
    
    @OneToOne()
    private Activities activities;
}
