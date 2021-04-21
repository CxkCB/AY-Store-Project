package com.xzstudio.aystore.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class User {

//    用户ID(增加)
    @TableId(value = "user_id",type = IdType.AUTO)
    int userId;

//    用户邮箱地址
    String userEmail;

//    用户手机号码
    String userPhone;

//    用户登录密码
    String userPass;

//    用户昵称
    String userNick;

//    用户头像
    String userIcon;

//    用户真实姓名
    String userIdentityName;

//    用户身份证号码
    String userIdentityId;

//    用户出生日期
    String userIdentityDate;

//    用户信息创建时间
    @TableField(fill = FieldFill.INSERT)
    String userCreateDate;

//    用户信息更新时间
    @TableField(fill = FieldFill.UPDATE)
    String userUpdateDate;

}
