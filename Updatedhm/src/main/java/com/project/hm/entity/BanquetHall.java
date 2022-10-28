package com.project.hm.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class BanquetHall {
	@Id
    private Integer id;
    private Integer capacity;
    private Double price;
}
