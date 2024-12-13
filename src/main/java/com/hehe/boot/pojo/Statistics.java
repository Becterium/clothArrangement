package com.hehe.boot.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import com.hehe.boot.mapper.StatisticsMapper;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor //有参构造器
@NoArgsConstructor  //无参构造器
@TableName("statistics") // 对应数据库表名
public class Statistics {
    private Long id;
    private int  userCount;
    private int  operationCount;
    private int  productCount;
    private int  orderCount;
}
