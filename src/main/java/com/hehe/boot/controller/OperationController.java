package com.hehe.boot.controller;

import com.hehe.boot.pojo.OpDate;
import com.hehe.boot.pojo.Operation;
import com.hehe.boot.pojo.Result;
import com.hehe.boot.service.OperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/operate")
@CrossOrigin(origins = "*")
public class OperationController {
    @Autowired
    private OperationService operationService;

    @GetMapping("/insert")
    public Result insert(@RequestParam String username,
                         @RequestParam String kind){
        return Result.success(operationService.insertOperation(username,kind));
    }

    @GetMapping("/topOp")
    public List<OpDate> getTopOperations() {
        List<Operation> topOperations = operationService.getTopOperations();
        List<OpDate> dates = new ArrayList<>();
        dates.clear();
        for (Operation op:topOperations) {
            if (op.getKind().equals("star")){
                OpDate date = new OpDate();
                date.setKind("收藏商品");
                date.setCommend(op.getName()+"收藏了你的商品");
                date.setTime(op.getTimeInterval(op.getTimestamp())+"前");
                dates.add(date);
            }if (op.getKind().equals("comment")){
                OpDate date = new OpDate();
                date.setKind("用户评价");
                date.setCommend(op.getName()+"对你的商品进行了评价，快去看看吧");
                date.setTime(op.getTimeInterval(op.getTimestamp())+"前");
                dates.add(date);
            }if (op.getKind().equals("order")){
                OpDate date = new OpDate();
                date.setKind("订单提交");
                date.setCommend(op.getName()+"提交了订单，准备收钱吧");
                date.setTime(op.getTimeInterval(op.getTimestamp())+"前");
                dates.add(date);
            }if (op.getKind().equals("reject")){
                OpDate date = new OpDate();
                date.setKind("退款申请");
                date.setCommend(op.getName()+"申请了仅退款，又要亏钱了");
                date.setTime(op.getTimeInterval(op.getTimestamp())+"前");
                dates.add(date);
            }
//            else{
//                OpDate date = new OpDate();
//                date.setKind("未知操作");
//                date.setCommend("收到了未知操作呢");
//                dates.add(date);
//            }
        }
        return dates;
    }
}
