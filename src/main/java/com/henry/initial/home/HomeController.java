package com.henry.initial.home;

import com.henry.initial.product.ProductService;
import com.henry.initial.product.ProductVO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@AllArgsConstructor
public class HomeController {

    HomeService homeService;

    @GetMapping("/")
    public String index(Model model) throws Exception {

        List<CategoryVO> ctgr_list = homeService.getCategory();
        model.addAttribute("ctgr_list",ctgr_list);

        return "test";
    }

    @GetMapping("/about")
    public String about(Model model) throws Exception {
        return "about";
    }

    @GetMapping("/contact")
    public String contact(Model model) throws Exception {
        return "contact";
    }

    @GetMapping("/test")
    public String test(Model model) throws Exception {
        return "test";
    }

    @PostMapping("/getCategory2")
    @ResponseBody
    public List<CategoryVO> getCategory2(Model model, CategoryVO categoryVO) throws Exception {
        return  homeService.getCategory2(categoryVO);
    }


}
