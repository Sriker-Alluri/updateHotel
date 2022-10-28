package com.project.hm.entity;

import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;
@Data
@Entity
public class FoodCategory {
	  @Id
	    private Long id;
 private String foodCategoryType;
	    private LocalTime startTime;
    private LocalTime endTime;
 //private LocalTime timeLimit;
	    private Double price;
//		public FoodCategory(LocalTime startTime, LocalTime endTime) {
//			super();
//			this.startTime = startTime;
//			this.endTime = endTime;
//		}
	    

	    

}
