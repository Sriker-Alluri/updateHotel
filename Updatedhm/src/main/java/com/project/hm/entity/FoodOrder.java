package com.project.hm.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class FoodOrder {

	@Id
	private Integer id;
	
	@OneToOne
	private FoodCategory foodCategory;
	
	@OneToOne
	private FoodMenu foodMenu;
}
