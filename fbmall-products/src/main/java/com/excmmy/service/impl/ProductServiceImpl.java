package com.excmmy.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.excmmy.bean.Product;
import com.excmmy.mapper.ProductMapper;
import com.excmmy.pojo.ProductList;
import com.excmmy.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojo.MallConstant;
import pojo.PageInfo;
import pojo.RequestJsonBody;
import pojo.ResponseJsonBody;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Excmmy
 * @since 2020-04-17
 */
@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements ProductService {
    @Autowired
    private ProductMapper productMapper;

    @Override
    public ResponseJsonBody getProductList(PageInfo pageInfo) {
        ResponseJsonBody responseJsonBody = new ResponseJsonBody();
        Page<ProductList> page = new Page<>(pageInfo.getCurrent(), pageInfo.getSize());
        List<ProductList> productLists = productMapper.getProductList(page);
        PageInfo pageInfoResult = new PageInfo();
        pageInfoResult.setCurrentPage((int) page.getCurrent());
        pageInfoResult.setPages((int) page.getPages());
        pageInfoResult.setPageSize((int) page.getSize());
        pageInfoResult.setTotal((int) page.getTotal());
        if (productLists != null) {
            responseJsonBody.setCode(MallConstant.SUCCESS_CODE);
            responseJsonBody.setMsg(MallConstant.SUCCESS_DESC);
            responseJsonBody.setData(productLists);
            responseJsonBody.setExtra(pageInfoResult);
        } else {
            responseJsonBody.setCode(MallConstant.FAIL_CODE);
            responseJsonBody.setMsg(MallConstant.FAIL_DESC);
        }
        return responseJsonBody;
    }

    @Override
    public ResponseJsonBody getProductDetails(RequestJsonBody requestJsonBody) {
        ResponseJsonBody responseJsonBody = new ResponseJsonBody();
        ProductList productContent = productMapper.getProductDetails(requestJsonBody.getNumber());
        if (productContent != null) {
            responseJsonBody.setCode(MallConstant.SUCCESS_CODE);
            responseJsonBody.setMsg(MallConstant.SUCCESS_DESC);
            responseJsonBody.setData(productContent);
        } else {
            responseJsonBody.setCode(MallConstant.FAIL_CODE);
            responseJsonBody.setMsg(MallConstant.FAIL_DESC);
        }
        return responseJsonBody;
    }

    @Override
    public ResponseJsonBody getProductListByType(String type) {
        ResponseJsonBody responseJsonBody = new ResponseJsonBody();
        List<ProductList> productLists = productMapper.getProductListByType(type);
        if (productLists != null) {
            responseJsonBody.setCode(MallConstant.SUCCESS_CODE);
            responseJsonBody.setMsg(MallConstant.SUCCESS_DESC);
            responseJsonBody.setData(productLists);
        } else {
            responseJsonBody.setCode(MallConstant.FAIL_CODE);
            responseJsonBody.setMsg(MallConstant.FAIL_DESC);
        }
        return responseJsonBody;
    }

    @Override
    public ResponseJsonBody getProductListByKeyword(String keyword) {
        ResponseJsonBody responseJsonBody = new ResponseJsonBody();
        if (keyword != null) {
            List<ProductList> productLists = productMapper.getProductListByKeyword(keyword);
            responseJsonBody.setCode(MallConstant.SUCCESS_CODE);
            responseJsonBody.setMsg(MallConstant.SUCCESS_DESC);
            responseJsonBody.setData(productLists);
        } else {
            responseJsonBody.setCode(MallConstant.FAIL_CODE);
            responseJsonBody.setMsg(MallConstant.FAIL_DESC);
        }
        return responseJsonBody;
    }
}
