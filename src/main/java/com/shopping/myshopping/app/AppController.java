package com.shopping.myshopping.app;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class AppController {

    @GetMapping
    public String welcome() {
        return "Bem Vindo ao everis new talents Java, organizado pela DIO - Digital Innovation One!";
    }

}
