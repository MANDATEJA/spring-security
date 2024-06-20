package com.springsec.springsecsection2.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
public class ContactController {
  @GetMapping("/contact")
  public String getMethodName() {
      return "Contact details from DB";
  }
  
}
