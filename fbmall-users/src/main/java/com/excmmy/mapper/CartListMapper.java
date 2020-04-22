package com.excmmy.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.excmmy.bean.CartList;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * VIEW Mapper 接口
 * </p>
 *
 * @author Excmmy
 * @since 2020-04-20
 */
@Repository
public interface CartListMapper extends BaseMapper<CartList> {
    @Select("SELECT * FROM cart_list WHERE usersId = #{id}")
    @Results({
            @Result(property = "imgsUrl", column = "productId",
                    many = @Many(select = "com.excmmy.mapper.ProductImgsMapper.getOneProductImgById")),
            @Result(property = "usersId", column = "usersId"),
            @Result(property = "productId", column = "productId")
    })
    public List<CartList> getCartListByUserId(@Param("id") Integer id);
}
