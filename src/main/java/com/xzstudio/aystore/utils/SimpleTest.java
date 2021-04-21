package com.xzstudio.aystore.utils;

import com.xzstudio.aystore.AyStoreProjectApplication;
import com.xzstudio.aystore.entity.Cart;
import com.xzstudio.aystore.entity.Product;
import com.xzstudio.aystore.entity.ProductCategory;
import com.xzstudio.aystore.entity.User;
import com.xzstudio.aystore.mapper.CartMapper;
import com.xzstudio.aystore.mapper.ProductCategoryMapper;
import com.xzstudio.aystore.mapper.ProductMapper;
import com.xzstudio.aystore.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = AyStoreProjectApplication.class)
public class SimpleTest {

    @Autowired
    UserMapper userMapper;
    @Autowired
    ProductMapper productMapper;
    @Autowired
    CartMapper cartMapper;
    @Autowired
    ProductCategoryMapper productCategoryMapper;

    @Test
    public void test(){

        List<ProductCategory> productCategoryList = productCategoryMapper.selectList(null);
        productCategoryList.forEach(System.out::println);

        List<Cart> cartList = cartMapper.selectList(null);
        cartList.forEach(System.out::println);

        List<Product> productList = productMapper.selectList(null);
        productList.forEach(System.out::println);

        List<User> userList = userMapper.selectList(null);
        userList.forEach(System.out::println);
    }
}
