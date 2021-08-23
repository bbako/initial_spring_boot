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

    @GetMapping("/admin")
    public String admin(Model model) throws Exception {
        return "admin";
    }

}

