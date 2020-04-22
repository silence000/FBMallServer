package com.excmmy.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.excmmy.bean.CartList;
import pojo.RequestJsonBody;
import pojo.ResponseJsonBody;

/**
 * <p>
 * VIEW 服务类
 * </p>
 *
 * @author Excmmy
 * @since 2020-04-20
 */
public interface CartListService extends IService<CartList> {
    public ResponseJsonBody getCartListByUserId(RequestJsonBody requestJsonBody);
}
