package com.hehe.boot.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hehe.boot.pojo.User;
import org.springframework.stereotype.Component;

@Component
public interface UserMapper extends BaseMapper<User> {
    //所有的crud都编写完成了
}