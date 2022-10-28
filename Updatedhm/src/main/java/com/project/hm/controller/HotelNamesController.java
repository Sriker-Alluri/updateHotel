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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.hm.entity.HotelNames;
import com.project.hm.entity.Locations;
import com.project.hm.repository.HotelNamesRepository;
//import com.project.hm.response.AvailableRoomResponse;
import com.project.hm.service.HotelNamesService;
import com.project.hm.service.LocationService;

@RestController
@RequestMapping("/api/hotel")
public class HotelNamesController {

	
	@Autowired
    private HotelNamesRepository hotelRepository;

	@Autowired
	private HotelNamesService hotelNamesService;
	
//	@Autowired
//	 private LocationService locationservice;
//	
    
    
    @PostMapping("/saveHotel")
      public ResponseEntity<HotelNames> saveHotelNames( @RequestBody HotelNames hotelNames)
      {
          System.out.println("Save HotelNames>>>>>>>>>>>>>>>>>>>>>>");
          
         return new ResponseEntity(hotelRepository.save( hotelNames), HttpStatus.CREATED);
}
    
    
    @DeleteMapping("/deleteByHotelNameId/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteByHotelNameId(@PathVariable Long id) {
    	hotelNamesService.deleteByHotelNameId(id);
        Map<String, Boolean> map = new HashMap<>();
        map.put("success", true);
        return new ResponseEntity<>(map, HttpStatus.OK);
    }
    
    
    

@GetMapping("/getAllHotelNames")
public ResponseEntity<List<HotelNames>> allHotelNames(){
		List<HotelNames> allHotelNames= hotelNamesService.findAll();
		return new ResponseEntity<List<HotelNames>>(allHotelNames, HttpStatus.ACCEPTED);
	
}


 

@PutMapping("/updateHotelNames/{id}")

public ResponseEntity<Map<String, Boolean>> updateHotelNames(@PathVariable Long id,
                                                        @Valid @RequestBody HotelNames hotelNames) {
	hotelNames.setId(id);
	hotelNamesService.updateHotelNames(hotelNames);
    Map<String, Boolean> map = new HashMap<>();
    map.put("success", true);
    return new ResponseEntity<>(map, HttpStatus.CREATED);
}



@GetMapping("/getByHotelNamesId/{id}")
public ResponseEntity<HotelNames> getByHotelNamesId(@PathVariable Long id) {
	HotelNames hotelNames = hotelNamesService.findById(id);
    return new ResponseEntity<>(hotelNames, HttpStatus.OK);
}



@GetMapping("/getHotelNamesByLocation/{cityName}")
public ResponseEntity<List<HotelNames>> getHotelNamesByLocation(@PathVariable String cityName){
	//List<HotelNames> hotelnames=hotelNamesService.findBycityName(cityName);
//	return new ResponseEntity<HotelNames> (HttpStatus.CREATED);
	return hotelNamesService.findBycityName(cityName);
	//return new ResponseEntity<List<HotelNames>>(hotelnames,HttpStatus.OK);
}
}

