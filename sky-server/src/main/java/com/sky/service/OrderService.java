package com.sky.service;

import com.sky.dto.OrdersSubmitDTO;
import com.sky.vo.OrderSubmitVO;

/**
 * @classname sky
 * @Auther d3Lap1ace
 * @Time 9/7/2024 21:09 周二
 * @description
 * @Version 1.0
 * From the Laplace Demon
 */
public interface OrderService {
    OrderSubmitVO submitOrder(OrdersSubmitDTO ordersSubmitDTO);
}
