package com.henry.initial.home;

import com.henry.initial.product.ProductVO;
import lombok.AllArgsConstructor;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class HomeDao {

    private SqlSession sqlSession;

    public List<CategoryVO> getCategory() {
        return sqlSession.selectList("home.getCategory");
    }

    public List<CategoryVO> getCategory2(CategoryVO categoryVO) {
        return sqlSession.selectList("home.getCategory2", categoryVO);
    }
}
