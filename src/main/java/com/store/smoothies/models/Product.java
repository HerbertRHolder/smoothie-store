package com.store.smoothies.models;

import jakarta.persistence.*;
import org.springframework.core.annotation.Order;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "Product_Name", length = 20, nullable = false, unique = true)
    private String name;
    @Column(name = "description", length = 255, nullable = false)
    private String desc;

    @Column(name = "Price", length = 10, nullable = false)
    private double price;

    @Column(name = "image_path", length = 255, nullable = false)
    private String img;

    @ManyToMany(mappedBy = "productSet")
    Set<User> users = new HashSet<>();


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "Inventory_id")
    private Inventory inventory_id;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Inventory getInventory_id() {
        return inventory_id;
    }

    public void setInventory_id(Inventory inventory_id) {
        this.inventory_id = inventory_id;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Set<User> getUsers() {
        return this.users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
