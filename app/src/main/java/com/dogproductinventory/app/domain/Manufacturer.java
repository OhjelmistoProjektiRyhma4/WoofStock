package com.dogproductinventory.app.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Manufacturer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String name, address, phone;

	public Manufacturer(String name, String address, String phone) {
		super();
		this.name = name;
		this.address = address;
		this.phone = phone;
	}

	public Manufacturer() {
	}

	// One-to-Many tarkoittaa tässä, että valmistajalla voi olla useita tuotteita
	// mappedBy manufacturer viittaa DogProduct taulun viiteavaimeen
	
	/*
	 * @OneToMany(cascade = CascadeType.ALL, mappedBy = "manufacturer") private
	 * List<DogProduct> dogProducts;
	 */
	 
	@JsonIgnore
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "manufacturer")
//	@OneToMany(cascade = CascadeType.ALL, mappedBy = "manufacturer")
	private List<DogProduct> dogProducts;

	public List<DogProduct> getDogProducts() {
		return dogProducts;
	}

	public void setDogProducts(List<DogProduct> dogProducts) {
		this.dogProducts = dogProducts;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	@Override
	public String toString() {
		return "Manufacturer [id=" + id + ", name=" + name + ", address=" + address + ", phone="
				+ phone + ", dogProducts=" + dogProducts + "]";
	}

}
