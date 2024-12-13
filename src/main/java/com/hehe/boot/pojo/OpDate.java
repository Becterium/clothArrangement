package com.hehe.boot.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor //有参构造器
@NoArgsConstructor  //无参构造器
public class OpDate {
    String kind;
    String commend;
    String time;
}