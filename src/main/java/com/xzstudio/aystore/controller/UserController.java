package com.xzstudio.aystore.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xzstudio.aystore.entity.User;
import com.xzstudio.aystore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

//    用户进行登录操作
    @PostMapping("/login")
    public String login(String account, String password, HttpSession session){

//        实例化一个查询封装
        QueryWrapper queryWrapper = new QueryWrapper();

//        声明一个用户实体类
        User user;

//        判断传入的数据是否为空
        if ( account.isEmpty() || password.isEmpty() ){

            return "login";

        }else {

            queryWrapper.eq("user_email",account);
            queryWrapper.eq("user_pass",password);

            user = userService.getOne(queryWrapper);

            if(user == null){

                queryWrapper.clear();
                queryWrapper.eq("user_phone",account);
                queryWrapper.eq("user_pass",password);

                user = userService.getOne(queryWrapper);

                if (user == null){
                    return "login";
                }

            }

        }
//        将用户信息写入session并返回主页
        session.setAttribute("user",user);
        return "redirect:/";
    }

//    用户注销登录
    @RequestMapping("/logout")
    public String logout(HttpSession session){

        session.removeAttribute("user");

        return "redirect:/";
    }

    @RequestMapping("/register")
    public String register(String user_email,String user_phone,String user_pass,String user_nick,HttpSession session){

        if(user_email.isEmpty() || user_phone.isEmpty() || user_pass.isEmpty() || user_nick.isEmpty()){ return "register"; }

        User user = new User();

        user.setUserEmail(user_email);
        user.setUserPhone(user_phone);
        user.setUserPass(user_pass);
        user.setUserNick(user_nick);

        userService.save(user);

        session.setAttribute("user",user);

        return "redirect:/";
    }

}
