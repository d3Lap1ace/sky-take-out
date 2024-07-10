package com.sky.mapper;

import com.sky.entity.OrderDetail;
import org.apache.ibatis.annotations.Mapper;

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
    void insetByList(List<OrderDetail> orderDetailList);
}
