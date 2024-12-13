package com.hehe.boot.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hehe.boot.pojo.Order;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public interface OrderMapper extends BaseMapper<Order> {


    @Select("SELECT " +
            "o.month, " +
            "SUM(CASE WHEN p.quality = 1 THEN o.number ELSE 0 END) AS quality_1_sales, " +
            "SUM(CASE WHEN p.quality = 2 THEN o.number ELSE 0 END) AS quality_2_sales " +
            "FROM orders o " +
            "JOIN products p ON o.product_id = p.id " +
            "GROUP BY o.month " +
            "ORDER BY o.month")
    List<Map<String, Object>> getSalesStatistics();

    @Select("SELECT address, SUM(number) AS total_sales " +
            "FROM orders " +
            "GROUP BY address")
    List<Map<String, Object>> getSalesByAddress();

    @Select("SELECT p.category, SUM(o.number) AS total_sales " +
            "FROM orders o " +
            "JOIN products p ON o.product_id = p.id " +
            "GROUP BY p.id, p.name, p.category " +
            "ORDER BY total_sales DESC " +
            "LIMIT 5")
    List<Map<String, Object>> getTopSalesStatistics();
}
