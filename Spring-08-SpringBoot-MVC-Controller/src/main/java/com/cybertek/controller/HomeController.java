package com.cybertek.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping
    public String getRequestMapping(){

        return "home";
    }

    @RequestMapping("/ozzy")
    public String getRequestMapping2(){

        return "home";
    }
}
