package com.dogproductinventory.app;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.dogproductinventory.app.domain.Customer;
import com.dogproductinventory.app.domain.CustomerRepository;
import com.dogproductinventory.app.domain.DogProduct;
import com.dogproductinventory.app.domain.DogProductRepository;
import com.dogproductinventory.app.domain.Manufacturer;
import com.dogproductinventory.app.domain.ManufacturerRepository;

@SpringBootApplication
public class AppApplication {

	private static final Logger log = LoggerFactory.getLogger(AppApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(AppApplication.class, args);
	}

	@Bean
	public CommandLineRunner DogStore(ManufacturerRepository manurepository, DogProductRepository productrepository,
			CustomerRepository customerRepo) {
		return (args) -> {

			  List<Manufacturer> manufacturers = Arrays.asList( new Manufacturer("testi1",
			  "KATU123", "040123345"), new Manufacturer("testi2", "tie345", "123345656"));
			  manufacturers.forEach(manurepository::save);
			  
			  log.info("all manufactrurers"); for (Manufacturer manu :
			  manurepository.findAll()) { log.info(manu.toString()); }
			  
			  List<DogProduct> dogProducts = Arrays.asList( new DogProduct("sadetakki",
			  "punainen", 20, null), new DogProduct("kaulapanta", "sininen", 8, null), new
			  DogProduct("kengät", "musta", 10, null));
			  dogProducts.forEach(productrepository::save);
			  
			  log.info("all products"); for (DogProduct product :
			  productrepository.findAll()) { log.info(product.toString()); }
			 
		
			List<Customer> customers = Arrays.asList(
				new Customer("matti", "meikäläinen", "040123123", "matti@gmail.com", "kotitie123", "02940"),
				new Customer("tarja", "koskinen", "05012866", "tarja@gmail.com", "tarjankoti123", "00520"));
			customers.forEach(customerRepo::save);

			log.info("all customers");
			for (Customer customer : customerRepo.findAll()) {
				log.info(customer.toString());
			}
		};
	}
}
