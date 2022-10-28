package com.project.hm.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import lombok.Data;

@Entity
@Data
public class Guests {

	@Id
	private Long id;
	@Min(value=1)
	@Max(value=5,message="cant select more than 5 guests")
	private Integer Guests;
	private Integer children; 
	
}
