package com.xzstudio.aystore.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xzstudio.aystore.entity.Cart;
import com.xzstudio.aystore.mapper.CartMapper;
import com.xzstudio.aystore.service.CartService;
import org.springframework.stereotype.Service;

@Service
public class CartServiceImpl extends ServiceImpl<CartMapper, Cart> implements CartService {
}
