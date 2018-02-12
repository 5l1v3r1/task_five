package com.fuwei.mapper;

import com.fuwei.pojo.User;

public interface UserMapper {

    public User login(String name);
    public void register(User user);
}
