package com.xzstudio.aystore.controller;

import com.xzstudio.aystore.entity.Product;
import com.xzstudio.aystore.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    ProductService productService;

    @GetMapping("/")
    public ModelAndView home(){

        List<Product> productList = productService.list(null);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        modelAndView.addObject("productList",productList);
        return modelAndView;
    }

}
