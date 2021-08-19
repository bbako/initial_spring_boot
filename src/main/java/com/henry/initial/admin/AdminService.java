package com.henry.initial.admin;

import com.henry.initial.product.ProductVO;
import com.henry.initial.user.UserDao;
import com.henry.initial.user.UserInfo;
import com.henry.initial.user.UserInfoDto;
import com.henry.initial.user.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class AdminService{

    AdminDao adminDao;

    public void addProduct(ProductVO vo) {
        adminDao.addProduct(vo);
    }

}
