package com.henry.initial.admin;

import com.henry.initial.product.ProductVO;
import lombok.AllArgsConstructor;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class AdminDao {

    private SqlSession sqlSession;

    public void addProduct(ProductVO vo) {
        sqlSession.insert("admin.addProduct", vo);
    }

}
