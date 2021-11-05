package com.cybertek.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping("/home/{name}")
    public String pathVariablesEx(@PathVariable("name") String name){

        return "home";
    }
}
