package com.project.hm.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.hm.customExceptions.BadRequestException;
import com.project.hm.customExceptions.ResourceNotFoundException;
import com.project.hm.entity.HotelCategory;

import com.project.hm.repository.HotelCategoryRepository;

@Service
public class HotelCategoryService {
	
	@Autowired
	private HotelCategoryRepository hotelCategoryRepository;

	public List<HotelCategory> findAll() {
		return hotelCategoryRepository.findAll();
	}

	
	public void updateHotelCategoryById(@Valid HotelCategory hotelCategory) throws BadRequestException{
		try {
			hotelCategoryRepository.save(hotelCategory);
        } catch (Exception e) {
            throw new BadRequestException("invalid request");
        }
	}


	public HotelCategory findById(Long id) throws ResourceNotFoundException {
        return hotelCategoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("709","resource not found"));
    }


	public void deleteHotelCategory(Long id) {
		hotelCategoryRepository.deleteById(id);
		
	}
	}


