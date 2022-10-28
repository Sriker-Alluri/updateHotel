package com.project.hm.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.hm.customExceptions.BadRequestException;
import com.project.hm.customExceptions.ResourceNotFoundException;
import com.project.hm.entity.RoomsCategory;
import com.project.hm.repository.RoomCategoryRepository;

@Service
public class RoomCategoryService {
	
	@Autowired
	private RoomCategoryRepository roomCategoryRepository;

	public List<RoomsCategory> findAll() {
		
		return roomCategoryRepository.findAll();
	}

	public void updateRoomsCategory(@Valid RoomsCategory roomsCategory)throws BadRequestException{
		try {
			roomCategoryRepository.save(roomsCategory);
        } catch (Exception e) {
            throw new BadRequestException("invalid request");
        }
		
	}

	public RoomsCategory findById(Long id) throws ResourceNotFoundException {
        return roomCategoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("709","resource not found"));
    }

	public void deleteRoomCategoryById(Long id) {
		
		roomCategoryRepository.deleteById(id);
	}
		
	}


