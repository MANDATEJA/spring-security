package com.springsec.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
public class BalanceController {
  @GetMapping("/myBalance")
  public String getMethodName() {
      return "Balance details from DB";
  }

}
