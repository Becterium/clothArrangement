package com.hehe.boot.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import com.hehe.boot.mapper.OrderMapper;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor //有参构造器
@NoArgsConstructor  //无参构造器
@TableName("orders") // 对应数据库表名
public class Order {
    private Long   id;
    private String uid;
    private Long   productId;
    private int    number;
    private String address;
    private String status;
    private String phone;
    private int month;
}
