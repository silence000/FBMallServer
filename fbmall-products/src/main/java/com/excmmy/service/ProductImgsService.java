package com.excmmy.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.excmmy.bean.ProductImgs;
import pojo.ResponseJsonBody;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Excmmy
 * @since 2020-04-17
 */
public interface ProductImgsService extends IService<ProductImgs> {
    public ResponseJsonBody getOneProductImgById(Long id);
}
