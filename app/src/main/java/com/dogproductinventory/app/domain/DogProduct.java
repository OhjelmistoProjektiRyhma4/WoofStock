package com.dogproductinventory.app.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Positive;

@Entity
@Table(name = "dog_product")
public class DogProduct {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long productId;

	@NotBlank(message = "Can't contain only blank spaces!")
	@Size(max = 40, message = "Max 40 characters!")
	private String name; 
	
	@NotBlank(message = "Can't contain only blank spaces!")
	@Size(max = 40 , message = "Max 40 characters!")
	private String color;
	
	@Size(min = 1, max = 2, message = "Needs to be presented with min 1 and max 2 letters!")
	private String size;

	@Positive(message = "Price can't be negative or zero!")
	private int price;

	@PositiveOrZero(message = "Stock can't go under zero!")
	private int stock;
	
	// Default constructor
	public DogProduct() {
	}

	// Valmistajan lisääminen DogProduct- tauluun
	// Many-to-One tarkoittaa tässä, että tuotteella voi olla yksi valmistaja
	// Manufacturer taulun pääavain on foreign key tässä DogProduct taulussa
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "manufacturer")
	private Manufacturer manufacturer;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "type")
	private ProductType type;

	public DogProduct(String name, String color,  int price, String size, int stock, Manufacturer manufacturer,
			ProductType type) {
		super();
		this.name = name;
		this.color = color;
		this.size = size;
		this.price = price;
		this.stock = stock;
		this.manufacturer = manufacturer;
		this.type = type;
	}

	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public Manufacturer getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(Manufacturer manufacturer) {
		this.manufacturer = manufacturer;
	}

	public ProductType getType() {
		return type;
	}

	public void setType(ProductType type) {
		this.type = type;
	}
	
	
	
	




	
	
	
	
	
	


	
	


	
	
	
	


	
	




	
}
