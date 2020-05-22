package com.yifeng.dao;

import com.yifeng.domain.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UserDao {

    @Select("select * from t_user limit #{index},#{limit}")
    public List<User> findAll(int index, int limit);

    @Select("select * from t_user where id = #{id}")
    public User findById(long id);

    @Select("select count(id) from t_user")
    public int count();

    @Insert("insert into t_user(username,password,nickname,gender,telephone,registerdate,address) values(#{username},#{password},#{nickname},#{gender},#{telephone},#{registerdate},#{address})\n")
    public void save(User user);

    @Update("update t_user set username = #{username},password = #{password},nickname = #{nickname},gender = #{gender} " +
            "telephone = #{telephone},registerdate = #{registerdate},address = #{address} where id = #{id}")
    public void update(User user);

    @Delete("delete from t_user where id = #{id}")
    public void deleteById(long id);

}
