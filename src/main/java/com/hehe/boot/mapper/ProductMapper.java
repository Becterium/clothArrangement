package com.hehe.boot.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hehe.boot.pojo.Product;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public interface ProductMapper extends BaseMapper<Product> {
    @Select("SELECT category AS name , COUNT(*) AS value " +
            "FROM products " +
            "GROUP BY category")
    List<Map<String, Object>> getCategoryStatistics();
}
