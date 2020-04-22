package com.excmmy.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderReceive implements Serializable {
    private Long userId;
    private BigDecimal total;
    private String checkedGoods;
    private String recName;
    private String recPhone;
    private String recAddress;
}
