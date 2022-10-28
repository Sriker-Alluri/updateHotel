package com.project.hm.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class HotelNames {

	@Id
	private Long id;
	private String hotelName;

	@OneToOne
	private HotelCategory hotelCategory;

	@OneToOne
	@JoinColumn(name = "location_id")
	private Locations location;
	
	@ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinTable(name = "displayActivites", joinColumns = { @JoinColumn(name = "hotelNames_Id") }, inverseJoinColumns = {
            @JoinColumn(name = "activity_id") })
private List<Activities> activity;


}
