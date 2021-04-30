package com.Vmedico.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Cars {
	@Id
	@Column(name = "id", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int uniqueId;
	private String Model; 
	private String Type;
	private String color;
	private String number;
	private String Brand;
	private boolean availability;
	private String FuelType;
	private String PurchaseDate;
	private int price;
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public Cars() {
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUniqueId() {
		return uniqueId;
	}
	public void setUniqueId(int uniqueId) {
		this.uniqueId = uniqueId;
	}
	public String getModel() {
		return Model;
	}
	public void setModel(String model) {
		this.Model = model;
	}
	public String getType() {
		return Type;
	}
	public void setType(String type) {
		this.Type = type;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getBrand() {
		return Brand;
	}
	public void setBrand(String brand) {
		this.Brand = brand;
	}
	public boolean isAvailability() {
		return availability;
	}
	public void setAvailability(boolean availability) {
		this.availability = availability;
	}
	public String getFuelType() {
		return FuelType;
	}
	public void setFuelType(String fuelType) {
		this.FuelType = fuelType;
	}
	public String getPurchaseDate() {
		return PurchaseDate;
	}
	public void setPurchaseDate(String purchaseDate) {
		this.PurchaseDate = purchaseDate;
	}
	@Override
	public String toString() {
		return "Cars [id=" + id + ", uniqueId=" + uniqueId + ", Model=" + Model + ", Type=" + Type + ", color=" + color
				+ ", number=" + number + ", Brand=" + Brand + ", availability=" + availability + ", FuelType="
				+ FuelType + ", PurchaseDate=" + PurchaseDate + ", price=" + price + "]";
	}
	public Cars(int uniqueId, String model, String type, String color, String number, String brand,
			boolean availability, String fuelType, String purchaseDate, int price) {
		super();
		this.uniqueId = uniqueId;
		Model = model;
		Type = type;
		this.color = color;
		this.number = number;
		Brand = brand;
		this.availability = availability;
		FuelType = fuelType;
		PurchaseDate = purchaseDate;
		this.price = price;
	}
	
	
}
