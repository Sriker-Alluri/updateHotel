package com.project.hm.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.hm.entity.FoodCategory;
import com.project.hm.entity.Rooms;
import com.project.hm.repository.FoodCategoryRepository;
import com.project.hm.service.FoodCategoryService;

@RestController
public class FoodCategoryController {
	@Autowired
	FoodCategoryService foodCategoryService;
	
	
@PostMapping("/FoodCategory")
  public ResponseEntity<FoodCategory> saveFoodCategory( @RequestBody FoodCategory foodCategory)
  {
      System.out.println("Save FoodCategory>>>>>>>>>>>>>>>>>>>>>>");
      
     return new ResponseEntity<FoodCategory>(foodCategoryService.displayFoodCategory( foodCategory), HttpStatus.OK);
}

	//@PostMapping("/FoodCategory")
//	public void 
           
}

