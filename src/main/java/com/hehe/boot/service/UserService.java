package com.hehe.boot.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hehe.boot.mapper.UserMapper;
import com.hehe.boot.pojo.User;
import org.springframework.stereotype.Service;

@Service
public class UserService extends ServiceImpl<UserMapper, User> {

    public User findUsersByName(String username) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username",username);

        return this.getOne(queryWrapper);
    }

    public boolean registerUser(User user) {

        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", user.getUsername());
        User existingUser = this.getOne(queryWrapper);

        if (existingUser != null) {
            // 用户名已存在
            return false;
        }

        return this.save(user);
    }
}