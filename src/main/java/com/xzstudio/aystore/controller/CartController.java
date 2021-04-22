package com.xzstudio.aystore.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xzstudio.aystore.entity.Cart;
import com.xzstudio.aystore.entity.Product;
import com.xzstudio.aystore.entity.User;
import com.xzstudio.aystore.service.CartService;
import com.xzstudio.aystore.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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

    @RequestMapping("/list")
    public ModelAndView list(HttpSession session) {

//        获取session中的用户数据
        User user = (User) session.getAttribute("user");

//        构建根据用户ID的查询封装
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("user_id",user.getUserId());

//        查询出购物车实体类集合
        List<Cart> cartList = cartService.list(queryWrapper);

//        实现一个整型集合，用于存储购物车中的批量商品ID
        List<Integer> idList = new ArrayList<>();

//        向批量ID集合插入商品ID数据
        cartList.forEach(cart -> idList.add(cart.getProductId()));

//        根据批量ID查询批量商品信息
        List<Product> productList = productService.listByIds(idList);

//        构建用于向静态页面传输数据的map集合
        List<Map<String,Object>> mapList = new ArrayList<>();
        for (int i=0 ; i<cartList.size() ; i++){
            HashMap<String,Object> map = new HashMap<>();
            map.put("product_id",productList.get(i).getProductId());
            map.put("product_image",productList.get(i).getProductImage());
            map.put("product_price",productList.get(i).getProductPrice());
            map.put("product_title",productList.get(i).getProductTitle());
            map.put("product_quantity",cartList.get(i).getProductQuantity());
            mapList.add(map);
        }

//        设置返回的页面，添加map数组作为传输数据
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("cart");
        modelAndView.addObject("mapList",mapList);
        return modelAndView;
    }




}
