package com.store.smoothies.controllers;
import com.store.smoothies.models.Product;
import com.store.smoothies.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.store.smoothies.services.ProductService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class Collection {

    private final ProductService  productService;
    private Product current_product;

    // field Injection
    @Autowired
    public Collection(ProductService p){
        this.productService = p;
    }
    @GetMapping("/collection")
    public ModelAndView getAllProducts(){
        ModelAndView mav = new ModelAndView("collection");
        mav.addObject("products", this.productService.findAll());
        return mav;
    }

    @GetMapping("/collection/{id}")
    public String showPage(@PathVariable long id, Model model) {
        this.current_product = productService.findById(id);
        return "redirect:/product";
    }
    @GetMapping("/product")
    public String sayHello(Model model) {
        model.addAttribute("product", this.current_product);
        return "/product";
    }


}
