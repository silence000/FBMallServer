package com.excmmy.bean;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
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
public class Orders implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @TableField(value = "gmtCreate", fill = FieldFill.INSERT)
    private Date gmtCreate;

    @TableField(value = "gmtModified", fill = FieldFill.UPDATE)
    private Date gmtModified;

    @TableField("isDelete")
    private Integer isDelete;

    private Long series;

    @TableField("customerId")
    private Long customerId;

    private BigDecimal total;

    @TableField("createDate")
    private Date createDate;

    @TableField("recName")
    private String recName;

    @TableField("recPhone")
    private String recPhone;

    @TableField("recAddress")
    private String recAddress;

    private String remarks;

    private Integer type;

    private Integer status;


}
