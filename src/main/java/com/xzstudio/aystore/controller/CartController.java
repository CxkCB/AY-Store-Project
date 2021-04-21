package com.xzstudio.aystore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/cart")
public class CartController {

    @GetMapping("/list")
    public ModelAndView list(){

        ModelAndView modelAndView = new ModelAndView();

        modelAndView.setViewName("register");

        return modelAndView;
    }
}
