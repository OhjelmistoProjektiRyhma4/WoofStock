package com.dogproductinventory.app.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "manufacturer")
public class Manufacturer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="manufacturer_id")
	private long id;

	@NotBlank(message = "Can't be only blank spaces!")
	@Size(max = 30, message = "Max 30 characters!")
	private String name;
	
	@NotBlank(message = "Can't be only blank spaces!")
	@Size(max = 40, message = "Max 40 characters!")
	private String address;

	@PhoneNumber
	private String phone;

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
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "manufacturer")
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
