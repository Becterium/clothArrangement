package com.hehe.boot.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.hehe.boot.pojo.Product;
import com.hehe.boot.pojo.Result;
import com.hehe.boot.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/product")
@CrossOrigin(origins = "*")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/find")
    public Result<IPage<Product>> findall(@RequestParam(required = false) String query,
                                          @RequestParam Integer page){
        if (query != null && !query.isEmpty()) {
            return Result.success(productService.getProPageLike(query,page));
        }
        return Result.success(productService.getProPage(page));
    }

    @PostMapping("/insert")
    public Result insert(@RequestBody Product product){
        System.out.println("sdad   "+product);
        return Result.success(productService.insertProduct(product));
    }

    @PostMapping("/update")
    public Result update(@RequestBody Product product){
        System.out.println("sdad      "+product);
        return Result.success(productService.updateProduct(product));
    }

    @PostMapping("/delete")
    public Result delete(@RequestBody Product product){
        System.out.println("sdad     "+product);
        return Result.success(productService.deleteProduct(product));
    }

    @GetMapping("/dashDate")
    public List<Map<String, Object>> dashDate(){
        return productService.getCategoryStatistics();
    }
}
