package com.store.smoothies.controllers;
import com.store.smoothies.models.Product;
import com.store.smoothies.repositories.ProductRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.store.smoothies.services.ProductService;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class Collection {

    ProductService productRepo;
    // field Injection
    public Collection(ProductService p){
        this.productRepo = p;
    }
//    @GetMapping("/collection")
//    public String displayCollectionPage(){
//        return "collection";
//    }

//    @GetMapping("/collection")
//    public String displayCollectionPage(Model model){
//        List<Product> prd = productRepo.findAll();
//        model.addAttribute("products", prd);
//        return "collection";
//    }
    @GetMapping("/collection")
    public ModelAndView getAllProducts(){
        ModelAndView mav = new ModelAndView("collection");
//        List<Product> products = this.productRepo.findAll();
//        for (int i =0;i< products.size();i++){
//            products.get(i).getName();
//        }
        mav.addObject("products", this.productRepo.findAll());
        return mav;
    }
}
