package com.project.hm.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class PhotoUploading {
@Id
private Integer id;
private byte[] photos;


@OneToOne
private Rooms rooms;
	
	
}
