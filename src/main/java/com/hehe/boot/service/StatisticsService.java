package com.hehe.boot.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hehe.boot.mapper.StatisticsMapper;
import com.hehe.boot.pojo.Statistics;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatisticsService extends ServiceImpl<StatisticsMapper, Statistics> {

    @Autowired
    private StatisticsMapper statisticsMapper;

    public List<Statistics> getLatestStatistics() {
        return statisticsMapper.getLatestStatistics();
    }
}
