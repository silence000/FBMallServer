package com.excmmy.controller;


import com.excmmy.service.CartListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pojo.RequestJsonBody;
import pojo.ResponseJsonBody;

/**
 * <p>
 * VIEW 前端控制器
 * </p>
 *
 * @author Excmmy
 * @since 2020-04-20
 */
@RestController
public class CartListController {
    @Autowired
    private CartListService cartListService;

    @RequestMapping(value = "/user/get/cart", method = RequestMethod.POST)
    public ResponseJsonBody getCartListByUserId(@RequestBody RequestJsonBody requestJsonBody){
        return cartListService.getCartListByUserId(requestJsonBody);
    }
}

