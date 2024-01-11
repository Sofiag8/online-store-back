package com.example.onlinestoreback.Controller;

import com.example.onlinestoreback.Entity.User;
import com.example.onlinestoreback.Service.UserService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;


@RestController
@RequestMapping("/api/v1/user")
public class UserController {
  
  private final UserService userService;


  @Autowired
  public UserController(UserService userService) {
      this.userService = userService;
  }

  @PostMapping("/signup")
  @ResponseStatus(HttpStatus.CREATED)
  public String createUser(@Valid  @RequestBody User user) {
    userService.createUser(user);
    return "ok";

  }
}
