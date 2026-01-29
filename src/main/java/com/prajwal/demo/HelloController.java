package com.prajwal.demo;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("/test")
  public String test() {
        return "welcome to springboot......." ;
    }
}
