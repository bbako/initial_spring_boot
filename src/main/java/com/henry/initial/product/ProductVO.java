package com.henry.initial.product;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ProductVO {
    private Integer prdctId;
    private Integer ctgrId;
    private String prdctName;
    private String prdctInfo;
    private String prdctImg;
    private Integer prdctOrder;
    private String ctgrName;
    private String upperCtgrName;
}
