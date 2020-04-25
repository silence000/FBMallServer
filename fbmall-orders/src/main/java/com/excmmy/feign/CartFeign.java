package com.excmmy.feign;

import com.excmmy.feign.Hystrix.CartFeignHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Primary;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import pojo.ResponseJsonBody;

@FeignClient(name = "FBMALL-USERS", fallback = CartFeignHystrix.class)
@Primary
public interface CartFeign {
    @RequestMapping(value = "/user/get/product/num", method = RequestMethod.GET)
    public ResponseJsonBody getProductNumByProductId(
            @RequestParam(name = "productId") Long productId,
            @RequestParam(name = "usersId") Long usersId);

    @RequestMapping(value = "/user/delete/cart", method = RequestMethod.POST)
    public ResponseJsonBody deleteCart(
            @RequestParam(name = "productId") Long productId,
            @RequestParam(name = "usersId") Long usersId);
}
