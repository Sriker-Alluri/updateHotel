package com.project.hm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.project.hm.entity.HotelNames;
import com.project.hm.entity.Locations;


@Repository
public interface HotelNamesRepository extends JpaRepository<HotelNames, Long> {

	
//	@Query			
//	("SELECT h FROM HotelNames h  WHERE h.location.getcityName LIKE CONTAIN('%',:name, '%')")
//	List<HotelNames> findByHotelName(String hotelName);

//	@Query			
//	("SELECT l FROM Locations l  WHERE l.cityName LIKE CONCAT('%',:name, '%')")
//	List<HotelNames> findByHotelName(String hotelName);
	
    List<HotelNames> findByLocation(Locations locations);

	
}
