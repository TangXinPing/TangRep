package com.hair.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/wel")
public class WelcomeController {

    @RequestMapping(value = "/toWel")
    public String toWel(){
        return "welcome";
    }
}
