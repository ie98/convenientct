package com.exmaple.Demo.mapper;

import com.exmaple.Demo.model.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import javax.servlet.http.Cookie;

@Mapper
@Component
public interface UserMapper {
    @Insert("insert into user (account_id,name,token,gmt_create,gmt_modified) values (#{accountId},#{name},#{token},#{gmtCreate},#{gmtModified})")
    void  insert (User user);
    @Update("")
    void  Updadte (User user);
    @Delete("")
    void  Delete (int id);
    @Select("select * from user where token = #{token}")
    User findByToken (@Param("token")  String token);

}
