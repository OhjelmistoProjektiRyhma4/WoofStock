package com.dogproductinventory.app.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dogproductinventory.app.domain.Manufacturer;
import com.dogproductinventory.app.domain.ManufacturerRepository;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ManufacturerController {
    // Kontrolleri valmistajalle!

    @Autowired
    private ManufacturerRepository manurepository;

    // listaa kaikki valmistajat
    @RequestMapping(value = { ("/manufacturerlist") }, method = RequestMethod.GET)
    public String manufacturerList(Model model) {
        model.addAttribute("manufacturers", manurepository.findAll());
        return "manufacturerlist";
    }

    // lomake uudelle valmistajalle
    @RequestMapping("/addmanufacturer")
    public String addManufacturer(Model model) {
        model.addAttribute("manufacturer", new Manufacturer());
        return "addmanufacturer";
    }

    // tallentaa tiedot repositoryyn ja palaa sivulle joka näyttää listan
    @RequestMapping(value = { ("/save") }, method = RequestMethod.POST)
    public String saveManufacturer(@ModelAttribute Manufacturer manu) {
        manurepository.save(manu);
        return "redirect:/manufacturerlist";
    }

}
