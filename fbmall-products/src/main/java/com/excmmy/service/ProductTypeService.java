package com.excmmy.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.excmmy.bean.ProductType;
import pojo.ResponseJsonBody;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Excmmy
 * @since 2020-04-17
 */
public interface ProductTypeService extends IService<ProductType> {
    public ResponseJsonBody getProductType();
}
