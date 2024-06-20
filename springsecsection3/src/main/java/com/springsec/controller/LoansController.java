package com.springsec.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
public class LoansController {
  @GetMapping("/myLoans")
  public String getMethodName() {
      return "Loan details from DB";
  }
  
}
