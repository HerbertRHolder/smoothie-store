package com.store.smoothies.models;
import jakarta.persistence.*;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name="customer")
@EntityListeners(AuditingEntityListener.class)
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "username",  length = 20, nullable = true)
    private String username;
    @Column(name = "firstname",  length = 20, nullable = false)
    private String firstName;
    @Column(name = "lastname", length = 20, nullable = false)
    private String lastName;
    @Column(name = "email", length = 50, nullable = false, unique = true)
    private String email;
    @Column(name = "password", nullable = false, length = 255)
    private String password;

    @CreatedDate
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime modifiedAt;

    @DeletedDate
    private LocalDateTime deletedAt;

    // other fields and methods

    // getters and setters

    @PrePersist
    public void onPrePersist() {
        this.createdAt = LocalDateTime.now();
    }

    @PreUpdate
    public void onPreUpdate() {
        this.modifiedAt = LocalDateTime.now();
    }

    @PreRemove
    public void onPreRemove() {
        this.deletedAt = LocalDateTime.now();
    }


    public Customer(Long id, String username,
                    String firstName, String lastName,
                    String email, String password)
    {
        this.id = id;
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }

    public Customer(Customer copy) {
        this.id = copy.id;
        this.username = copy.username;
        this.firstName = copy.firstName;
        this.lastName = copy.lastName;
        this.email = copy.email;
        this.password = copy.password;
    }

    public Customer() {}





}
