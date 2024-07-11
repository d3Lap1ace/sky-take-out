package com.sky.controller.user;

import com.sky.dto.OrdersSubmitDTO;
import com.sky.entity.OrderDetail;
import com.sky.result.PageResult;
import com.sky.result.Result;
import com.sky.service.OrderService;
import com.sky.vo.OrderSubmitVO;
import com.sky.vo.OrderVO;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @classname sky
 * @Auther d3Lap1ace
 * @Time 9/7/2024 21:08 周二
 * @description
 * @Version 1.0
 * From the Laplace Demon
 */

@RestController
@RequestMapping("/user/order")
@Tag(name = "C端-订单接口")
public class OrderController {

    @Autowired
    private OrderService orderServer;


    @ApiOperation("用户下单")
    @PostMapping("/submit")
    public Result<OrderSubmitVO> submit(@RequestBody OrdersSubmitDTO ordersSubmitDTO){
        OrderSubmitVO orderSubmitVO = orderServer.submitOrder(ordersSubmitDTO);
        return Result.success(orderSubmitVO);
    }

    @ApiOperation("历史订单查询")
    @GetMapping("/historyOrders")
    public Result<PageResult> pageHistorOrders(int pageNum, int pageSize, Integer status){
        PageResult pageResult = orderServer.pageQuery4User(pageNum,pageSize,status);
        return Result.success(pageResult);
    }

    @ApiOperation("查询订单详情")
    @GetMapping("orderDetail/{id}")
    public Result<OrderVO> orderDetailById(@PathVariable Integer id ){
        OrderVO orderVO = orderServer.getDetailByid(id);
        return Result.success(orderVO);
    }

    @ApiOperation("取消订单")
    @PutMapping("cancel/{id}")
    public Result cancelById(@PathVariable Integer id){
        orderServer.cancelById(id);
        return Result.success();
    }

    @ApiOperation("再来一单")
    @PostMapping("repetition/{id}")
    public Result repetitionById(@PathVariable Long id){
        orderServer.repetitionById(id);
        return Result.success();
    }
}
