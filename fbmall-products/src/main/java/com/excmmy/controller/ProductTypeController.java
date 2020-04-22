package com.excmmy.controller;


import com.excmmy.service.ProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
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
 * @since 2020-04-17
 */
@RestController
public class ProductTypeController {
    @Autowired
    private ProductTypeService productTypeService;

    @RequestMapping(value = "/product/get/sort", method = RequestMethod.POST)
    public ResponseJsonBody getProductType(){
        return productTypeService.getProductType();
    }
}

