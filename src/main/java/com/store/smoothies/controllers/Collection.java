package com.store.smoothies.controllers;

import com.store.smoothies.data.ChargeRequest;
//import com.store.smoothies.services.StripeService;
import com.stripe.exception.StripeException;
import com.stripe.model.Charge;

import com.store.smoothies.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.store.smoothies.services.ProductService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


import java.util.List;

@Controller
public class Collection {

    private final ProductService  productService;
    private Product current_product = null;

//    @Value("${STRIPE_API_PKEY}")
//    private String stripePublicKey;
//    private StripeService paymentsService;
    // field Injection
    @Autowired
    public Collection(ProductService p){
        this.productService = p;
    }


    @GetMapping("/collection")
    public String getAllProducts(Model model){
        model.addAttribute("products", this.productService.findAll());
        return "collection";
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



//    @PostMapping("/charge")
//    public String charge(ChargeRequest chargeRequest, Model model)
//            throws StripeException {
//
//        // 1. Grab all flight data from hidden inputs in paymentStatus.html using @RequestParam
//        // 2. Use RequestParam data to build Flight object.
//        // 3. Save Flight obj to database
//
//        chargeRequest.setDescription("Example charge");
//        chargeRequest.setCurrency(ChargeRequest.Currency.USD);
//        Charge charge = paymentsService.charge(chargeRequest);
//        model.addAttribute("id", charge.getId());
//        model.addAttribute("status", charge.getStatus());
//        model.addAttribute("chargeId", charge.getId());
//        model.addAttribute("balance_transaction", charge.getBalanceTransaction());
//        return "paymentStatus";
//    }



}
