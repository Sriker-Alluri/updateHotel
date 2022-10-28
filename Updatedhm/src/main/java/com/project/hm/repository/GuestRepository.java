package com.project.hm.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.hm.entity.Guests;

public interface GuestRepository extends JpaRepository<Guests, Long>{
	
	
	

}
