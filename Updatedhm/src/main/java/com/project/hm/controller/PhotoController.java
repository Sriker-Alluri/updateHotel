package com.project.hm.controller;

import java.io.IOException;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.project.hm.entity.Photos;
import com.project.hm.service.PhotoService;

@RestController
public class PhotoController {

	
	@Autowired
	 private PhotoService photoService;
	
	@PostMapping("/uploadImage")
	public ResponseEntity<?> uploadImage(@RequestParam ("image")MultipartFile file) throws IOException{
		String uploadImage = photoService.uploadImage(file);
		return ResponseEntity.status(HttpStatus.OK)
				.body(uploadImage);
				
	}
	
	
	@GetMapping("/getimage/{id}")
	public ResponseEntity<?> downloadImage(@RequestParam Long id){
		Optional<Photos> image=photoService.downloadimage(id);
		return ResponseEntity.status(HttpStatus.OK)
				
				.body(image);

	}



}
