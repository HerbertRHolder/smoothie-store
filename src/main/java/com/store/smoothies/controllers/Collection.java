package com.store.smoothies.controllers;

import com.store.smoothies.data.ChargeRequest;
import com.store.smoothies.models.User;
import com.store.smoothies.models.UserProducts;
import com.store.smoothies.repositories.UserProductRepository;
import com.store.smoothies.repositories.UserRepository;
import com.store.smoothies.services.StripeService;
import com.store.smoothies.services.UserDetailsLoader;
import com.store.smoothies.services.UserService;
import com.stripe.exception.StripeException;
import com.stripe.model.Charge;

import com.store.smoothies.models.Product;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.store.smoothies.services.ProductService;


import java.text.NumberFormat;
import java.text.ParseException;
import java.util.*;

@Controller
@Component
public class Collection {

    public final UserService userService;
    public final UserRepository userRepo;
    public final UserProductRepository userProductRepo;
    private Integer priceToUse = null;
    private Product current_product = null;
    private final ProductService  productService;
    List<UserProducts> products = new ArrayList<>();

    @Value("${STRIPE_API_PKEY}")
    private String stripePublicKey;
    private final StripeService paymentsService;
    private final PasswordEncoder passwordEncoder;

    // field Injection
    @Autowired
    public Collection(ProductService p, StripeService ps, UserRepository r, UserService user, UserProductRepository userProductRepo, PasswordEncoder pe){
        this.productService = p;
        this.paymentsService = ps;
        this.userService = user;
        this.userProductRepo = userProductRepo;
        this.passwordEncoder = pe;
        this.userRepo = r;
    }

    @PostMapping("/login")
    public String login(@ModelAttribute("user") User user, Model model) throws Exception {
        User existingUser = this.userService.findByName(user.getUsername());
        if (existingUser == null) {
            model.addAttribute("error", "Invalid email or password");
            return "login";
        }
        if (!this.passwordEncoder.matches(user.getPassword(), existingUser.getPassword())) {
            model.addAttribute("error", "Invalid email or password");
            return "login";
        }
        SecurityContextHolder.getContext().getAuthentication().setAuthenticated(true);
        return "redirect:/";
    }
    @GetMapping("/collection")
    public String getAllProducts(Model model){
        model.addAttribute("products", this.productService.findAll());
        return "collection";
    }

    @GetMapping("/collection/{id}")
    public String showPage(@PathVariable long id, Model model)throws ParseException {
        this.current_product = productService.findById(id);

        String price = String.valueOf(this.current_product.getPrice()).replace(".","");
        Locale locale = Locale.US;
        Number parsedPrice = NumberFormat.getCurrencyInstance(locale).parse("$"+price);
        priceToUse = Integer.valueOf(price);

        return "redirect:/product";
    }
    @GetMapping("/product")
    public String sayHello(Model model) {

        model.addAttribute("product", this.current_product);
        model.addAttribute("amount", priceToUse);
        System.out.println(priceToUse + " :priceToUse");
        model.addAttribute("displayAmount", "$"+priceToUse);
        System.out.println("$"+priceToUse + " : displayAmount");
        model.addAttribute("stripePublicKey", stripePublicKey);
        model.addAttribute("currency", ChargeRequest.Currency.USD);

        return "/product";
    }
    @PostMapping("/product")
    public String postForm() {


        return "/product";
    }


    @Transactional
    @PostMapping("/purchase")
    public String charge(
            @RequestParam String id,
            ChargeRequest chargeRequest, Model model)
            throws StripeException {

        // 1. Grab all flight data from hidden inputs in paymentStatus.html using @RequestParam

         chargeRequest.setDescription("Example charge");
         chargeRequest.setCurrency(ChargeRequest.Currency.USD);
         Charge charge = this.paymentsService.charge(chargeRequest);
         model.addAttribute("id", charge.getId());
         model.addAttribute("status", charge.getStatus());
         model.addAttribute("chargeId", charge.getId());
         model.addAttribute("balance_transaction", charge.getBalanceTransaction());
         long idValue = Long.valueOf(id);
         User userAuth = (User)  SecurityContextHolder.getContext().getAuthentication().getPrincipal();
         User u = new User(userAuth);
         Product p = this.productService.findById(idValue);
         UserProducts up = new UserProducts(u,p);
         userProductRepo.save(up);
         this.products = userProductRepo.getUserProductsById(u.getId());
         model.addAttribute("products", this.products);
        return "profile";
    }

    @GetMapping("/profile")
    public String displayRegisterPage(@AuthenticationPrincipal UserDetailsLoader user, Model model) {

        User userAuth = (User)  SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User u = new User(userAuth);
        this.products = userProductRepo.getUserProductsById(u.getId());
        model.addAttribute("products", this.products);
        return "profile";
    }



}