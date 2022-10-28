package com.project.hm.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.hm.entity.Photos;
@Repository
public interface PhotosRepository  extends JpaRepository<Photos, Long>{

	
	
}
