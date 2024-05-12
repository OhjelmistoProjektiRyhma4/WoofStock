package com.dogproductinventory.app.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.integration.IntegrationProperties.Error;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dogproductinventory.app.domain.Customer;
import com.dogproductinventory.app.domain.CustomerRepository;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerRestController {

    @Autowired
    CustomerRepository crepo;

    @RequestMapping("/customers")
    public Iterable<Customer> getCustomers() {
        return crepo.findAll();
    }

    @PostMapping("/customers")
    public ResponseEntity<?> newCustomer(@RequestBody Customer customer) {
        for (Customer cus : crepo.findAll()) {
            if (cus.getEmail().equals(customer.getEmail())) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Sähköposti käytössä");
            }
        }
        Customer newCustomer = crepo.save(customer);
        return ResponseEntity.ok(newCustomer);
    }

}
