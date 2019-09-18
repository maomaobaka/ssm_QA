package com.company.dao;

import com.company.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserDao {
    String TABLE_NAME = " User ";
    String INSERT_FIELD = " name,password,salt,head_url ";
    String SELECT_FIELD = "id, " + INSERT_FIELD;

    @Insert({"insert into", TABLE_NAME, "(", INSERT_FIELD,
            ") values(#{name},#{password},#{salt},#{head_url})"})
     int addUser(User user);

    @Select({"select",SELECT_FIELD,"from",TABLE_NAME,"where id =#{id}"})
    User findUserById(@Param("id") int id);
}
