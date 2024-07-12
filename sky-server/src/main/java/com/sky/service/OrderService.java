package com.sky.service;

import com.sky.dto.*;
import com.sky.result.PageResult;
import com.sky.vo.OrderPaymentVO;
import com.sky.vo.OrderStatisticsVO;
import com.sky.vo.OrderSubmitVO;
import com.sky.vo.OrderVO;

/**
 * @classname sky
 * @Auther d3Lap1ace
 * @Time 9/7/2024 21:09 周二
 * @description
 * @Version 1.0
 * From the Laplace Demon
 */
public interface OrderService {
    /**
     * 提交订单
     * @param ordersSubmitDTO
     * @return
     */
    OrderSubmitVO submitOrder(OrdersSubmitDTO ordersSubmitDTO);

    /**
     * 分页历史订单查询
     * @param
     * @param pageSize
     * @param status
     * @return
     */
    PageResult pageQuery4User(int pageNum, int pageSize, Integer status);

    /**
     * 根据id获取详细信息
     * @param id
     * @return
     */
    OrderVO getDetailByid(Long id);

    /**
     * 取消订单
     * @param id
     */
    void cancelById(Long id);

    /**
     * 再来一单
     * @param id
     */
    void repetitionById(Long id);

    /**
     * 订单搜索
     * @param ordersPageQueryDTO
     * @return
     */
    PageResult pageSearchOrder(OrdersPageQueryDTO ordersPageQueryDTO);

    /**
     * 各个状态的订单数量统计
     * @return
     */
    OrderStatisticsVO statistics();


    /**
     * 接单
     *
     * @param ordersConfirmDTO
     */
    void confirm(OrdersConfirmDTO ordersConfirmDTO);

    /**
     * 拒单
     *
     * @return
     */
    void rejection(OrdersRejectionDTO ordersRejectionDTO);

    /**
     * 派送订单
     */
    void delioveryById(Long id);

    /**
     * 完成订单
     *
     * @return
     */
    void complete(Long id);

    /**
     * 订单支付
     * @param ordersPaymentDTO
     * @return
     */
    OrderPaymentVO payment(OrdersPaymentDTO ordersPaymentDTO);

    /**
     * 支付成功
     * @param outTradeNo
     */
    void paySuccess(String outTradeNo);
}
