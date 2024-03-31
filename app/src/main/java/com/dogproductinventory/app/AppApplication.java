package com.dogproductinventory.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.dogproductinventory.app.domain.Manufacturer;
import com.dogproductinventory.app.domain.ManufacturerRepository;

@SpringBootApplication
public class AppApplication {

	private static final Logger log = LoggerFactory.getLogger(AppApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(AppApplication.class, args);
	}

	// tallentaa pari testiä sovelluksen käynnistyessä ja tulostaa ne myös konsoliin
	@Bean
	public CommandLineRunner DogStore(ManufacturerRepository manurepository) {
		return (args) -> {
			Manufacturer manu1 = new Manufacturer("testi1", "KATU123", "040123345");
			Manufacturer manu2 = new Manufacturer("testi2", "tie345", "123345656");

			manurepository.save(manu1);
			manurepository.save(manu2);

			log.info("all manufactrurers");
			for (Manufacturer manu : manurepository.findAll()) {
				log.info(manu.toString());
			}

		};
	}
}
