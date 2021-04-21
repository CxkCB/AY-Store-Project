package com.xzstudio.aystore.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xzstudio.aystore.entity.ProductCategory;
import com.xzstudio.aystore.mapper.ProductCategoryMapper;
import com.xzstudio.aystore.service.ProductCategoryService;
import org.springframework.stereotype.Service;

@Service
public class ProductCategoryServiceImpl extends ServiceImpl<ProductCategoryMapper, ProductCategory> implements ProductCategoryService {
}
