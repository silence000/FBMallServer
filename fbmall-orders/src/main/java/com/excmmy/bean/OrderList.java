package com.excmmy.bean;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * <p>
 * VIEW
 * </p>
 *
 * @author Excmmy
 * @since 2020-04-23
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class OrderList implements Serializable {

    private static final long serialVersionUID=1L;

    @TableField("ordersId")
    private Long ordersId;

    @TableField("productId")
    private Long productId;

    private BigDecimal number;

    private Long series;

    @TableField("productName")
    private String productName;

    private String unit;

    private String type;

    private BigDecimal price;

    private String company;

    private String description;

    @TableField(exist = false)
    private String imgUrl;

    private Integer status;
}
