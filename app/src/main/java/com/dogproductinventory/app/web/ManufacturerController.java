package com.dogproductinventory.app.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dogproductinventory.app.domain.Manufacturer;
import com.dogproductinventory.app.domain.ManufacturerRepository;
import org.springframework.web.bind.annotation.RequestParam;

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
    public String saveManufacturer(@ModelAttribute Manufacturer manu) {
        manurepository.save(manu);
        return "redirect:/manufacturerlist";
    }

    @GetMapping("/deletemanufacturer/{id}")
    public String deleteManufacturer(@PathVariable("id") Long manuId) {
        manurepository.deleteById(manuId);
        return "redirect:/manufacturerlist";
    }

    @RequestMapping(value = "/manufacturerrest", method = RequestMethod.GET)
    public @ResponseBody List<Manufacturer> manufacturersListRest() {
        return (List<Manufacturer>) manurepository.findAll();
    }

    @RequestMapping(value = "/manufacturerrest/{id}", method = RequestMethod.GET)
    public @ResponseBody Optional<Manufacturer> manufacturerListRest(@PathVariable("id") Long manuId) {
        return manurepository.findById(manuId);
    }

}
