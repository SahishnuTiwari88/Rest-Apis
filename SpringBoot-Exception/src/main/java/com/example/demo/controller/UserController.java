package com.example.demo.controller;
import java.util.LinkedHashMap;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.model.User;
import com.example.demo.service.UserService;

@RestController
@RequestMapping("/api")
public class UserController {
  @Autowired
  private UserService userService;
  
  @GetMapping("/users")
  public ResponseEntity < ? > getUser() {
    Map < String, Object > respJsonOutput = new LinkedHashMap < String, Object > ();
    List < User > userList = userService.getTheUsersList();
    if (!userList.isEmpty()) {
      respJsonOutput.put("status", 1);
      respJsonOutput.put("data", userList);
      return new ResponseEntity < > (respJsonOutput, HttpStatus.OK);
    } else {
      respJsonOutput.clear();
      respJsonOutput.put("status", 0);
      respJsonOutput.put("message", "Data is not found");
      return new ResponseEntity < > (respJsonOutput, HttpStatus.NOT_FOUND);
    }
  }

  @PostMapping("/save")
  public ResponseEntity < ? > saveUser(@RequestBody User user) {
    Map < String, Object > respJsonOutput = new LinkedHashMap < String, Object > ();
    userService.save(user);
    respJsonOutput.put("status", 1);
    respJsonOutput.put("message", "Record is Saved Successfully!");
    return new ResponseEntity < > (respJsonOutput, HttpStatus.CREATED);
  }
  
  @GetMapping("/user/{id}")
  public ResponseEntity < ? > getUserById(@PathVariable Integer id) {
    Map < String, Object > respJsonOutput = new LinkedHashMap < String, Object > ();
    User user = userService.findById(id);
    respJsonOutput.put("status", 1);
    respJsonOutput.put("data", user);
    return new ResponseEntity < > (respJsonOutput, HttpStatus.OK);
  }

  @DeleteMapping("/delete/{id}")
  public ResponseEntity < ? > deleteUser(@PathVariable Integer id) {
    Map < String, Object > respJsonOutput = new LinkedHashMap < String, Object > ();
    User user = userService.findById(id);
    userService.delete(user);
    respJsonOutput.put("status", 1);
    respJsonOutput.put("message", "Record is deleted successfully!");
    return new ResponseEntity < > (respJsonOutput, HttpStatus.OK);
  }
  
  @PutMapping("/update/{id}")
  public ResponseEntity < ? > updateTheUser(@PathVariable Integer id, @RequestBody User userDetail) {
    Map < String, Object > respJsonOutput = new LinkedHashMap < String, Object > ();
    User user = userService.findById(id);
    user.setUserName(userDetail.getUserName());
    user.setMobileNo(userDetail.getMobileNo());
    user.setEmailId(userDetail.getEmailId());
    user.setCity(userDetail.getCity());
    user.setPassword(userDetail.getPassword());
    userService.save(user);
    respJsonOutput.put("status", 1);
    respJsonOutput.put("data", userService.findById(id));
    return new ResponseEntity < > (respJsonOutput, HttpStatus.OK);
  }
}