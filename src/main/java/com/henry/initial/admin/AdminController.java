package com.henry.initial.admin;

import com.henry.initial.product.ProductVO;
import com.henry.initial.user.UserInfoDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@AllArgsConstructor
public class AdminController {

    AdminService adminService;

    @GetMapping("/admin")
    public String admin(Model model) throws Exception {
        return "admin";
    }

    //상품등록
    @PostMapping("/addProduct")
    public String addProductPost(ProductVO vo) {
        adminService.addProduct(vo);
        return "redirect:/admin";
    }

}

