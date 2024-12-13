package com.hehe.boot.controller;

import com.hehe.boot.pojo.Result;
import com.hehe.boot.pojo.Statistics;
import com.hehe.boot.service.StatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/statistics")
@CrossOrigin(origins = "*")
public class StatisticsController {
    @Autowired
    private StatisticsService statisticsService;

    @GetMapping("/latest")
    public List<Statistics> getLatestStatistics() {
        return statisticsService.getLatestStatistics();
    }
}
