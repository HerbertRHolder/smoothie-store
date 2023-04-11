package com.store.smoothies.services;

import com.store.smoothies.models.User;


import java.util.List;
public interface UserInterface {

    public User findById(Long id);

    public List<User> findAll();
    public User findByName(String name);

    public

}
