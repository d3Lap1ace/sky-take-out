package com.sky.mapper;

import com.sky.entity.ShoppingCart;
import org.apache.ibatis.annotations.*;


import java.util.List;

/**
 * @classname sky-take-out
 * @Auther d3Lap1ace
 * @Time 7/7/2024 19:13 周日
 * @description
 * @Version 1.0
 * From the Laplace Demon
 */

@Mapper
public interface ShoppingCartMapper {

    /**
     * 条件查询
     *
     * @param shoppingCart
     * @return
     */
    List<ShoppingCart> list(ShoppingCart shoppingCart);


    /**
     * 更新商品数量
     *
     * @param shoppingCart
     */
    @Update("update shopping_cart set number = #{number} where id = #{id}")
    void updateNumberById(ShoppingCart shoppingCart);


    /**
     * 插入购物车数据
     *
     * @param shoppingCart
     */
    void insert(ShoppingCart shoppingCart);


    /**
     * 清空购物车
     * @param currentId
     */
    @Delete("delete from shopping_cart where user_id = #{userId}")
    void deleteByUserId(Long currentId);
}
