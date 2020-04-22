package com.excmmy.mapper;

import com.excmmy.bean.Orders;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Excmmy
 * @since 2020-04-20
 */
@Repository
public interface OrdersMapper extends BaseMapper<Orders> {
    @Select("SELECT series FROM `orders` WHERE id = (SELECT max(id) FROM `orders`)")
    public Long getNewestOrderInfo();
}
