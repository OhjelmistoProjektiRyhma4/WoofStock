package com.dogproductinventory.app.web;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import jakarta.validation.Valid;
import org.springframework.validation.BindingResult;

import com.dogproductinventory.app.domain.DogProductRepository;
import com.dogproductinventory.app.domain.ManufacturerRepository;
import com.dogproductinventory.app.domain.ProductTypeRepository;
import com.dogproductinventory.app.domain.DogProduct;

@Controller
public class ProductController {

    @Autowired
    private DogProductRepository productrepository;

    @Autowired
    private ManufacturerRepository manurepository;

    @Autowired
    private ProductTypeRepository typeRepository;
    

    @GetMapping("/") //TODO: Loogisin sijainti metodille?
    public String etuSivu() {
        return "index";
    }

    // listaa kaikki tuotteet
    @GetMapping("/productlist")
    public String productList(Model model) {
        model.addAttribute("productlist", productrepository.findAll());

        return "productlist";
    }

    // lomake uudelle tuotteelle
    @GetMapping("/addproduct")
    public String addProduct(Model model) {
        model.addAttribute("product", new DogProduct());
        model.addAttribute("manufacturer", manurepository.findAll());
        model.addAttribute("type", typeRepository.findAll());
        return "productform";
    }

    // tuotteen muokkaus
    @GetMapping("/editproduct/{id}")
    public String editProduct(@PathVariable("id") Long productId, Model model) {
        model.addAttribute("product", productrepository.findById(productId));
        model.addAttribute("manufacturer", manurepository.findAll());
        model.addAttribute("type", typeRepository.findAll());
        return "productform";
    }

    // tallentaa tiedot repositoryyn ja palaa sivulle joka näyttää listan
    @PostMapping("/saveproduct")
    public String saveProduct(@Valid @ModelAttribute("product") DogProduct produ, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("manufacturer", manurepository.findAll());
            return "productform";
        } else {
            productrepository.save(produ);
            return "redirect:/productlist";
        }
    }

    // tuotteen poisto
    @GetMapping("/deleteproduct/{id}")
    public String deleteProduct(@PathVariable("id") Long produId) {
        productrepository.deleteById(produId);
        return "redirect:/productlist";
    }

    @GetMapping("/clothes/{name}")
    public String clothesBy(@PathVariable("name") String name, Model model) {

        List<DogProduct> vaatteet = productrepository.findByName(name);
        model.addAttribute("vaatekappaleet", vaatteet);
        return "clothes";
    }

}
