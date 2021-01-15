package com.hut.myblog.service;

import com.hut.myblog.bean.User;

public interface UserService {
    User checkUser(String username,String password);
}
