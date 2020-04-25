package com.excmmy.controller;


import com.excmmy.pojo.OrderReceive;
import com.excmmy.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import pojo.ResponseJsonBody;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Excmmy
 * @since 2020-04-20
 */
@RestController
public class OrdersController {
    @Autowired
    private OrdersService orderService;

    @RequestMapping(value = "/order/hello", method = RequestMethod.GET)
    public String hello() {
        System.out.println("Hello");
        return "Hello";
    }

    @RequestMapping(value = "/order/insert", method = RequestMethod.POST)
    public ResponseJsonBody insertNewOrder(@RequestBody OrderReceive orderReceive) {
        return orderService.insertNewOrder(orderReceive);
    }

    @RequestMapping(value = "/order/get/id", method = RequestMethod.POST)
    public ResponseJsonBody getOrderIdByCustomerId(
            @RequestParam(name = "customerId") Long customerId,
            @RequestParam(name = "status") Integer status) {
        return orderService.getOrderIdByCustomerId(customerId, status);
    }
}

