package com.dogproductinventory.app.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.dogproductinventory.app.domain.Manufacturer;
import com.dogproductinventory.app.domain.ManufacturerRepository;

@RestController
public class ManufacturerRestController {

	@Autowired
	private ManufacturerRepository manurepository;

//	Get all manufacturers
	@RequestMapping(value = "/manufacturers", method = RequestMethod.GET)
	public @ResponseBody List<Manufacturer> manufacturersListRest() {
		return (List<Manufacturer>) manurepository.findAll();
	}

//	Find manufacturer by id
	@RequestMapping(value = "/manufacturers/{id}", method = RequestMethod.GET)
	public @ResponseBody Optional<Manufacturer> manufacturerListRest(@PathVariable("id") Long manuId) {
		return manurepository.findById(manuId);
	}
	
//  Add new manufacturer
	@PostMapping("/manufacturers")
	Manufacturer newManufacturer(@RequestBody Manufacturer newManufacturer) {
		return manurepository.save(newManufacturer);
	}

//  Edit manufacturer
	@PutMapping("/manufacturers/{id}")
	Manufacturer editManufacturer(@RequestBody Manufacturer editedManufacturer, @PathVariable Long id) {
		editedManufacturer.setId(id);
		return manurepository.save(editedManufacturer);
	}
//	Delete manufacturer
	@DeleteMapping("/manufacturers/{id}")
	void deleteManufacturer(@PathVariable Long id) {
	    manurepository.deleteById(id);
	  }

}
