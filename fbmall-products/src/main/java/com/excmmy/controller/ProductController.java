package com.excmmy.controller;


import com.excmmy.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pojo.PageInfo;
import pojo.RequestJsonBody;
import pojo.ResponseJsonBody;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Excmmy
 * @since 2020-04-17
 */
@RestController
public class ProductController {
    @Autowired
    private ProductService productService;

    @RequestMapping(value = "/product/get/list", method = RequestMethod.POST)
    public ResponseJsonBody getProductList(@RequestBody PageInfo pageInfo) {
        return productService.getProductList(pageInfo);
    }

    @RequestMapping(value = "/product/get/detail", method = RequestMethod.POST)
    public ResponseJsonBody getProductDetail(@RequestBody RequestJsonBody requestJsonBody) {
        return productService.getProductDetails(requestJsonBody);
    }

    @RequestMapping(value = "/product/get/cart", method = RequestMethod.POST)
    public ResponseJsonBody getProductListByType(@RequestParam(name = "type") String type) {
        return productService.getProductListByType(type);
    }

    @RequestMapping(value = "/product/search", method = RequestMethod.POST)
    public ResponseJsonBody getProductListByKeyword(@RequestParam(name = "keyword") String keyword){
        return productService.getProductListByKeyword(keyword);
    }
}

