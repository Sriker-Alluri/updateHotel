package com.project.hm.service;

import java.io.IOException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.project.hm.entity.Photos;
import com.project.hm.repository.PhotosRepository;

@Service
public class PhotoService {

	
	@Autowired
	private PhotosRepository photosRepository;
	
	public String uploadImage(MultipartFile file) throws IOException {

		Photos photos=photosRepository.save(Photos.builder()
				.image(file.getBytes()).build());
		
		if(photos !=null) {
			
		
		return "uploaded successfully";
		}
		return null;
	}
	
	public Optional<Photos> downloadimage(Long id ) {
Optional<Photos> photos=photosRepository.findById(id);

return photos;
}
}


