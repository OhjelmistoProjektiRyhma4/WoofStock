package com.dogproductinventory.app.domain;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DogProductRepository extends CrudRepository<DogProduct, Long> {
    /* List<Manufacturer> findByManufacturer(String name); */
}
