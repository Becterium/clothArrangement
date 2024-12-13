package com.hehe.boot.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.hehe.boot.pojo.Order;
import com.hehe.boot.pojo.Result;
import com.hehe.boot.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/order")
@CrossOrigin(origins = "*")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping("/find")
    public Result<IPage<Order>> findall(@RequestParam(required = false) String query,
                                        @RequestParam Integer page){
        if (query != null && !query.isEmpty()) {
            return Result.success(orderService.getProPageLike(query,page));
        }
        return Result.success(orderService.getProPage(page));
    }

    @PostMapping("/insert")
    public Result insert(@RequestBody Order order){
        System.out.println("sdad   "+order);
        return Result.success(orderService.insertProduct(order));
    }

    @PostMapping("/update")
    public Result update(@RequestBody Order order){
        System.out.println("sdad      "+order);
        return Result.success(orderService.updateProduct(order));
    }

    @PostMapping("/delete")
    public Result delete(@RequestBody Order order){
        System.out.println("sdad     "+order);
        return Result.success(orderService.deleteProduct(order));
    }

    @GetMapping("/dashDate")
    public int[][] dashDate(){
        List<Map<String, Object>> salesStatistics = orderService.getSalesStatistics();

        // 初始化二维数组
        int[][] salesArray = new int[2][12];

        // 遍历 List<Map<String, Object>>
        for (Map<String, Object> record : salesStatistics) {
            int month = (int) record.get("month");

            BigDecimal quality1Sales = (BigDecimal) record.get("quality_1_sales");
            BigDecimal quality2Sales = (BigDecimal) record.get("quality_2_sales");

            // 将数据填入对应的二维数组中
            salesArray[0][month - 1] = quality1Sales.intValue();
            salesArray[1][month - 1] = quality2Sales.intValue();
        }
        return salesArray;

    }

    @GetMapping("/saleAddress")
    public List<Map<String, Object>> getSalesByAddress() {
        return orderService.getSalesByAddress();
    }

    @GetMapping("/topSales")
    public List<Map<String, Object>> getTopSalesStatistics() {
        List<Map<String, Object>> salesStatistics = orderService.getTopSalesStatistics();

        Map<String, Object> map = salesStatistics.get(0);
        BigDecimal num = (BigDecimal) map.get("total_sales");

        // 在每个Map中添加num参数
        for (int i = 0; i < salesStatistics.size(); i++) {
            Map<String, Object> entry = salesStatistics.get(i);
            entry.put("div", num.intValue()/100);  // 这里假设num是一个递增的序号
        }

        return salesStatistics;
    }
}
