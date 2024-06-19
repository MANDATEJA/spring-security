package com.springsec.springsecuritybasic.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

  @GetMapping("welcome")
  public String sayWelcome() {
    return "Welcome to my Spring application with Security";
  }
}
