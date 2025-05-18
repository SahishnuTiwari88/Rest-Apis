package com.example.demo.service;

import java.util.List;

import com.example.demo.model.User;

public interface UserService {

  public List < User > getTheUsersList();
  public void save(User user);
  public User findById(Integer id);
  public void delete(User user);
}
