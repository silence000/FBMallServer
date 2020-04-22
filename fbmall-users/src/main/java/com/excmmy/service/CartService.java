package com.excmmy.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.excmmy.bean.Cart;
import pojo.ResponseJsonBody;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Excmmy
 * @since 2020-04-19
 */
public interface CartService extends IService<Cart> {
    public ResponseJsonBody insertCart(Cart cart);
    public ResponseJsonBody deleteCart(Long productId, Long usersId);
    public ResponseJsonBody getProductNumByProductId(Long productId, Long usersId);
}
