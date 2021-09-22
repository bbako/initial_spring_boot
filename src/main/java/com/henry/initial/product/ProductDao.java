package com.henry.initial.product;

import com.henry.initial.home.CategoryVO;
import lombok.AllArgsConstructor;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class ProductDao {

    private SqlSession sqlSession;

    public void addProduct(ProductVO vo) {
        sqlSession.insert("product.addProduct", vo);
    }

    public List<ProductVO> getProduct(CategoryVO categoryVO) {
        return sqlSession.selectList("product.getProduct",categoryVO);
    }

    public void delProduct(ProductVO vo) {
        sqlSession.delete("product.delProduct", vo);
    }
    public void changeProduct(ProductVO vo) {
        sqlSession.update("product.changeProduct", vo);
    }
}
