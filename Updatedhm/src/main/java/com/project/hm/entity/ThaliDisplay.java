package com.project.hm.entity;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class ThaliDisplay {
@Id
private Integer id;

@OneToOne
private ThaliMenu thaliMenu;

@Enumerated(value=EnumType.STRING)
private Thali thali;
}
