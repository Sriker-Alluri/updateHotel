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
import com.project.hm.entity.RoomDetails;
import com.project.hm.repository.RoomDetailsRepository;
import com.project.hm.service.RoomDetailsService;

@RestController
public class RoomDetailsController {
	
	@Autowired
	private RoomDetailsRepository  roomDetailsRepository;
	
	@Autowired
	private RoomDetailsService roomDetailsService;
	
	
	@PostMapping("/AddRoomDetails")
    public ResponseEntity<RoomDetails> addRooms( @RequestBody RoomDetails roomsDetails)
    {
        System.out.println("Save Locations>>>>>>>>>>>>>>>>>>>>>>");
    return new ResponseEntity(roomDetailsRepository.save(roomsDetails ),HttpStatus.CREATED);
}
	
	 
    @DeleteMapping("/deleteByRoomDetailsId/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteByRoomDetailsId(@PathVariable Long id) {
    	roomDetailsService.deleteByRoomDetailsId(id);
        Map<String, Boolean> map = new HashMap<>();
        map.put("success", true);
        return new ResponseEntity<>(map, HttpStatus.OK);
    }    
    

@GetMapping("/getAllRoomDetails")
public ResponseEntity<List<RoomDetails>> allRoomDetails(){
		List<RoomDetails> allRoomDetails= roomDetailsService.findAll();
		return new ResponseEntity<List<RoomDetails>>(allRoomDetails, HttpStatus.ACCEPTED);
	
}


 

@PutMapping("/updateRoomDetails/{id}")

public ResponseEntity<Map<String, Boolean>> updateRoomDetails(@PathVariable Long id,
                                                        @Valid @RequestBody RoomDetails roomDetails) {
	roomDetails.setId(id);
	roomDetailsService.updateRoomDetails(roomDetails);
    Map<String, Boolean> map = new HashMap<>();
    map.put("success", true);
    return new ResponseEntity<>(map, HttpStatus.CREATED);
}



@GetMapping("/getByRoomDetailsId/{id}")
public ResponseEntity<RoomDetails> getByRoomDetailsId(@PathVariable Long id) {
	RoomDetails roomDetails = roomDetailsService.findById(id);
    return new ResponseEntity<>(roomDetails, HttpStatus.OK);
}
}
