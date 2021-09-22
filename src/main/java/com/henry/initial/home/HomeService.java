package com.henry.initial.home;

import com.henry.initial.product.ProductDao;
import com.henry.initial.product.ProductVO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class HomeService {

    HomeDao homeDao;

    public List<CategoryVO> getCategory() {
        return homeDao.getCategory();
    }

    public List<CategoryVO> getCategory2(CategoryVO categoryVO) {
        return homeDao.getCategory2(categoryVO);
    }

    public void regiEsti(EstimateVO estimateVO) {
        homeDao.regiEsti(estimateVO);
    }

    public List<EstimateVO> getEsti() {
        return homeDao.getEsti();
    }

    public EstimateVO showContents(EstimateVO estimateVO) {
        return homeDao.showContents(estimateVO);
    }

    public void modiEsti(EstimateVO estimateVO) {
        homeDao.modiEsti(estimateVO);
    }
}
