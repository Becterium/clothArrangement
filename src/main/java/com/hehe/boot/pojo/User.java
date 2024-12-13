package com.hehe.boot.pojo;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.hehe.boot.mapper.UserMapper;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor //有参构造器
@NoArgsConstructor  //无参构造器
@TableName("user") // 对应数据库表名
public class User {
    @TableId(value = "id", type = IdType.AUTO) // 自增主键
    private Long id;
    private String username;
    private String password;
}
