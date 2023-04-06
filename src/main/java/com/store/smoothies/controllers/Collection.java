package com.store.smoothies.controllers;
import com.store.smoothies.models.Product;
import com.store.smoothies.repositories.ProductRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.store.smoothies.services.ProductService;
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
    @GetMapping("/collection")
    public String displayCollectionPage(Model model){
        List<Product> prd = productRepo.findAll();
        model.addAttribute("products", prd);
        return "collection";
    }
}
