package com.dogproductinventory.app;

import java.util.List;
import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.dogproductinventory.app.domain.DogProduct;
import com.dogproductinventory.app.domain.DogProductRepository;
import com.dogproductinventory.app.domain.Manufacturer;
import com.dogproductinventory.app.domain.ManufacturerRepository;

@SpringBootApplication
public class AppApplication {//GITTI TOIMII????

	private static final Logger log = LoggerFactory.getLogger(AppApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(AppApplication.class, args);
	}


	//  tuotelista --> http://localhost:8080/productlist
	//  valmistajalista --> http://localhost:8080/manufacturerlist


	// tallentaa pari testiä sovelluksen käynnistyessä ja tulostaa ne myös konsoliin
	@Bean
	public CommandLineRunner DogStore(ManufacturerRepository manurepository, DogProductRepository productrepository) {
		return (args) -> {


			//Manufacturer
			List<Manufacturer> manufacturers = Arrays.asList(
    			new Manufacturer("testi1", "KATU123", "040123345"),
    			new Manufacturer("testi2", "tie345", "123345656")
			);
			manufacturers.forEach(manurepository::save);


			log.info("all manufactrurers");
			for (Manufacturer manu : manurepository.findAll()) {
				log.info(manu.toString());
			}

			
			// DogProduct
			DogProduct a = new DogProduct("sadetakki", "punainen", 20, null);
			DogProduct b = new DogProduct("kaulapanta", "sininen", 8, null);
			DogProduct c = new DogProduct("kengät", "musta", 10, null);
			productrepository.save(a);
			productrepository.save(b);
			productrepository.save(c);


		};
	}
}
