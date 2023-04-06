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
}
