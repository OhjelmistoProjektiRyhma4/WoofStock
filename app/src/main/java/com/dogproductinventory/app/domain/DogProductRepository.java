package com.dogproductinventory.app.domain;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface DogProductRepository extends CrudRepository<DogProduct, Long> {

	// fetch dog products by name
    //List<DogProduct> findByType(String type);


	//find by manu id
	List<DogProduct> findByManufacturerId(Long manufacturerId);


	//find dog products by name
	List<DogProduct> findByName(String name);
    

}
