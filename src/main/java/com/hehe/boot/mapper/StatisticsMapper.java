package com.hehe.boot.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hehe.boot.pojo.Statistics;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface StatisticsMapper extends BaseMapper<Statistics> {

    @Select("SELECT * FROM statistics ORDER BY id DESC LIMIT 1")
    List<Statistics> getLatestStatistics();
}
