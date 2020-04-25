package com.excmmy.controller;


import com.excmmy.bean.Cart;
import com.excmmy.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pojo.MallConstant;
import pojo.ResponseJsonBody;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Excmmy
 * @since 2020-04-19
 */
@RestController
public class CartController {
    @Autowired
    private CartService cartService;

    @RequestMapping(value = "/user/insert/cart", method = RequestMethod.POST)
    public ResponseJsonBody insertCart(@RequestBody Cart cart){
        return cartService.insertCart(cart);
    }

    @RequestMapping(value = "/user/delete/cart", method = RequestMethod.POST)
    public ResponseJsonBody deleteCart(
            @RequestParam(name = "productId") Long productId,
            @RequestParam(name = "usersId") Long usersId) {
        return cartService.deleteCart(productId, usersId);
    }

    @RequestMapping(value = "/user/get/product/num", method = RequestMethod.GET)
    public ResponseJsonBody getProductNumByProductId(
            @RequestParam(name = "productId") Long productId,
            @RequestParam(name = "usersId") Long usersId) {
        return cartService.getProductNumByProductId(productId, usersId);
    }
}

