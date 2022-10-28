package com.project.hm.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class FoodMenu {
	@Id
    private Integer id;
    private String items;
     @OneToOne
     private FoodCategory foodCategory;
    
}
