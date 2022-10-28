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
import com.project.hm.entity.Rooms;
import com.project.hm.repository.RoomsRepository;
import com.project.hm.service.RoomService;

@RestController
public class RoomsController {

	
	
	@Autowired
	private RoomsRepository roomsRepository;
	
	@Autowired
	private RoomService roomService;
	
	 @PostMapping("/saveRoom")
     public ResponseEntity<Rooms> saveRooms( @RequestBody Rooms rooms)
     {
   
         System.out.println("Save Rooms>>>>>>>>>>>>>>>>>>>>>>");
         
         
     return new ResponseEntity(roomsRepository.save( rooms), HttpStatus.CREATED);
}
	 @DeleteMapping("/deleteByRoomsId/{id}")
	 public ResponseEntity<Map<String, Boolean>> deleteByRoomsId(@PathVariable Long id) {
		 roomService.deleteByRoomsId(id);
	        Map<String, Boolean> map = new HashMap<>();
	        map.put("success", true);
	        return new ResponseEntity<>(map, HttpStatus.OK);
	    }
	      
	    

	@GetMapping("/getAllRooms")
	public ResponseEntity<List<Rooms>> allRooms(){
			List<Rooms> allRooms= roomService.findAll();
			return new ResponseEntity<List<Rooms>>(allRooms, HttpStatus.ACCEPTED);
		
	}


	 

	@PutMapping("/updateRooms/{id}")

	public ResponseEntity<Map<String, Boolean>> updateRooms(@PathVariable Long id,
	                                                        @Valid @RequestBody Rooms rooms) {
		rooms.setId(id);
		roomService.updateRooms(rooms);
	    Map<String, Boolean> map = new HashMap<>();
	    map.put("success", true);
	    return new ResponseEntity<>(map, HttpStatus.CREATED);
	}



	@GetMapping("/getByRoomsId/{id}")
	public ResponseEntity<Rooms> getByRoomsId(@PathVariable Long id) {
		Rooms rooms = roomService.findById(id);
	    return new ResponseEntity<>(rooms, HttpStatus.OK);
	}
}

