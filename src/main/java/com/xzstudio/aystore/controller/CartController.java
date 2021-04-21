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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/cart")
public class CartController {

    @Autowired
    CartService cartService;
    @Autowired
    ProductService productService;

    @GetMapping("/list")
    public ModelAndView list(HttpSession session) {

//        获取session中的用户数据
        User user = (User) session.getAttribute("user");

//        依据用户ID构建查询封装
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("user_id",user.getUserId());

//        进行查询获得购物车实体类集合
        List<Cart> cartList = cartService.list(wrapper);

//        获得购物车实体类中的商品ID
        List<Integer> idList = new ArrayList<>();
        cartList.forEach(cart -> {
            idList.add(cart.getProductId());
        });

//        根据IDS进行批量查询，获得购物车中的商品数据
        List<Product> productList = productService.listByIds(idList);

        List<Map<String,Object>> mapList = new ArrayList<>();

        for (int i=0;i<cartList.size();i++){
            HashMap<String,Object> map = new HashMap<>();
            map.put("productQuantity",cartList.get(i).getCartQuantity());
            map.put("product",productList.get(i));
            mapList.add(map);
        }

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("cart");
        modelAndView.addObject("mapList",mapList);
        return modelAndView;
    }
}
