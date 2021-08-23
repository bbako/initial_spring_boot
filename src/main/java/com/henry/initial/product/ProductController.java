package com.henry.initial.product;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.List;

@Controller
@AllArgsConstructor
public class ProductController {

    ProductService productService;

    @PostMapping("/addProduct")
    @ResponseBody
    public String addProduct(Model model, ProductVO productVO) throws Exception {
        productService.addProduct(productVO);
        return "test";
    }

    @PostMapping("/getProduct")
    @ResponseBody
    public List<ProductVO> getProduct(Model model) throws Exception {
        return  productService.getProduct();
    }

    @PostMapping("/delProduct")
    @ResponseBody
    public String delProduct(Model model, ProductVO productVO) throws Exception {
        productService.delProduct(productVO);
        return "test";
    }

}
