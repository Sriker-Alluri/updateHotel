package com.project.hm.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
@Data
@Entity
public class Activities {

	 @Id
	    private Long id;
	    private String activityName;
	    private Double price;
	    
	    @ManyToMany(mappedBy = "activity",fetch = FetchType.LAZY)
	    	         @JsonIgnore
	    	         private List<HotelNames> hotelnames;
	    
}
