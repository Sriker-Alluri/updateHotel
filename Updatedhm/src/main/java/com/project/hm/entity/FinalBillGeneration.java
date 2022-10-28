package com.project.hm.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class FinalBillGeneration {
@Id
private Integer id;
private Double totalPrice;
private Double gst;
private Double finalBill;

@OneToOne
private RoomDetails roomDetails;

@OneToOne
private Laundry laundry;

@OneToOne
private Cab cab;

@OneToOne
private FoodOrder foodOrder;

@OneToOne
private DisplayActivities displayActivities;

}
