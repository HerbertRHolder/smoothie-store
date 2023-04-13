package com.store.smoothies.services;

import com.store.smoothies.models.User;


import java.util.List;
import java.util.Optional;

public interface UserInterface {

    public Optional<User> findById(Long id)throws Exception;

    public List<User> findAll() throws Exception;
    public User findByName(String name) throws Exception;
    public void registerUser(User user) throws Exception;
}
