package com.yifeng.dao;

import com.yifeng.domain.Admin;
import org.apache.ibatis.annotations.Select;

public interface AdminDao {

    @Select("select * from t_admin where username = #{username} and password = #{password}")
    public Admin login(String username, String password);
}
