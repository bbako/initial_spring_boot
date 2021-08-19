package com.henry.initial.home;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@AllArgsConstructor
public class HomeController {

    @GetMapping("/")
    public String index(Model model) throws Exception {
        return "index";
    }

    @GetMapping("/admin")
    public String admin(Model model) throws Exception {
        return "admin";
    }

}
