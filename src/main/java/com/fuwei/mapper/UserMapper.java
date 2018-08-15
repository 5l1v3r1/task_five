package com.fuwei.mapper;

import com.fuwei.pojo.User;

public interface UserMapper {

    public User login(String name);
    public void register(User user);
    public void upload(User user);
    public User getVerify(String phone);

}
