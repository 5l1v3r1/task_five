package com.fuwei.service;

import com.fuwei.pojo.User;

public interface UserService {

    User login(String name);
    void register(User user);
    void upload(User user);
    User getVerify(int verify, String phone);
}
