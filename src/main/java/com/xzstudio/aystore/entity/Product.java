package com.xzstudio.aystore.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class Product {

//    商品ID
    @TableId(value = "product_id",type = IdType.AUTO)
    int productId;

//    商品标题
    String productTitle;

//    商品价格
    float productPrice;

//    商品库存
    int productInventory;

//    商品图片
    String productImage;

//    商品描述
    String productDescription;

//    商品信息创建时间
    @TableField(fill = FieldFill.INSERT)
    String productCreateDate;

//    商品信息更新时间
    @TableField(fill = FieldFill.UPDATE)
    String productUpdateDate;

}
