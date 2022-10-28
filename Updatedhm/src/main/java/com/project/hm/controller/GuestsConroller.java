package com.project.hm.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.hm.entity.Guests;
import com.project.hm.service.GuestService;

@RestController
public class GuestsConroller {
	
	@Autowired
	 private GuestService guestService;
	
	@PostMapping("/addGuests")
	public ResponseEntity<Guests> addGuests(@Valid @RequestBody Guests guests) {
		return  new ResponseEntity(guestService.addGuest(guests),HttpStatus.OK);
		
	}
}
