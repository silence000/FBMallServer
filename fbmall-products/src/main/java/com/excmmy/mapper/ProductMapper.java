package com.excmmy.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.excmmy.bean.Product;
import com.excmmy.pojo.ProductList;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author Excmmy
 * @since 2020-04-17
 */
@Repository
public interface ProductMapper extends BaseMapper<Product> {
    @Select("SELECT * FROM product_list")
    @Results({
            @Result(property = "imgsUrl", column = "id",
                    many = @Many(select = "com.excmmy.mapper.ProductImgsMapper.getOneProductImgById")),
            @Result(property = "id", column = "id")
    })
    public List<ProductList> getProductList(Page<ProductList> page);

    @Select("SELECT * FROM product_list WHERE id = #{id}")
    @Results({
            @Result(property = "imgsUrl", column = "id",
                    many = @Many(select = "com.excmmy.mapper.ProductImgsMapper.getProductImgsById")),
            @Result(property = "id", column = "id")
    })
    public ProductList getProductDetails(@Param("id") Integer id);

    @Select("SELECT * FROM product_list WHERE type = #{type}")
    @Results({
            @Result(property = "imgsUrl", column = "id",
                    many = @Many(select = "com.excmmy.mapper.ProductImgsMapper.getOneProductImgById")),
            @Result(property = "id", column = "id")
    })
    public List<ProductList> getProductListByType(@Param("type") String type);

    @Select("SELECT * FROM product_list WHERE productName LIKE CONCAT('%',#{keyword},'%')")
    @Results({
            @Result(property = "imgsUrl", column = "id",
                    many = @Many(select = "com.excmmy.mapper.ProductImgsMapper.getOneProductImgById")),
            @Result(property = "id", column = "id")
    })
    public List<ProductList> getProductListByKeyword(@Param("keyword") String keyword);
}
