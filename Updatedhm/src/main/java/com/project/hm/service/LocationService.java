package com.project.hm.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import com.project.hm.customExceptions.BadRequestException;
import com.project.hm.customExceptions.ResourceNotFoundException;
import com.project.hm.entity.HotelNames;
import com.project.hm.entity.Locations;
import com.project.hm.repository.HotelNamesRepository;
import com.project.hm.repository.LocationRepository;

@Service
public class LocationService {

	
	@Autowired
	
	private LocationRepository locationRepository;
	@Autowired
	HotelNamesRepository hotelNamesRepository;
	
//	@Autowired
//	private HotelNames hotelNames;
	
	public void updateLocations(@Valid Locations locations)  throws BadRequestException{
		try {
			locationRepository.save(locations);
        } catch (Exception e) {
            throw new BadRequestException("invalid request");
        }
	}

	public List<Locations> findAll() {
		
		return locationRepository.findAll();
			}

	public  Locations findById(Long id) throws ResourceNotFoundException {
        return locationRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("709","resource not found"));
    }

	public void deleteLocationById(Long id) {
		locationRepository.deleteById(id);
		
	}
	
	


	public List<Locations> findBycityNameLike(String cityName) {
		return locationRepository.findBycityNameLike(cityName);
	}
}
