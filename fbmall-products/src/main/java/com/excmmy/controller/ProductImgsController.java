package com.excmmy.controller;


import com.excmmy.service.ProductImgsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
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
public class ProductImgsController {
    @Autowired
    private ProductImgsService productImgsService;

    @RequestMapping(value = "/product/get/product_img")
    public ResponseJsonBody getOneProductImgById(@RequestParam(name = "id") Long id) {
        return productImgsService.getOneProductImgById(id);
    }
}

