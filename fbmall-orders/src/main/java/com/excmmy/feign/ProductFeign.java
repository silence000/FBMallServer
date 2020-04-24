package com.excmmy.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pojo.ResponseJsonBody;

@FeignClient(name = "FBMALL-PRODUCTS")
public interface ProductFeign {
    @RequestMapping(value = "/product/get/product_img")
    public ResponseJsonBody getOneProductImgById(@RequestParam(name = "id") Long id);
}
