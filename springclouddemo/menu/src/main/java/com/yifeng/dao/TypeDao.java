package com.yifeng.dao;

import com.yifeng.domain.Menu;
import com.yifeng.domain.Type;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface TypeDao {
    @Select("select * from t_type where id = #{tid}")
    public Type findById(long id);

    @Select("select * from t_type")
    public List<Type> findTypes();
}
