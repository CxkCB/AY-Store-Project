package com.xzstudio.aystore.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class ProductCategory {

//    商品ID
    @TableId(value = "product_id")
    int productId;

//    商品一级分类(FirstClass)
    int firstClass;

//    商品二级第二分类(SecondClass)
    int SecondClass;

//    商品三级第三分类(ThirdClass)
    int ThirdClass;

}
