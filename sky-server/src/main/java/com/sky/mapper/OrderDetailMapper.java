package com.sky.mapper;

import com.sky.entity.OrderDetail;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @classname sky
 * @Auther d3Lap1ace
 * @Time 10/7/2024 20:08 周三
 * @description
 * @Version 1.0
 * From the Laplace Demon
 */
@Mapper
public interface OrderDetailMapper {

    /**
     * 插入订单详细列表
     * @param orderDetailList
     */
    void insetByList(List<OrderDetail> orderDetailList);

    /**
     * 根据orderid获取详解订单
     * @param ordersId
     * @return
     */
    @Select("select * from order_detail where order_id = #{ordersId}")
    List<OrderDetail> getByOrderId(Long ordersId);
}
