package com.store.smoothies.models;

import jakarta.persistence.*;

@Entity
@Table(name="product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "Product_Name", length = 20, nullable = false, unique = true)
    private String name;
    @Column(name = "Description", length = 255, nullable = false)
    private String desc;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "Inventory_id")
    private Inventory inventory_id;




}
