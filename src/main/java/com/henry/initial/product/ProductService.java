package com.henry.initial.product;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class ProductService {

    ProductDao productDao;

    public void addProduct(ProductVO vo) {
        productDao.addProduct(vo);
    }

    public List<ProductVO> getProduct() {
        return productDao.getProduct();
    }

    public void delProduct(ProductVO vo) {
        productDao.delProduct(vo);
    }
}
