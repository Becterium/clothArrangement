package com.hehe.boot.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hehe.boot.mapper.ProductMapper;
import com.hehe.boot.pojo.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ProductService extends ServiceImpl<ProductMapper, Product> {

    @Autowired
    private ProductMapper productMapper;

    public IPage<Product> getProPage(int currentPage){
        // 构造分页条件
        Page<Product> page = new Page<>(currentPage, 10);

        // 执行分页查询
        return this.page(page);
    }

    public IPage<Product> getProPageLike(String query,int currentPage) {
        // 构造分页条件
        Page<Product> page = new Page<>(currentPage, 10);

        // 构造查询条件
        QueryWrapper<Product> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("name", query);

        // 执行分页查询
        return page(page, queryWrapper);
    }

    public boolean insertProduct(Product product) {
        product.setId(0L);
        boolean result = this.save(product);
        return result;
    }

    public boolean updateProduct(Product product) {
        boolean result = this.updateById(product);
        return result;
    }

    public boolean deleteProduct(Product product) {
        boolean result = this.removeById(product.getId());
        return result;
    }

    public List<Map<String, Object>> getCategoryStatistics() {
        return productMapper.getCategoryStatistics();
    }
}
