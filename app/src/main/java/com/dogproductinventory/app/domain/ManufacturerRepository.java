package com.dogproductinventory.app.domain;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ManufacturerRepository extends CrudRepository<Manufacturer, Long> {
}
