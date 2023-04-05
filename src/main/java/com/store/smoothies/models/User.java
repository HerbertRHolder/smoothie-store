package com.store.smoothies.models;

import jakarta.persistence.*;


@Entity
@Table(name="user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "email", length = 50, nullable = false, unique = true)
    private String username;

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
        this.username = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
    }

    public User(User copy) {
        this.id = copy.id;
        this.username = copy.username;
        this.firstName = copy.firstName;
        this.lastName = copy.lastName;
        this.password = copy.password;
    }
    public User() {}
    public Long getId() { return this.id; }
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



}
