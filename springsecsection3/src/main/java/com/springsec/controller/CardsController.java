package com.springsec.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
public class CardsController {
  @GetMapping("/myCards")
  public String getMethodName() {
      return "Cards details from DB";
  }
  
}
