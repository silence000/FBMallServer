package com.excmmy.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.excmmy.bean.ProductImgs;
import com.excmmy.mapper.ProductImgsMapper;
import com.excmmy.service.ProductImgsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojo.MallConstant;
import pojo.ResponseJsonBody;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Excmmy
 * @since 2020-04-17
 */
@Service
public class ProductImgsServiceImpl extends ServiceImpl<ProductImgsMapper, ProductImgs> implements ProductImgsService {
    @Autowired
    private ProductImgsMapper productImgsMapper;

    @Override
    public ResponseJsonBody getOneProductImgById(Long id) {
        ResponseJsonBody responseJsonBody = new ResponseJsonBody();
        String imgUrl = productImgsMapper.getOneProductImgById(id);
        if (imgUrl != null) {
            responseJsonBody.setCode(MallConstant.SUCCESS_CODE);
            responseJsonBody.setMsg(MallConstant.SUCCESS_DESC);
            responseJsonBody.setData(imgUrl);
        } else {
            responseJsonBody.setCode(MallConstant.FAIL_CODE);
            responseJsonBody.setMsg(MallConstant.FAIL_DESC);
        }
        return responseJsonBody;
    }
}
