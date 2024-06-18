package com.sky.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @classname sky-take-out
 * @Auther d3Lap1ace
 * @Time 18/6/2024 下午10:45 周二
 * @description
 * @Version 1.0
 * From the Laplace Demon
 */

@Mapper
public interface SetmealDishMapper {
    /**
     * 根据菜品id查询对应的套餐id
     *
     * @param dishIds
     * @return
     */
    //select setmeal_id from setmeal_dish where dish_id in (1,2,3,4)
    List<Long> getSetmealIdsByDishIds(List<Long> dishIds);
}
