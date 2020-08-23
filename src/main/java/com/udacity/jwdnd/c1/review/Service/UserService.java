package com.udacity.jwdnd.c1.review.Service;

import com.udacity.jwdnd.c1.review.Mapper.UserMapper;
import com.udacity.jwdnd.c1.review.Model.User;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.Base64;

@Service
public class UserService {
    private UserMapper userMapper;
    private HashService hashService;

    public UserService(UserMapper userMapper, HashService hashService) {
        this.userMapper = userMapper;
        this.hashService = hashService;
    }

    public boolean isUserPresent(String username) {
        return userMapper.getUser(username) != null;
    }

    public User getUser(String username) {
        return userMapper.getUser(username);
    }

    public int addUser(User user) {
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16];
        random.nextBytes(salt);
        String encodedSalt = Base64.getEncoder().encodeToString(salt);
        String hashedPassword = hashService.getHashedValue(user.getPassword(), encodedSalt);
        return userMapper.insert(new User(null, user.getUsername(), user.getFirstname(), user.getFirstname(), hashedPassword, encodedSalt));
    }
}
