package com.project.hm.service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.project.hm.customExceptions.BadRequestException;
import com.project.hm.customExceptions.ResourceNotFoundException;
import com.project.hm.entity.HotelNames;
import com.project.hm.entity.Locations;
import com.project.hm.entity.Rooms;
import com.project.hm.repository.HotelNamesRepository;
import com.project.hm.repository.LocationRepository;

@Service
public class HotelNamesService {
	
	@Autowired
	private HotelNamesRepository hotelRepository;
	
//	@Autowired
//	 private Locations locations;
//	
	
	public List<HotelNames> findAll() {
		return hotelRepository.findAll();
	}

	public void updateHotelNames(@Valid HotelNames hotelNames)  throws BadRequestException{
		try {
			hotelRepository.save(hotelNames);
        } catch (Exception e) {
            throw new BadRequestException("invalid request");
        }
	}

    public HotelNames findById(Long id) throws ResourceNotFoundException {
        return hotelRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("709","resource not found"));
    }

	public void deleteByHotelNameId(Long id) {
		hotelRepository.deleteById(id);
		
	}

//	public List<HotelNames> findByLocation(Locations locations,String name) {
//		locations.getCityName();
//		
//		
//		return hotelRepository.findByHotelName(name);
//	}
	@Autowired
	LocationRepository locationRepository;
	
	@Autowired
	HotelNamesRepository hotelNamesRepository;
	
	public ResponseEntity<List<HotelNames>> findBycityName(String cityName) {
        return new ResponseEntity<List<HotelNames>>(hotelNamesRepository.findByLocation(locationRepository.findBycityName(cityName).get(0)),HttpStatus.OK);
         
        
    }
		 
		
	}

