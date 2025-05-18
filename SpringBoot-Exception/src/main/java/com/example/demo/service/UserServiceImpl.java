package com.example.demo.service;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.dao.UserRepstry;
import com.example.demo.exception.UserNotFoundException;
import com.example.demo.model.User;


@Service
public class UserServiceImpl implements UserService {
  @Autowired
  private UserRepstry  userRepo;
  @Override
  public List < User > getTheUsersList() {
    return userRepo.findAll();
  }
  @Override
  public void save(User user) {
    userRepo.save(user);
  }
  @Override
  public User findById(Integer id) {
    Optional < User > userInfo = userRepo.findById(id);
    User user = null;
    if (userInfo.isPresent()) {
      user = userInfo.get();
    } else {
      throw new UserNotFoundException("The user info is not available:" + id);
    }
    return user;
  }
  @Override
  public void delete(User user) {
    userRepo.delete(user);
  }
}