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

import com.dogproductinventory.app.domain.Manufacturer;
import com.dogproductinventory.app.domain.ManufacturerRepository;

@Controller
public class ManufacturerController {

    @Autowired
    private ManufacturerRepository manurepository;

    // listaa kaikki valmistajat
    @GetMapping("/manufacturerlist")
    public String manufacturerList(Model model) {
        model.addAttribute("manufacturers", manurepository.findAll());
        return "manufacturerlist";
    }

    // lomake uudelle valmistajalle
    @GetMapping("/addmanufacturer")
    public String addManufacturer(Model model) {
        model.addAttribute("manufacturer", new Manufacturer());
        return "manufacturerform";
    }

    @GetMapping("/editmanufacturer/{id}")
    public String editManufacturer(@PathVariable("id") Long manuId, Model model) {
        model.addAttribute("manufacturer", manurepository.findById(manuId));
        return "manufacturerform";
    }

    // tallentaa tiedot repositoryyn ja palaa sivulle joka näyttää listan
    @PostMapping("/savemanufacturer")
    public String saveManufacturer(@Valid @ModelAttribute("manufacturer") Manufacturer manu, BindingResult result) {
        if (result.hasErrors()) {
            return "manufacturerform";
        } else {
            manurepository.save(manu);
        return "redirect:/manufacturerlist";
        }
    }

    @GetMapping("/deletemanufacturer/{id}")
    public String deleteManufacturer(@PathVariable("id") Long manuId) {
        manurepository.deleteById(manuId);
        return "redirect:/manufacturerlist";
    }
	 

}
