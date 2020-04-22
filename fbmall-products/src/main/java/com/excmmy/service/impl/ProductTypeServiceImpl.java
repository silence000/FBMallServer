package com.excmmy.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.excmmy.bean.ProductType;
import com.excmmy.mapper.ProductTypeMapper;
import com.excmmy.service.ProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojo.MallConstant;
import pojo.ResponseJsonBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Excmmy
 * @since 2020-04-17
 */
@Service
public class ProductTypeServiceImpl extends ServiceImpl<ProductTypeMapper, ProductType> implements ProductTypeService {
    @Autowired
    private ProductTypeMapper productTypeMapper;

    @Override
    public ResponseJsonBody getProductType() {
        ResponseJsonBody responseJsonBody = new ResponseJsonBody();
        Map<String,Object> queryCondition = new HashMap<>();
        queryCondition.put("isDelete", "0");
        List<ProductType> productTypeList = productTypeMapper.selectByMap(queryCondition);
        if (productTypeList != null) {
            responseJsonBody.setCode(MallConstant.SUCCESS_CODE);
            responseJsonBody.setMsg(MallConstant.SUCCESS_DESC);
            responseJsonBody.setData(productTypeList);
        } else {
            responseJsonBody.setCode(MallConstant.FAIL_CODE);
            responseJsonBody.setMsg(MallConstant.FAIL_DESC);
        }
        return responseJsonBody;
    }
}
