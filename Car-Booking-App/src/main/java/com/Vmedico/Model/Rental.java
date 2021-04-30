package com.Vmedico.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Rental {
	@Id
	@GeneratedValue
	private int id;
	private String username;
	private String pickupdate;
	private String pickuptime;
	private String returndate;
	private String returntime;
	private String pickuplocation;
	private String returnlocation;
	private int amount;
	private int discount;
	private String model;
	private int carid;
	private boolean active;
	public Rental() {
		
	}

	public int getId() {
		return id;
	}
	

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPickupdate() {
		return pickupdate;
	}

	public void setPickupdate(String pickupdate) {
		this.pickupdate = pickupdate;
	}

	public String getPickuptime() {
		return pickuptime;
	}

	public void setPickuptime(String pickuptime) {
		this.pickuptime = pickuptime;
	}

	public String getReturndate() {
		return returndate;
	}

	public void setReturndate(String returndate) {
		this.returndate = returndate;
	}

	public String getReturntime() {
		return returntime;
	}

	public void setReturntime(String returntime) {
		this.returntime = returntime;
	}

	public String getPickuplocation() {
		return pickuplocation;
	}

	public void setPickuplocation(String pickuplocation) {
		this.pickuplocation = pickuplocation;
	}

	public String getReturnlocation() {
		return returnlocation;
	}

	public void setReturnlocation(String returnlocation) {
		this.returnlocation = returnlocation;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

	public int getCarid() {
		return carid;
	}

	public void setCarid(int carid) {
		this.carid = carid;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	@Override
	public String toString() {
		return "Rental [id=" + id + ", username=" + username + ", pickupdate=" + pickupdate + ", pickuptime="
				+ pickuptime + ", returndate=" + returndate + ", returntime=" + returntime + ", pickuplocation="
				+ pickuplocation + ", returnlocation=" + returnlocation + ", amount=" + amount + ", discount="
				+ discount + ", model=" + model + ", carid=" + carid + ", active=" + active + "]";
	}

	public Rental(String username, String pickupdate, String pickuptime, String returndate, String returntime,
			String pickuplocation, String returnlocation, int amount, int discount, String model, int carid,
			boolean active) {
		super();
		this.username = username;
		this.pickupdate = pickupdate;
		this.pickuptime = pickuptime;
		this.returndate = returndate;
		this.returntime = returntime;
		this.pickuplocation = pickuplocation;
		this.returnlocation = returnlocation;
		this.amount = amount;
		this.discount = discount;
		this.model = model;
		this.carid = carid;
		this.active = active;
	}

	
	

	
}
