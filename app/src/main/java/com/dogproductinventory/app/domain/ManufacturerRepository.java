package com.dogproductinventory.app.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ManufacturerRepository extends CrudRepository<Manufacturer, Long> {
	
	// fetch manufacturers by name
    List<Manufacturer> findByName(String name);

}
