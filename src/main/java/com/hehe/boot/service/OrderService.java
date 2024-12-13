package com.hehe.boot.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hehe.boot.mapper.OrderMapper;
import com.hehe.boot.pojo.Order;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class OrderService extends ServiceImpl<OrderMapper, Order> {

    @Autowired
    private OrderMapper orderMapper;


    public IPage<Order> getProPage(int currentPage){
        // 构造分页条件
        Page<Order> page = new Page<>(currentPage, 10);

        // 执行分页查询
        return this.page(page);
    }

    public IPage<Order> getProPageLike(String query,int currentPage) {
        // 构造分页条件
        Page<Order> page = new Page<>(currentPage, 10);

        // 构造查询条件
        QueryWrapper<Order> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("uid", query);

        // 执行分页查询
        return page(page, queryWrapper);
    }

    public boolean insertProduct(Order order) {
        order.setId(0L);
        UUID uniqueKey = UUID.randomUUID();
        order.setUid("ORD" + uniqueKey);
        boolean result = this.save(order);
        return result;
    }

    public boolean updateProduct(Order order) {
        boolean result = this.updateById(order);
        return result;
    }

    public boolean deleteProduct(Order order) {
        boolean result = this.removeById(order.getId());
        return result;
    }

    public List<Map<String, Object>> getSalesStatistics() {
        return orderMapper.getSalesStatistics();
    }

    public List<Map<String, Object>> getSalesByAddress() {
        return orderMapper.getSalesByAddress();
    }

    public List<Map<String, Object>> getTopSalesStatistics() {
        return orderMapper.getTopSalesStatistics();
    }
}
