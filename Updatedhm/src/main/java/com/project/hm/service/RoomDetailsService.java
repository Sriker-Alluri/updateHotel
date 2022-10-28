package com.project.hm.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.hm.customExceptions.BadRequestException;
import com.project.hm.customExceptions.ResourceNotFoundException;
import com.project.hm.entity.RoomDetails;
import com.project.hm.repository.RoomDetailsRepository;

@Service
public class RoomDetailsService {
	
	@Autowired
	private RoomDetailsRepository  roomDetailsRepository;
	

	public List<RoomDetails> findAll() {
		
		return roomDetailsRepository.findAll();
	}


	public void updateRoomDetails(@Valid RoomDetails roomDetails) throws BadRequestException{
		try {
			roomDetailsRepository.save(roomDetails);
        } catch (Exception e) {
            throw new BadRequestException("invalid request");
        }
	}


	public RoomDetails findById(Long id) throws ResourceNotFoundException {
        return roomDetailsRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("709","resource not found"));
    }


	public void deleteByRoomDetailsId(Long id) {
		
		roomDetailsRepository.deleteById(id);
	}
	}
		
	


