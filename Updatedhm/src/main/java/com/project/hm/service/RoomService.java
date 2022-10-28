package com.project.hm.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.hm.customExceptions.BadRequestException;
import com.project.hm.customExceptions.ResourceNotFoundException;
import com.project.hm.entity.Rooms;
import com.project.hm.repository.RoomsRepository;

@Service
public class RoomService {
	
	@Autowired
	private RoomsRepository roomsRepository;

	public List<Rooms> findAll() {
		
		return roomsRepository.findAll();
	}

	public void updateRooms(@Valid Rooms rooms) throws BadRequestException{
		try {
			roomsRepository.save(rooms);
        } catch (Exception e) {
            throw new BadRequestException("invalid request");
        }
		
	}

	public Rooms findById(Long id) throws ResourceNotFoundException {
        return roomsRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("709","resource not found"));
    }

	public void deleteByRoomsId(Long id) {
		
		roomsRepository.deleteById(id);
	}
		
	}


