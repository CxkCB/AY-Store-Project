package com.xzstudio.aystore.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xzstudio.aystore.entity.Product;
import com.xzstudio.aystore.mapper.ProductMapper;
import com.xzstudio.aystore.service.ProductService;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements ProductService {
}
