package com.xzstudio.aystore.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class Cart {

//    用户ID
    @TableId(value = "user_id")
    int userId;

//    商品ID
    int productId;

//    购物车物品数量
    int cartQuantity;
}
