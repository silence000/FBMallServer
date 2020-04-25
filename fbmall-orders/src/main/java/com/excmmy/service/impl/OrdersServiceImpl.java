package com.excmmy.service.impl;

import com.excmmy.bean.OrderList;
import com.excmmy.bean.Orders;
import com.excmmy.bean.OrdersContent;
import com.excmmy.feign.CartFeign;
import com.excmmy.feign.ProductFeign;
import com.excmmy.mapper.OrderListMapper;
import com.excmmy.mapper.OrdersContentMapper;
import com.excmmy.mapper.OrdersMapper;
import com.excmmy.pojo.OrderReceive;
import com.excmmy.service.OrdersService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pojo.MallConstant;
import pojo.ResponseJsonBody;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Excmmy
 * @since 2020-04-20
 */
@Service
public class OrdersServiceImpl extends ServiceImpl<OrdersMapper, Orders> implements OrdersService {

    @Autowired
    private OrdersMapper ordersMapper;
    @Autowired
    private OrderListMapper orderListMapper;
    @Autowired
    private OrdersContentMapper ordersContentMapper;
    @Autowired
    private CartFeign cartFeign;
    @Autowired
    private ProductFeign productFeign;

    @Override
    @Transactional
    public ResponseJsonBody insertNewOrder(OrderReceive orderReceive) {
        ResponseJsonBody responseJsonBody = new ResponseJsonBody();
        Orders newOrders = new Orders();
        newOrders.setSeries(ordersMapper.getNewestOrderInfo() + 1);
        newOrders.setCustomerId(orderReceive.getUserId());
        newOrders.setTotal(orderReceive.getTotal());
        newOrders.setCreateDate(new Date());
        newOrders.setRecName(orderReceive.getRecName());
        newOrders.setRecPhone(orderReceive.getRecPhone());
        newOrders.setRecAddress(orderReceive.getRecAddress());
        newOrders.setType(1);
        newOrders.setStatus(1);
        int flag = ordersMapper.insert(newOrders);
        String[] goodsIdList = orderReceive.getCheckedGoods().split(",");
        for (String goodsId : goodsIdList) {
            OrdersContent ordersContent = new OrdersContent();
            ordersContent.setOrdersId(newOrders.getId());
            ordersContent.setProductId(Long.valueOf(goodsId));
            ResponseJsonBody cartFeignResp1 = cartFeign.getProductNumByProductId(Long.valueOf(goodsId), orderReceive.getUserId());
            if (cartFeignResp1.getCode() == 1) {
                ordersContent.setNumber(new BigDecimal(String.valueOf(cartFeignResp1.getData())));
            } else {
                responseJsonBody.setCode(MallConstant.FAIL_CODE);
                responseJsonBody.setMsg(MallConstant.FAIL_DESC);
                return responseJsonBody;
            }
            ordersContentMapper.insert(ordersContent);
            ResponseJsonBody cartFeignResp2 = cartFeign.deleteCart(Long.valueOf(goodsId), orderReceive.getUserId());
            if (cartFeignResp2.getCode() != 1) {
                responseJsonBody.setCode(MallConstant.FAIL_CODE);
                responseJsonBody.setMsg(MallConstant.FAIL_DESC);
                return responseJsonBody;
            }
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
    public ResponseJsonBody getOrderIdByCustomerId(Long customerId, Integer status) {
        ResponseJsonBody responseJsonBody = new ResponseJsonBody();
        Map<String,Object> condition = new HashMap<>();
        condition.put("customerId", customerId);
        List<Orders> ordersList = ordersMapper.selectByMap(condition);
        List<OrderList> orderListContent = null;
        if (ordersList != null) {
            Long[] ordersId = new Long[ordersList.size()];
            for (int i = 0; i < ordersId.length; i++) {
                ordersId[i] = ordersList.get(i).getId();
                Map<String,Object> condition2 = new HashMap<>();
                condition2.put("ordersId", ordersId[i]);
                if (status != 0) {
                    condition2.put("status", status);
                }
                List<OrderList> orderListContentTemp = orderListMapper.selectByMap(condition2);
                if (orderListContentTemp != null) {
                    for (OrderList orderListContentTempUnit : orderListContentTemp) {
                        ResponseJsonBody responseJsonBodyRec = productFeign.getOneProductImgById(orderListContentTempUnit.getProductId());
                        if (responseJsonBodyRec.getCode() == MallConstant.SUCCESS_CODE) {
                            orderListContentTempUnit.setImgUrl(responseJsonBodyRec.getData() + "");
                        } else {
                            responseJsonBody.setCode(MallConstant.FAIL_CODE);
                            responseJsonBody.setMsg(MallConstant.FAIL_DESC);
                            return responseJsonBody;
                        }
                    }
                }
                if (orderListContent == null) {
                    orderListContent = orderListContentTemp;
                    continue;
                }
                if (orderListContentTemp != null) {
                    orderListContent.addAll(orderListContentTemp);
                }
            }
            responseJsonBody.setCode(MallConstant.SUCCESS_CODE);
            responseJsonBody.setMsg(MallConstant.SUCCESS_DESC);
            responseJsonBody.setData(orderListContent);
        } else {
            responseJsonBody.setCode(MallConstant.FAIL_CODE);
            responseJsonBody.setMsg(MallConstant.FAIL_DESC);
        }

        return responseJsonBody;
    }
}
