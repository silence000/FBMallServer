package com.excmmy.pojo;

import com.excmmy.bean.ProductImgs;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductList implements Serializable {
    private Long id;
    private Long series;
    private String productName;
    private String unit;
    private String type;
    private BigDecimal price;
    private BigDecimal repertory;
    private String company;
    private String description;
    private List<ProductImgs> imgsUrl;
}
