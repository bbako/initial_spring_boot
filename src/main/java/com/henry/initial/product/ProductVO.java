package com.henry.initial.product;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ProductVO {
    private Integer productId;
    private String productName;
    private String productComment;
    private String fileName;
    private String filePath;

    public ProductVO(String productName, String productComment , String fileName, String filePath){
        this.productName = productName;
        this.productComment = productComment;
        this.fileName = fileName;
        this.filePath = filePath;
    }
}
