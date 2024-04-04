package com.dogproductinventory.app;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.dogproductinventory.app.domain.Manufacturer;
import com.dogproductinventory.app.domain.ManufacturerRepository;

@DataJpaTest
public class ManufacturerRepositoryTest {

    @Autowired
    private ManufacturerRepository manufacturerRepository;

    @Test 
    public void createNewManufacturerTest() {
        Manufacturer manufacturer = new Manufacturer("Mustin Murkina", "Goottikatu 3", "066 066060");
    	manufacturerRepository.save(manufacturer);
    	assertThat(manufacturerRepository.findById(3L).get().getName()).isEqualTo("Mustin Murkina");

        //Uusi valmistaja saa ID:n 3, koska AppApplicationissa on luotu jo kaksi valmistajaa.
    }    

    @Test
    public void deleteManufacturerTest() {
        assertThat(manufacturerRepository.findById(3L)).isNotNull();

        manufacturerRepository.deleteById(2L);
        assertThat(manufacturerRepository.findById(3L)).isEmpty();
    }
}
