package com.henry.initial.product;

import com.henry.initial.home.CategoryVO;
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

    public List<ProductVO> getProduct(CategoryVO categoryVO) {
        return productDao.getProduct(categoryVO);
    }

    public void delProduct(ProductVO vo) {
        productDao.delProduct(vo);
    }
    public void changeProduct(ProductVO vo) {
        productDao.changeProduct(vo);
    }

}
