package com.project.hm.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class HotelCategory {
	  @Id
	    private Long id;
	    private String categoryName;
}
