package com.udacity.jwdnd.c1.review.Mapper;

import com.udacity.jwdnd.c1.review.Model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {
    @Select("SELECT * FROM USERS WHERE userId = #{userId}")
    User getUser(int userId);

    @Insert("INSERT INTO USERS (username, firstname, lastname, password, salt) VALUES (#{username}, #{firstname}, #{lastname}, #{password}, #{salt})")
    @Options(useGeneratedKeys = true, keyProperty = "userId")
    int insert(User user);
}