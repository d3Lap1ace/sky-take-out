package com.sky.mapper;

import com.github.pagehelper.Page;
import com.sky.dto.OrdersPageQueryDTO;
import com.sky.entity.Orders;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * @classname sky
 * @Auther d3Lap1ace
 * @Time 9/7/2024 21:10 周二
 * @description
 * @Version 1.0
 * From the Laplace Demon
 */
@Mapper
public interface OrderMapper {


    void insert(Orders orders);

    /**
     * 分页历史订单查询
     * @param ordersPageQueryDTO
     * @return
     */
    Page<Orders> pageQuery(OrdersPageQueryDTO ordersPageQueryDTO);

    /**
     * 根据id获取订单
     * @param id
     * @return
     */
    @Select("select * from orders where id = #{id}")
    Orders getById(Long id);

    /**
     * 跟新订单
     * @param orders
     */
    @Update("update orders set status = #{status},cancel_reason = #{cancelReaseon},cancel_time = #{cancelTime} where id = #{id}")
    void update(Orders orders);

    /**
     * 查询订单状态的数量
     * @param status
     * @return
     */
    @Select("select count(id) from orders where status = #{status}")
    Integer selectStatistics(Integer status);

    /**
     * 根据订单号查询当前用户的订单
     * @param orderNumber
     * @param userId
     * @return
     */
    @Select("select * from orders where number = #{orderNumber} and user_id = #{userId}")
    Orders getByNumberAndUserId(String orderNumber, Long userId);
}
