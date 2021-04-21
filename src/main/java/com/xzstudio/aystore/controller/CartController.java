package com.xzstudio.aystore.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xzstudio.aystore.entity.Cart;
import com.xzstudio.aystore.entity.Product;
import com.xzstudio.aystore.entity.User;
import com.xzstudio.aystore.service.CartService;
import com.xzstudio.aystore.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/cart")
public class CartController {

    @Autowired
    CartService cartService;
    @Autowired
    ProductService productService;

    @GetMapping("/list")
    public ModelAndView list(HttpSession session){

//        根据session中的用户ID构建查询封装
        User user = (User) session.getAttribute("user");
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("user_id",user.getUserId());

//        查询购物车数据
        List<Cart> cartList = cartService.list(queryWrapper);

//        构建ID集合
        List<Integer> idList = new ArrayList<>();
        cartList.forEach(cart -> {
            idList.add(cart.getProductId());
        });

//        根据购物车的批量商品ID查询商品
        List<Product> productList = productService.listByIds(idList);

//        添加购物车商品数据数量
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject(productList);

//        返回购物车页面
        modelAndView.setViewName("cart");
        return modelAndView;

    }

}
