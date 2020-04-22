package com.excmmy.controller;


import com.excmmy.pojo.OrderReceive;
import com.excmmy.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
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
    public String welcome() {
        System.out.println("成功访问到了FBMall-OrdersServer后台");
        return "hello to FBMall-OrdersServer";
    }

    @RequestMapping(value = "/order/insert", method = RequestMethod.POST)
    public ResponseJsonBody insertNewOrder(@RequestBody OrderReceive orderReceive){
        return orderService.insertNewOrder(orderReceive);
    }


}

