package com.yifeng.dao;

import com.yifeng.domain.User;
import org.apache.ibatis.annotations.Select;

public interface UserDao {

    @Select("select * from t_user where username = #{username} and password = #{password}")
    public User login(String username, String password);
}
