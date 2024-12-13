package com.hehe.boot.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import com.hehe.boot.mapper.ProductMapper;
import com.hehe.boot.service.OperationService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor //有参构造器
@NoArgsConstructor  //无参构造器
@TableName("products") // 对应数据库表名
public class Product {
    private Long   id;
    private String name;
    private int    price;
    private int    stock;
    private int    quality;
    private String color;
    private String description;
    private String imageUrl;
    private String category;
}
