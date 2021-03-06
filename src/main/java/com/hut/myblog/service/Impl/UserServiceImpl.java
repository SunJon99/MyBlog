package com.hut.myblog.service.Impl;


import com.hut.myblog.bean.User;
import com.hut.myblog.dao.UserMapper;
import com.hut.myblog.service.UserService;
import com.hut.myblog.util.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl  implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public User checkUser(String username, String password) {
        User user=userMapper.checkUser(username, MD5Utils.code(password));
       return user;
    }
}
