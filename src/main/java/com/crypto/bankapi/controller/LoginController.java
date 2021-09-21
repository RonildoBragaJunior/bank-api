package com.crypto.bankapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/login-management")
public class LoginController {

    @GetMapping("/logon")
    public String getUsers(){
        return "I am here";
    }

    @PostMapping("/logon")
    public String settUsers(){
        return "I am here";
    }
}
