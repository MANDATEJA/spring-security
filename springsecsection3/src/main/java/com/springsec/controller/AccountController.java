package com.springsec.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
public class AccountController {
  @GetMapping("/myAccount")
  public String getMethodName() {
      return "Here are your account details from DB";
  }
}
