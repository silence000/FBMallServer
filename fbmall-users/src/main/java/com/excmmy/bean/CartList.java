package com.excmmy.bean;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * <p>
 * VIEW
 * </p>
 *
 * @author Excmmy
 * @since 2020-04-20
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class CartList implements Serializable {

    private static final long serialVersionUID=1L;

    @TableField("usersId")
    private Long usersId;

    @TableField("productId")
    private Long productId;

    @TableField("productName")
    private String productName;

    private String description;

    private BigDecimal price;

    private BigDecimal numbers;

    private String unit;

    private String imgsUrl;
}
