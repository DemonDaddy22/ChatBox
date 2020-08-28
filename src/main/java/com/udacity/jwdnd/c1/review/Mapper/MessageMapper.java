package com.udacity.jwdnd.c1.review.Mapper;

import com.udacity.jwdnd.c1.review.Model.ChatMessage;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface MessageMapper {
    @Select("SELECT * FROM MESSAGES where username = #{username}")
    List<ChatMessage> getMessages(String username);

    @Insert("INSERT INTO MESSAGES (username, message) VALUES (#{username}, #{message})")
    @Options(useGeneratedKeys = true, keyProperty = "messageId")
    int insert(ChatMessage message);
}