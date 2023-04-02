package com.store.smoothies.models;

import jakarta.persistence.*;


@Entity
@Table(name="user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "email", length = 50, nullable = false, unique = true)
    private String email;
    @Column(name = "firstname",  length = 20, nullable = false)
    private String firstName;
    @Column(name = "lastname", length = 20, nullable = false)
    private String lastName;

    @Column(name = "password", nullable = false, length = 255)
    private String password;



    public User(Long id, String username,
                String firstName, String lastName,
                String email, String password)
    {
        this.id = id;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
    }

    public User(User copy) {
        this.id = copy.id;
        this.email = copy.email;
        this.firstName = copy.firstName;
        this.lastName = copy.lastName;
        this.password = copy.password;
    }

    public User() {}


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return email;
    }

    public void setUsername(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }






}
