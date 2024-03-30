package com.dogproductinventory.app.domain;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Manufacturer {
    
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long manufacturerId;
	private String name, address, phone;
	
	
	public Manufacturer(String name, String address, String phone) {
		super();
		this.name = name;
		this.address = address;
		this.phone = phone;
	}
	
	//One-to-Many tarkoittaa tässä, että valmistajalla voi olla useita tuotteita
	//mappedBy manufacturer viittaa DogProduct taulun viiteavaimeen
	@OneToMany(cascade=CascadeType.ALL, mappedBy="manufacturer")
	private List<DogProduct> dogProducts;
	
	public List<DogProduct> getDogProducts()  {
		return dogProducts;
	}
	
	public void setDogProducts(List<DogProduct> dogProducts)  {
		this.dogProducts = dogProducts;
	}
	
	
	public long getManufacturerId() {
		return manufacturerId;
	}
	public void setManufacturerId(long manufacturerId) {
		this.manufacturerId = manufacturerId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	
	
	
	
}
