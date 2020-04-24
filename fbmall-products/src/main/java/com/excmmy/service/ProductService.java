package com.excmmy.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.excmmy.bean.Product;
import pojo.PageInfo;
import pojo.RequestJsonBody;
import pojo.ResponseJsonBody;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Excmmy
 * @since 2020-04-17
 */
public interface ProductService extends IService<Product> {
    public ResponseJsonBody getProductList(PageInfo pageInfo);
    public ResponseJsonBody getProductDetails(RequestJsonBody requestJsonBody);
    public ResponseJsonBody getProductListByType(String type);
    public ResponseJsonBody getProductListByKeyword(String keyword);
}
