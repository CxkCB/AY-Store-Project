package com.xzstudio.aystore.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xzstudio.aystore.entity.Product;
import com.xzstudio.aystore.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @RequestMapping("/info")
    public ModelAndView info(int product_id){

        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("product_id",product_id);

        Product product = productService.getOne(queryWrapper);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("product");
        modelAndView.addObject(product);
        return modelAndView;
    }

}
