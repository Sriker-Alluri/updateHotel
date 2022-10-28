package com.project.hm.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.hm.entity.Activities;
import com.project.hm.repository.ActivitiesRepository;
import com.project.hm.service.ActivityService;

@RestController
public class ActivityController {
	
	@Autowired
	
	ActivitiesRepository activitiesRepository;
	
	@Autowired
	ActivityService activitiesService;

	
	 @PostMapping("/saveActivities")
     public ResponseEntity<Activities> saveActivities( @RequestBody Activities activities)
     {
         System.out.println("Save HotelNames>>>>>>>>>>>>>>>>>>>>>>");
         
        return new ResponseEntity(activitiesRepository.save( activities), HttpStatus.CREATED);
}
   
   
   @DeleteMapping("/deleteByActivitiesId/{id}")
   public ResponseEntity<Map<String, Boolean>> deleteByActivitiesId(@PathVariable Long id) {
       activitiesService.deleteByActivitiesId(id);
       Map<String, Boolean> map = new HashMap<>();
       map.put("success", true);
       return new ResponseEntity<>(map, HttpStatus.OK);
   }
   
   
   



@GetMapping("/getAllActivities")
public ResponseEntity<List<Activities>> allActivities(){
       List<Activities> allActivities=activitiesService.findAll();
       return new ResponseEntity<List<Activities>>(allActivities, HttpStatus.ACCEPTED);
   
}







@PutMapping("/updateActivities/{id}")



public ResponseEntity<Map<String, Boolean>> updateActivities(@PathVariable Long id,
                                                       @Valid @RequestBody Activities activities) {
   activities.setId(id);
   activitiesService.updateHotelNames(activities);
   Map<String, Boolean> map = new HashMap<>();
   map.put("success", true);
   return new ResponseEntity<>(map, HttpStatus.CREATED);
}





@GetMapping("/getByActivitiesId/{id}")
public ResponseEntity<Activities> getByActivitiesId(@PathVariable Long id) {
   Activities activities = activitiesService.findById(id);
   return new ResponseEntity<>(activities, HttpStatus.OK);
}
   
}
