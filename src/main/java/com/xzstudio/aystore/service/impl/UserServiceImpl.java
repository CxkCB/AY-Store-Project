package com.xzstudio.aystore.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xzstudio.aystore.entity.User;
import com.xzstudio.aystore.mapper.UserMapper;
import com.xzstudio.aystore.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}
