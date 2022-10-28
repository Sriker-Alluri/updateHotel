package com.project.hm.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class RoomsCategory {
	 @Id
	    private Long id;
	    private String roomType;
	    private Boolean AC;
}
