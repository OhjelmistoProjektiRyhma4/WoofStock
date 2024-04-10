package com.dogproductinventory.app.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import jakarta.validation.Valid;
import org.springframework.validation.BindingResult;

import com.dogproductinventory.app.domain.CustomerRepository;
import com.dogproductinventory.app.domain.Customer;

@Controller
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;

    // listaa kaikki asiakkaat
    @GetMapping("/customerlist")
    public String customerList(Model model) {
        model.addAttribute("customerlist", customerRepository.findAll());
        return "customerlist";
    }

    // lomake uudelle asiakkaalle
    @GetMapping("/addcustomer")
    public String addCustomer(Model model) {
        model.addAttribute("customer", new Customer());
        return "customerform";
    }

    @GetMapping("/editcustomer/{id}")
    public String editCustomer(@PathVariable("id") Long customerId, Model model) {
        model.addAttribute("customer", customerRepository.findById(customerId));
        return "customerform";
    }

    // tallentaa tiedot repositoryyn ja palaa sivulle joka näyttää listan
    @PostMapping("/savecustomer")
    public String saveCustomer(@Valid @ModelAttribute("customer") Customer customer, BindingResult result) {
        if (result.hasErrors()) {
            return "customerform";
        } else {
            customerRepository.save(customer);
        return "redirect:/customerlist";
        }
    }

    @GetMapping("/deletecustomer/{id}")
    public String deleteCustomer(@PathVariable("id") Long customerId) {
        customerRepository.deleteById(customerId);
        return "redirect:/customerlist";
    }
}
