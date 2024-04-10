package com.dogproductinventory.app.domain;

import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface DogProductRepository extends CrudRepository<DogProduct, Long> {

    List<DogProduct> findByName(String name);

}
