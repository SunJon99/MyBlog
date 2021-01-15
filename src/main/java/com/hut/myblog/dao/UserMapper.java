package com.hut.myblog.dao;

import com.hut.myblog.bean.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface UserMapper {
    User checkUser(@Param("username")String username, @Param("password") String password);
}
