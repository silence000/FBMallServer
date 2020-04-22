package com.excmmy.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.excmmy.bean.ProductImgs;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Excmmy
 * @since 2020-04-17
 */
public interface ProductImgsMapper extends BaseMapper<ProductImgs> {
    @Select("SELECT imgUrl FROM product_imgs WHERE productID = #{productID} LIMIT 0,1")
    public String getOneProductImgById(@Param("productID") Integer productID);

    @Select("SELECT imgUrl FROM product_imgs WHERE productID = #{productID}")
    public List<String> getProductImgsById(@Param("productID") Integer productID);
}
