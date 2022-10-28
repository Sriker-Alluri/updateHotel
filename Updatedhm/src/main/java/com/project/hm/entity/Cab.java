package com.project.hm.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Cab {
	@Id
	   private Integer id;
	    private String source;
	    private String destination;
	    private Double price;
@OneToOne(cascade=CascadeType.ALL)
//@JoinTable(name="Locations",joinColumns=@JoinColumn(name="Locations_Id"))
private Locations locations;

}
