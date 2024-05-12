package com.dogproductinventory.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import org.springframework.core.env.Environment;

import java.util.List;
import java.util.Arrays;
import com.dogproductinventory.app.domain.Customer;
import com.dogproductinventory.app.domain.CustomerRepository;
import com.dogproductinventory.app.domain.DogProduct;
import com.dogproductinventory.app.domain.DogProductRepository;
import com.dogproductinventory.app.domain.Manufacturer;
import com.dogproductinventory.app.domain.ManufacturerRepository;
import com.dogproductinventory.app.domain.ProductType;
import com.dogproductinventory.app.domain.ProductTypeRepository;

@SpringBootApplication
public class AppApplication {

	private static final Logger log = LoggerFactory.getLogger(AppApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(AppApplication.class, args);
	}
	@Autowired
    private Environment env;

    @Bean
    public CommandLineRunner testEnvironment() {
        return args -> {
            log.info("Testing Environment Variables...");
            String renderUsername = env.getProperty("RENDER_USERNAME");
            String renderPassword = env.getProperty("RENDER_PASSWORD");
			String renderExternalUrl = env.getProperty("RENDER_EXTERNAL_URL");
            log.info("RENDER_USERNAME: {}", renderUsername);
            log.info("RENDER_PASSWORD: {}", renderPassword);
			log.info("RENDER_EXTERNAL_URL: {}", renderExternalUrl);
            log.info("Environment Variables Testing Completed.");
        };
    }

	@Bean
	public CommandLineRunner DogStore(ManufacturerRepository manurepository, DogProductRepository productrepository,
			CustomerRepository customerRepo, ProductTypeRepository typeRepository) {
		return (args) -> {

			// lisätään muutama valmistaja
			Manufacturer m1 = new Manufacturer("testi1", "osoite1", "+44 20 1234 5678");
			manurepository.save(m1);
			Manufacturer m2 = new Manufacturer("testi2", "osoite2", "+49 30 12345678");
			manurepository.save(m2);
			
			//lisätään tuotteen tyypit
			ProductType t1 = new ProductType("Vaate");
			typeRepository.save(t1);
			ProductType t2 = new ProductType("Lelu");
			typeRepository.save(t2);
			
			

			// lisätään muutama tuote ja tuotteille myös valmistaja ja tyyppi
			DogProduct product1 = new DogProduct("takki", "punainen", 4, "L", 40, m1,t1);
			productrepository.save(product1);
			DogProduct product2 = new DogProduct("kaulapanta", "sininen", 8, "S", 50, m2,t1);
			productrepository.save(product2);
			DogProduct product3 = new DogProduct("takki", "vihreä", 9, "M", 10 ,m1,t1);
			productrepository.save(product3);

			log.info("all products");
			for (DogProduct product : productrepository.findAll()) {
				log.info(product.toString());
			}

			List<Customer> customers = Arrays.asList(
					new Customer("matti", "meikäläinen", "+49 30 12345678", "matti@gmail.com", "kotitie123", "02940"),
					new Customer("tarja", "koskinen", "+49 30 12345678", "tarja@gmail.com", "tarjankoti123", "00520"));
			customers.forEach(customerRepo::save);

			log.info("all customers");
			for (Customer customer : customerRepo.findAll()) {
				log.info(customer.toString());
			}
		};
	}
}


