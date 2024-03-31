package com.dogproductinventory.app.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ManufacturerRepository extends CrudRepository<Manufacturer, Long> {
    /* List<Manufacturer> findByManufacturer(String name); */
}
