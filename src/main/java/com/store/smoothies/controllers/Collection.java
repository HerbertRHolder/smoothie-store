package com.store.smoothies.controllers;

import com.store.smoothies.data.ChargeRequest;
import com.store.smoothies.models.User;
import com.store.smoothies.services.StripeService;
import com.stripe.exception.StripeException;
import com.stripe.model.Charge;
import com.stripe.model.Customer;

import com.store.smoothies.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.store.smoothies.services.ProductService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


import java.text.NumberFormat;
import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

@Controller
public class Collection {
    private Number priceToUse = null;
    private final ProductService  productService;
    private Customer customer;
    private Product current_product = null;

    @Value("${STRIPE_API_PKEY}")
    private String stripePublicKey;
    private StripeService paymentsService;

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
    public String showPage(@PathVariable long id, Model model)throws ParseException {
        this.current_product = productService.findById(id);

        String price = String.valueOf(this.current_product.getPrice());
        Locale locale = Locale.US;
        priceToUse = NumberFormat.getCurrencyInstance(locale).parse("$"+price);




        return "redirect:/product";
    }
    @GetMapping("/product")
    public String sayHello(Model model) {
        String sPrice = String.valueOf(priceToUse);

        model.addAttribute("product", this.current_product);
        model.addAttribute("amount", priceToUse.doubleValue()*100);
        model.addAttribute("displayAmount", "$"+sPrice);
        model.addAttribute("stripePublicKey", stripePublicKey);
        model.addAttribute("currency", ChargeRequest.Currency.USD);




        return "/product";
    }



    @PostMapping("/purchase")
    public String charge(ChargeRequest chargeRequest, Model model)
            throws StripeException {

        // 1. Grab all flight data from hidden inputs in paymentStatus.html using @RequestParam
        // 2. Use RequestParam data to build Flight object.
        // 3. Save Flight obj to database

        chargeRequest.setDescription("Example charge");
        chargeRequest.setCurrency(ChargeRequest.Currency.USD);
        Charge charge = paymentsService.charge(chargeRequest);
        model.addAttribute("id", charge.getId());
        model.addAttribute("status", charge.getStatus());
        model.addAttribute("chargeId", charge.getId());
        model.addAttribute("balance_transaction", charge.getBalanceTransaction());
        User currentUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        Map<String, String> metadata = new HashMap<>();
        String user = currentUser.getId().toString();
        metadata.put("user_id", user);

        return "paymentStatus";
    }



}
