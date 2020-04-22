package com.excmmy.bean;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * <p>
 * 
 * </p>
 *
 * @author Excmmy
 * @since 2020-04-19
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Cart implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @TableField(value = "gmtCreate", fill = FieldFill.INSERT)
    private Date gmtCreate;

    @TableField(value = "gmtModified", fill = FieldFill.UPDATE)
    private Date gmtModified;

    @TableField("isDelete")
    private Integer isDelete;

    @TableField("usersId")
    private Long usersId;

    @TableField("productId")
    private Long productId;

    private BigDecimal numbers;


}
