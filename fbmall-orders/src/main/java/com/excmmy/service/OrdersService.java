package com.excmmy.service;

import com.excmmy.bean.Orders;
import com.baomidou.mybatisplus.extension.service.IService;
import com.excmmy.pojo.OrderReceive;
import pojo.ResponseJsonBody;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Excmmy
 * @since 2020-04-20
 */
public interface OrdersService extends IService<Orders> {
    public ResponseJsonBody insertNewOrder(OrderReceive orderReceive);
}
