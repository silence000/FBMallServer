package com.excmmy.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.excmmy.bean.CartList;
import com.excmmy.mapper.CartListMapper;
import com.excmmy.service.CartListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojo.MallConstant;
import pojo.RequestJsonBody;
import pojo.ResponseJsonBody;

import java.util.List;

/**
 * <p>
 * VIEW 服务实现类
 * </p>
 *
 * @author Excmmy
 * @since 2020-04-20
 */
@Service
public class CartListServiceImpl extends ServiceImpl<CartListMapper, CartList> implements CartListService {
    @Autowired
    private CartListMapper cartListMapper;

    @Override
    public ResponseJsonBody getCartListByUserId(RequestJsonBody requestJsonBody) {
        ResponseJsonBody responseJsonBody = new ResponseJsonBody();
        List<CartList> cartList= cartListMapper.getCartListByUserId(requestJsonBody.getNumber());
        if (cartList != null) {
            responseJsonBody.setCode(MallConstant.SUCCESS_CODE);
            responseJsonBody.setMsg(MallConstant.SUCCESS_DESC);
            responseJsonBody.setData(cartList);
        } else {
            responseJsonBody.setCode(MallConstant.FAIL_CODE);
            responseJsonBody.setMsg(MallConstant.FAIL_DESC);
        }
        return responseJsonBody;
    }
}
