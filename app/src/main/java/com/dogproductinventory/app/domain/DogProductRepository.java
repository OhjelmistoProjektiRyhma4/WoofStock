package com.dogproductinventory.app.domain;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface DogProductRepository extends CrudRepository<DogProduct, Long> {

	// fetch dog products by name
    List<DogProduct> findByName(String name);
    
    // fetch dog products by color
    List<DogProduct> findByColor(String color);

}
