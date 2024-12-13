package com.hehe.boot.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hehe.boot.pojo.Operation;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface OperationMapper extends BaseMapper<Operation> {
    @Select("SELECT * FROM operations ORDER BY id DESC LIMIT 5")
    List<Operation> getTopOperations();
}
