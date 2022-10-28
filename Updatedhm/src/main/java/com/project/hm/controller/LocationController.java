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
import com.project.hm.repository.LocationRepository;
import com.project.hm.service.LocationService;

@RestController
public class LocationController {
	  @Autowired
	    private LocationRepository locationRepository;
	    
	  
	  @Autowired	  
	  private LocationService locationService;
	  
//     @Autowired
//	 private  HotelNames hotelNames;
//     
//	  @Autowired
//	  Locations locations;
	    
	    @PostMapping("locations")
	      public ResponseEntity<Locations> saveLocations( @RequestBody Locations locations)
	      {
//	    	Long id=locations.getId();
//	    	String s1=locations.getCityName();
	    	
	          System.out.println("Save Locations>>>>>>>>>>>>>>>>>>>>>>");
	      return new ResponseEntity(locationRepository.save( locations), HttpStatus.CREATED);
	}
	    
	    @DeleteMapping("/deleteLocationById/{id}")
	    
	 
	    public ResponseEntity<Map<String, Boolean>> deleteLocationById(@PathVariable Long id) {
	    	locationService.deleteLocationById(id);
	        Map<String, Boolean> map = new HashMap<>();
	        map.put("success", true);
	        return new ResponseEntity<>(map, HttpStatus.OK);
	    }
	    
	    @PutMapping("/updateLocation/{id}")
	    public ResponseEntity<Map<String, Boolean>>  updateLocations(@PathVariable Long id,  @Valid @RequestBody Locations locations) 
	    {
	    	locations.setId(id);
	    	locationService.updateLocations(locations);
           Map<String, Boolean> map = new HashMap<>();
   map.put("success", true);
         return new ResponseEntity<>(map, HttpStatus.CREATED);
}
	    
	    
	    @GetMapping("/getAllLocations")
	    public ResponseEntity<List<Locations>> allHotelNames(){
	    		List<Locations> allLocations= locationService.findAll();
	    		return new ResponseEntity<List<Locations>>(allLocations, HttpStatus.ACCEPTED);
	    	
	    }

	    @GetMapping("/getByLocationsId/{id}")
	    public ResponseEntity<Locations> getByLocationsId(@PathVariable Long id) {
	    	Locations locations = locationService.findById(id);
	        return new ResponseEntity<>(locations, HttpStatus.OK);
	    }
	    
	    @GetMapping("/getByCityNameLetters/{cityName}")
        public List<Locations> finByCityNameLetters(@PathVariable String cityName) {
	    	
	    	//if(locations.getCityName()==hotelNames.getLocation().getCityName()) {
            List<Locations> locations = locationService.findBycityNameLike(cityName);
            return locations;
    	    
        //}
	    	
	
}
}