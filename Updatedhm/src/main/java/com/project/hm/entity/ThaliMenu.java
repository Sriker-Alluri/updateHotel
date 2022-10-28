package com.project.hm.entity;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class ThaliMenu {
@Id
private Integer id;
private String items;
private Double price;

@Enumerated(value=EnumType.STRING)
private Thali thali;
}
