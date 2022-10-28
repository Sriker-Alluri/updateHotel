package com.project.hm.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.hm.entity.Guests;
import com.project.hm.repository.GuestRepository;

@Service
public class GuestService {
	@Autowired
	GuestRepository guestRepository;
	
	public Guests addGuest( Guests guests) {
		
		for(guests.getGuests();guests.getGuests()<=5;guests.getGuests()) {
		System.out.println("guests added "+guests);
		}
		return guestRepository.save(guests);
		
	}
	
public Guests removeGuest( Guests guests) {
		
		for(Guests guests: guest) {
		System.out.println("guests added "+guests);
		}
		return guestRepository.save(guests);
		
	}


}
