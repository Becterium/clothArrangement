package com.hehe.boot.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hehe.boot.mapper.OperationMapper;
import com.hehe.boot.pojo.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class OperationService extends ServiceImpl<OperationMapper, Operation> {

    @Autowired
    private OperationMapper operationMapper;

    public boolean insertOperation(String user, String kind) {
        Operation operation = new Operation();
        operation.setId(0L);
        operation.setKind(kind);
        operation.setName(user);
        operation.setTimestamp(LocalDateTime.now());
        return this.save(operation);
    }

    public List<Operation> getTopOperations() {
        return operationMapper.getTopOperations();
    }
}
