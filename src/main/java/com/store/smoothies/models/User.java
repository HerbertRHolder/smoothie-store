package com.store.smoothies.models;

import jakarta.persistence.*;
import com.stripe.model.Customer;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name="user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "email", length = 50, nullable = false, unique = true)
    private String username;

    @Column(name = "firstname", length = 20, nullable = false)
    private String firstName;
    @Column(name = "lastname", length = 20, nullable = false)
    private String lastName;
    @Column(name = "password", nullable = false, length = 255)
    private String password;
    @Column(name = "Customer_id", nullable = false, length = 255)
    private String customer_id;
    @ManyToMany
    @JoinTable(
            name = "user_product",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    private Set<Product> products = new HashSet<>();

    public User(Long id, String username, String firstName, String lastName, String password, String customer_id, Set<Product> products) {
        this.id = id;
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.customer_id = customer_id;
        this.products = products;
    }

    public User(User copy) {
        this.id = copy.id;
        this.username = copy.username;
        this.firstName = copy.firstName;
        this.lastName = copy.lastName;
        this.password = copy.password;
        this.customer_id = copy.customer_id;
        this.products = copy.products;
    }


    public User() {}
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String name) {
        this.username = name;
    }


    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCustomer_id() {
        return this.customer_id;
    }

    public void setCustomer_id(String customer_id) {
        this.customer_id = customer_id;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }
}
