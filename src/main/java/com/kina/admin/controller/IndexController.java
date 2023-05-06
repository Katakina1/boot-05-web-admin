package com.kina.admin.controller;

import com.kina.admin.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

@Controller
public class IndexController {

    @GetMapping(value = {"/"})
    public String loginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String main(User user, HttpSession session, Model model) {
        if(!user.getUserName().isEmpty()) {
            session.setAttribute("loginUser", user);
            return "redirect:main.html";
        } else {
            model.addAttribute("msg", "账号密码错误");
            return "login";
        }

    }

    @GetMapping("/main.html")
    public String mainPage(HttpSession session, Model model) {
        Object loginUser = session.getAttribute("loginUser");
        if (loginUser != null) {
            return "main";
        } else {
            model.addAttribute("msg","请重新登录");
            return "login";
        }

    }

}
