
package com.dogproductinventory.app.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.dogproductinventory.app.domain.DogProductRepository;
import com.dogproductinventory.app.domain.Manufacturer;
import com.dogproductinventory.app.domain.DogProduct;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ProductController {

    @Autowired
    private DogProductRepository productrepository;

    @GetMapping("")
    public String etuSivu() {
        return "index";
    }

    // listaa kaikki tuotteet
    @GetMapping("/productlist")
    public String productList(Model model) {
        model.addAttribute("products", productrepository.findAll());
        return "productlist";
    }

    // lomake uudelle tuotteelle
    @GetMapping("/addproduct")
    public String addProduct(Model model) {
        model.addAttribute("product", new DogProduct());
        return "productform";
    }

    // tuotteen muokkaus
    @GetMapping("/editproduct/{id}")
    public String editProduct(@PathVariable("id") Long productId, Model model) {
        model.addAttribute("product", productrepository.findById(productId));
        return "productform";
    }

    // tallentaa tiedot repositoryyn ja palaa sivulle joka näyttää listan
    @PostMapping("/saveproduct")
    public String saveProduct(@ModelAttribute DogProduct produ) {
        productrepository.save(produ);
        return "redirect:/productlist";
    }

    // tuotteen poisto
    @GetMapping("/deleteproduct/{id}")
    public String deleteProduct(@PathVariable("id") Long produId) {
        productrepository.deleteById(produId);
        return "redirect:/productlist";
    }

    @RequestMapping(value = "/productrest", method = RequestMethod.GET)
    public @ResponseBody List<DogProduct> productsListRest() {
        return (List<DogProduct>) productrepository.findAll();
    }

}
