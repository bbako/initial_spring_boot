package com.henry.initial.user;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RequiredArgsConstructor
@Controller
public class UserController {

    private final UserService userService;

    @PostMapping("/user")
    public String user(UserInfoDto infoDto) { // 회원 추가
        userService.save(infoDto);
        return "redirect:/login";
    }

    @PostMapping("/userAjax")
    public String userAjax(Model model, UserInfoDto infoDto) {
        userService.save(infoDto);
        //user info
        List<UserInfo> userList = userService.getUserList();
        model.addAttribute("userList", userList);
        return "admin::#tabmenu_02";
    }

    @GetMapping(value = "/logout")
    public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
        new SecurityContextLogoutHandler().logout(request, response, SecurityContextHolder.getContext().getAuthentication());
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String login(Model model) throws Exception {
        return "login";
    }

    @GetMapping("/userenabled/{userId}")
    public String userenabled(@PathVariable("userId") String userId, Model model) {
        userService.makeUserEnabled(userId);
        return "redirect:/admin";
    }

    @GetMapping("/userdel/{no}")
    public String userdel(@PathVariable("no") int no, Model model) {
        userService.delUser(no);
        return "redirect:/admin";
    }
}
