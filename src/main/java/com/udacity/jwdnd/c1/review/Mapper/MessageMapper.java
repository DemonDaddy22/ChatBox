package com.udacity.jwdnd.c1.review.Mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.logging.log4j.message.Message;

import java.util.List;

@Mapper
public interface MessageMapper {
    @Select("SELECT * FROM MESSAGES WHERE username = #{username}")
    List<Message> getMessage(String username);

    @Insert("INSERT INTO MESSAGES (username, message) VALUES (#{username}, #{message})")
    @Options(useGeneratedKeys = true, keyProperty = "messageId")
    int insert(Message message);
}