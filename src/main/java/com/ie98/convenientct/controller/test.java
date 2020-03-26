package com.ie98.convenientct.controller;

import org.springframework.web.bind.annotation.GetMapping;

public class test {
    @GetMapping("/homePage")
    public String homePage(){
        return "homePage";
    }
}
