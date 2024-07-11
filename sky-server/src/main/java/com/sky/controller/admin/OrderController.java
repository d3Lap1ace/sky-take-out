package com.sky.controller.admin;

import com.sky.dto.*;
import com.sky.mapper.OrderMapper;
import com.sky.result.PageResult;
import com.sky.result.Result;
import com.sky.service.OrderService;
import com.sky.vo.OrderStatisticsVO;
import com.sky.vo.OrderVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @classname sky
 * @Auther d3Lap1ace
 * @Time 11/7/2024 10:54 周四
 * @description
 * @Version 1.0
 * From the Laplace Demon
 */

@RestController("adminOrderController")
@RequestMapping("/admin/order")
@Api(tags = "订单管理接口")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @ApiOperation("订单搜索")
    @GetMapping("/conditionSearch")
    public Result<PageResult> pageSearchOrder(OrdersPageQueryDTO ordersPageQueryDTO){
        PageResult pageResult = orderService.pageSearchOrder(ordersPageQueryDTO);
        return Result.success(pageResult);
    }

    @ApiOperation("各个状态的订单数量统计")
    @GetMapping("/statistics")
    public Result<OrderStatisticsVO> statisticsOrder(){
        OrderStatisticsVO orderStatisticsVO = orderService.statistics();
        return Result.success(orderStatisticsVO);
    }

    @ApiOperation("查询订单详细")
    @GetMapping("details/{id}")
    public Result<OrderVO> detailsById(@PathVariable Long id){
        OrderVO orderVO = orderService.getDetailByid(id);
        return Result.success(orderVO);
    }

    @ApiOperation("接单")
    @PutMapping("/confirm")
    public Result confirm(@RequestBody OrdersConfirmDTO ordersConfirmDTO) {
        orderService.confirm(ordersConfirmDTO);
        return Result.success();
    }

    @PutMapping("/rejection")
    @ApiOperation("拒单")
    public Result rejection(@RequestBody OrdersRejectionDTO ordersRejectionDTO) throws Exception {
        orderService.rejection(ordersRejectionDTO);
        return Result.success();
    }
}
