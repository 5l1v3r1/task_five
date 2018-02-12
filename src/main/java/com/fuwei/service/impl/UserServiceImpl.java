package com.fuwei.service.impl;

import com.fuwei.mapper.UserMapper;
import com.fuwei.pojo.User;
import com.fuwei.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;


    @Override
    public User login(String name) {
        System.out.println("-------------------+++++++++++----------------");
        return userMapper.login(name);
    }

    @Override
    public void register(User user) {
        userMapper.register(user);
    }
}
