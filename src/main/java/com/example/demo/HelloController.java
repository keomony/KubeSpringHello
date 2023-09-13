package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

  @GetMapping("/")
  public String index() {

    System.out.println("In index controller");
    return "Greetings from Spring Boot!";
  }

}
