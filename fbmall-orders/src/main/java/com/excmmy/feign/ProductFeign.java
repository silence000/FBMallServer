package com.excmmy.feign;

import com.excmmy.feign.Hystrix.ProductFeignHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Primary;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pojo.ResponseJsonBody;

@FeignClient(name = "FBMALL-PRODUCTS", fallback = ProductFeignHystrix.class)
@Primary
public interface ProductFeign {
    @RequestMapping(value = "/product/get/product_img")
    public ResponseJsonBody getOneProductImgById(@RequestParam(name = "id") Long id);
}
