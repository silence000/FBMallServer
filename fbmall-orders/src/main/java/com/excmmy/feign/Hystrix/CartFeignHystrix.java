package com.excmmy.feign.Hystrix;

import com.excmmy.feign.CartFeign;
import org.springframework.stereotype.Component;
import pojo.MallConstant;
import pojo.ResponseJsonBody;

@Component
public class CartFeignHystrix implements CartFeign {
    @Override
    public ResponseJsonBody getProductNumByProductId(Long productId, Long usersId) {
        System.out.println("执行了备用方法");
        ResponseJsonBody responseJsonBody = new ResponseJsonBody();
        responseJsonBody.setCode(MallConstant.FAIL_CODE_REQUEST_TIMEOUT);
        responseJsonBody.setMsg(MallConstant.FAIL_CODE_REQUEST_TIMEOUT_STRING);
        return responseJsonBody;
    }

    @Override
    public ResponseJsonBody deleteCart(Long productId, Long usersId) {
        System.out.println("执行了备用方法");
        ResponseJsonBody responseJsonBody = new ResponseJsonBody();
        responseJsonBody.setCode(MallConstant.FAIL_CODE_REQUEST_TIMEOUT);
        responseJsonBody.setMsg(MallConstant.FAIL_CODE_REQUEST_TIMEOUT_STRING);
        return responseJsonBody;
    }
}
