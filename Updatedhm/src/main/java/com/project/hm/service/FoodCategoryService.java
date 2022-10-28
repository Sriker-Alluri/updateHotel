package com.project.hm.service;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.project.hm.entity.FoodCategory;
import com.project.hm.repository.FoodCategoryRepository;



@Service
public class FoodCategoryService{

//@Autowired
	//FoodCategory foodCategory;
@Autowired
	FoodCategoryRepository foodCategoryRepository;

	//public ResponseEntity<?> timeLimit(FoodCategory foodCategory) {
//	foodCategory.setStartTime(LocalTime.now());
//		foodCategory.setEndTime(LocalTime.now());
//		
//		
//		 
//if(LocalTime.of(7, 0, 0).isBefore(LocalTime.now()) && LocalTime.now().isBefore(LocalTime.of(11, 0, 0))) {
//public void timelimit(FoodCategory foodCategory){
//foodCategory.setStartTime(LocalTime.of(7, 0, 0));
//	foodCategory.setEndTime(LocalTime.of(11, 0, 0));
//	foodCategoryRepository.save(foodCategory);
//	//return new ResponseEntity<String>("Breakfast Menu",HttpStatus.OK);
	
//}
public FoodCategory displayFoodCategory(FoodCategory foodCategory) {
	//if(LocalTime.of(7, 0, 0).isBefore(LocalTime.now()) && LocalTime.now().isBefore(LocalTime.of(11, 0, 0))) {
//	    foodCategory.setFoodCategoryType("breakfast");
//	    foodCategory.setFoodCategoryType("lunch");
//	    foodCategory.setFoodCategoryType("dinner");
	    
	    if(foodCategory.getFoodCategoryType().equals("breakfast")) {
	    foodCategory.setStartTime(LocalTime.of(7, 0, 0));
		foodCategory.setEndTime(LocalTime.of(11, 0, 0));
	    }
	    
	    if(foodCategory.getFoodCategoryType().equals("lunch")) {
		    foodCategory.setStartTime(LocalTime.of(12, 0, 0));
			foodCategory.setEndTime(LocalTime.of(03, 0, 0));
		    }
		//System.out.println("Breakfast Time From"+foodCategory.getStartTime()+"to"+foodCategory.getEndTime());
		return foodCategoryRepository.save(foodCategory);
	    
		//return new ResponseEntity<String>("Breakfast Time From"+foodCategory.getStartTime()+"to"+foodCategory.getEndTime(),HttpStatus.OK);
	//}
	//return new ResponseEntity<String>("Breakfast Time From "+foodCategory.getStartTime()+" to "+foodCategory.getEndTime(),HttpStatus.OK);
	
//foodCategory.setStartTime(LocalTime.of(7, 0, 0));
//foodCategory.setEndTime(LocalTime.of(11, 0, 0));
		
}
//
//
}