package com.project.hm.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class PlateRange {

	
	@Id
	private Integer id;
	private Integer noOfPlates;
}
