package com.dogproductinventory.app.web;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.dogproductinventory.app.domain.DogProduct;
import com.dogproductinventory.app.domain.DogProductRepository;

@RestController
public class ProductRestController {
	
	@Autowired
	private DogProductRepository repository;
	
//	Get all dogproducts
    @RequestMapping("/dogproducts")
    public Iterable<DogProduct> getDogProducts() {
        return repository.findAll();
    }
//  Find dogproduct by id
	@RequestMapping(value="/dogproducts/{id}", method=RequestMethod.GET)
	public @ResponseBody Optional<DogProduct> getDogProductById(@PathVariable("id") Long id) {
		return repository.findById(id);
	}
    
//  Add new dogproduct
	@PostMapping("/dogproducts")
	DogProduct newDogProduct(@RequestBody DogProduct newDogProduct) {
		return repository.save(newDogProduct);
	}

//  Edit dogproduct
	@PutMapping("/dogproducts/{id}")
	DogProduct editDogProduct(@RequestBody DogProduct editedDogProduct, @PathVariable Long id) {
		editedDogProduct.setProductId(id);
		return repository.save(editedDogProduct);
	}
}
