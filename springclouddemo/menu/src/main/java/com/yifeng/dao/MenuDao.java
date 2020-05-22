package com.yifeng.dao;

import com.yifeng.domain.Menu;
import com.yifeng.domain.Type;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

@Mapper
public interface MenuDao {

    @Select("select * from t_menu limit #{index},#{limit}")
    @Results(id = "TypeMap", value = {
            @Result(id=true,column="id",property="id"),
            @Result(column = "name",property = "name"),
            @Result(column = "price",property = "price"),
            @Result(column = "flavor",property = "flavor"),
            @Result(column = "tid",property = "type",javaType = Type.class,
                    one = @One(select = "com.yifeng.dao.TypeDao.findById", fetchType = FetchType.EAGER)),

    })
    public List<Menu> findAll(int index, int limit);

    @Select("select count(id) from t_menu")
//    @ResultMap(value = {"TypeMap"})
    public int count();

    @Select("select * from t_menu where id = #{id}")
    @ResultMap(value = {"TypeMap"})
    public Menu findById(long id);

    @Insert("insert into t_menu(name,price,flavor,tid) values(#{name},#{price},#{flavor},#{type.id})")
    public void save(Menu menu);

    @Update("update t_menu set name = #{name},price = #{price},flavor = #{flavor},tid = #{type.id} where id = #{id}")
    public void update(Menu menu);

    @Delete("delete from t_menu where id = #{id}")
    public void deleteById(long id);
}
