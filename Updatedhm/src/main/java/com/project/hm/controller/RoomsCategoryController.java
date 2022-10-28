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

import com.project.hm.entity.HotelNames;
import com.project.hm.entity.Locations;
import com.project.hm.entity.RoomsCategory;
import com.project.hm.repository.RoomCategoryRepository;
import com.project.hm.service.RoomCategoryService;

@RestController
public class RoomsCategoryController {

	@Autowired
	private RoomCategoryRepository roomCategoryRepository;
	
	@Autowired
	
	private RoomCategoryService roomCategoryService;
	
	  
    @PostMapping("/addCategories")
      public ResponseEntity<RoomsCategory> saveRoomsCategory( @RequestBody RoomsCategory roomsCategory)
      {
  
    	
          System.out.println("Save Locations>>>>>>>>>>>>>>>>>>>>>>");
      return new ResponseEntity(roomCategoryRepository.save(roomsCategory ), HttpStatus.CREATED);
}
	
    
    @DeleteMapping("/deleteRoomCategoryById/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteRoomCategoryById(@PathVariable Long id) {
    	roomCategoryService.deleteRoomCategoryById(id);
        Map<String, Boolean> map = new HashMap<>();
        map.put("success", true);
        return new ResponseEntity<>(map, HttpStatus.OK);
    }
    

    @GetMapping("/getAllRoomsCategory")
    public ResponseEntity<List<RoomsCategory>> allRoomsCategory(){
    		List<RoomsCategory> allRoomsCategory= roomCategoryService.findAll();
    		return new ResponseEntity<List<RoomsCategory>>(allRoomsCategory, HttpStatus.ACCEPTED);
    	
    }


     

    @PutMapping("/updateRoomsCategory/{id}")

    public ResponseEntity<Map<String, Boolean>> updateRoomsCategory(@PathVariable Long id,
                                                            @Valid @RequestBody RoomsCategory roomsCategory) {
    	roomsCategory.setId(id);
    	roomCategoryService.updateRoomsCategory(roomsCategory);
        Map<String, Boolean> map = new HashMap<>();
        map.put("success", true);
        return new ResponseEntity<>(map, HttpStatus.CREATED);
    }



    @GetMapping("/getByRoomsCategoryId/{id}")
    public ResponseEntity<RoomsCategory> getRoomsCategoryById(@PathVariable Long id) {
    	RoomsCategory roomsCategory = roomCategoryService.findById(id);
        return new ResponseEntity<>(roomsCategory, HttpStatus.OK);
    }
}
