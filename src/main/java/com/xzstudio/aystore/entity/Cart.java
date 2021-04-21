package com.xzstudio.aystore.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class Cart {

//    用户ID
    @TableId(value = "user_id")
    int userId;

//    商品ID
    int productId;

//    购物车物品ID
    int cartId;
}
