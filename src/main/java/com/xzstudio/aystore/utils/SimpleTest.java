package com.xzstudio.aystore.utils;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xzstudio.aystore.AyStoreProjectApplication;
import com.xzstudio.aystore.entity.Cart;
import com.xzstudio.aystore.entity.Product;
import com.xzstudio.aystore.entity.ProductCategory;
import com.xzstudio.aystore.entity.User;
import com.xzstudio.aystore.mapper.CartMapper;
import com.xzstudio.aystore.mapper.ProductCategoryMapper;
import com.xzstudio.aystore.mapper.ProductMapper;
import com.xzstudio.aystore.mapper.UserMapper;
import com.xzstudio.aystore.service.CartService;
import com.xzstudio.aystore.service.ProductService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = AyStoreProjectApplication.class)
public class SimpleTest {

    @Autowired
    CartService cartService;
    @Autowired
    ProductService productService;

    @Test
    public void test(){

        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("user_id",1);

        List<Cart> cartList = cartService.list(wrapper);

        List<Integer> idList = new ArrayList<>();

        cartList.forEach(cart -> {
            idList.add(cart.getProductId());
        });

        List<Product> productList = productService.listByIds(idList);

        productList.forEach(System.out::println);
    }
}
