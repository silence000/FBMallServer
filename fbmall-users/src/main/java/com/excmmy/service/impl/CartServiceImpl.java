package com.excmmy.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.excmmy.bean.Cart;
import com.excmmy.mapper.CartMapper;
import com.excmmy.service.CartService;
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
 * @since 2020-04-19
 */
@Service
public class CartServiceImpl extends ServiceImpl<CartMapper, Cart> implements CartService {
    @Autowired
    private CartMapper cartMapper;

    @Override
    public ResponseJsonBody insertCart(Cart cart) {
        ResponseJsonBody responseJsonBody = new ResponseJsonBody();
        QueryWrapper<Cart> cartQueryWrapper = new QueryWrapper<>();
        cartQueryWrapper.eq("usersId", cart.getUsersId());
        cartQueryWrapper.eq("productId", cart.getProductId());
        Cart cartOriginal = cartMapper.selectOne(cartQueryWrapper);
        int flag = 0;
        if (cartOriginal == null) {
            flag = cartMapper.insert(cart);
        } else {
            Cart cartUpdate = new Cart();
            cartUpdate.setId(cartOriginal.getId());
            cartUpdate.setNumbers(cartOriginal.getNumbers().add(cart.getNumbers()));
            flag = cartMapper.updateById(cartUpdate);
        }
        if (flag == 1) {
            responseJsonBody.setCode(MallConstant.SUCCESS_CODE);
            responseJsonBody.setMsg(MallConstant.SUCCESS_DESC);
        } else {
            responseJsonBody.setCode(MallConstant.FAIL_CODE);
            responseJsonBody.setMsg(MallConstant.FAIL_DESC);
        }
        return responseJsonBody;
    }

    @Override
    public ResponseJsonBody deleteCart(Long productId, Long usersId) {
        ResponseJsonBody responseJsonBody = new ResponseJsonBody();
        QueryWrapper<Cart> cartQueryWrapper = new QueryWrapper<>();
        cartQueryWrapper.eq("usersId", usersId);
        cartQueryWrapper.eq("productId", productId);
        Cart cartUpdate = new Cart();
        cartUpdate.setIsDelete(1);
        int flag = cartMapper.update(cartUpdate, cartQueryWrapper);
        if (flag == 1) {
            responseJsonBody.setCode(MallConstant.SUCCESS_CODE);
            responseJsonBody.setMsg(MallConstant.SUCCESS_DESC);
        } else {
            responseJsonBody.setCode(MallConstant.FAIL_CODE);
            responseJsonBody.setMsg(MallConstant.FAIL_DESC);
        }
        return responseJsonBody;
    }

    @Override
    public ResponseJsonBody getProductNumByProductId(Long productId, Long usersId) {
        ResponseJsonBody responseJsonBody = new ResponseJsonBody();
        QueryWrapper<Cart> cartQueryWrapper = new QueryWrapper<>();
        cartQueryWrapper.eq("productId", productId);
        cartQueryWrapper.eq("usersId", usersId);
        Cart cart = cartMapper.selectOne(cartQueryWrapper);
        if (cart != null) {
            responseJsonBody.setCode(MallConstant.SUCCESS_CODE);
            responseJsonBody.setMsg(MallConstant.SUCCESS_DESC);
            responseJsonBody.setData(cart.getNumbers());
        } else {
            responseJsonBody.setCode(MallConstant.FAIL_CODE);
            responseJsonBody.setMsg(MallConstant.FAIL_DESC);
        }
        return responseJsonBody;
    }
}
