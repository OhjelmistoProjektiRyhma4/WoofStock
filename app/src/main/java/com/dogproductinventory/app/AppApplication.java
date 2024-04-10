package com.dogproductinventory.app;

import java.util.List;
import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

			// lisätään muutama valmistaja
			Manufacturer m1 = new Manufacturer("testi1", "osoite1", "12544");
			manurepository.save(m1);
			Manufacturer m2 = new Manufacturer("testi2", "osoite2", "1254455675");
			manurepository.save(m2);

			// lisätään muutama tuote ja tuotteille myös valmistaja
			DogProduct product1 = new DogProduct("takki", "punainen", 4, m1);
			productrepository.save(product1);
			DogProduct product2 = new DogProduct("kaulapanta", "sininen", 8, m2);
			productrepository.save(product2);
			DogProduct product3 = new DogProduct("takki", "vihreä", 9, m1);
			productrepository.save(product3);

			log.info("all products");
			for (DogProduct product : productrepository.findAll()) {
				log.info(product.toString());
			}

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
