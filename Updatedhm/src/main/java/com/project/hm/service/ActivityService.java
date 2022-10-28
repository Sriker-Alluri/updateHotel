package com.project.hm.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.hm.customExceptions.BadRequestException;
import com.project.hm.customExceptions.ResourceNotFoundException;
import com.project.hm.entity.Activities;
import com.project.hm.repository.ActivitiesRepository;

@Service
public class ActivityService {

	@Autowired
    private ActivitiesRepository activitiesRepository;



   public List<Activities> findAll() {
        
        return activitiesRepository.findAll() ;
    }



   public void updateHotelNames(@Valid Activities activities) throws BadRequestException{
        try {
            activitiesRepository.save(activities);
        } catch (Exception e) {
            throw new BadRequestException("invalid request");
        }
    }



   public Activities findById(Long id)throws ResourceNotFoundException {
        return activitiesRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("709","resource not found"));
    }
    



   public void deleteByActivitiesId(Long id) {
        activitiesRepository.deleteById(id);
    }
}
