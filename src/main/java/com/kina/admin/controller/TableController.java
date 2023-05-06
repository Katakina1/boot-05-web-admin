package com.kina.admin.controller;

import com.kina.admin.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;
import java.util.List;

@Controller
public class TableController {

    @GetMapping("/basic_table")
    public String basic_table() {
        return "table/basic_table";
    }
    @GetMapping("/dynamic_table")
    public String dynamic_table(Model model) {
        List<User> userList = Arrays.asList(new User("zhangsan", "123456"), new User("lisi", "123456"),
                new User("haha", "123456"),
                new User("hehe", "123456"));
        model.addAttribute("users", userList);
        return "table/dynamic_table";
    }
    @GetMapping("/responsive_table")
    public String responsive_table() {
        return "/table/responsive_table";
    }
    @GetMapping("/editable_table")
    public String editable_table() {
        return "/table/editable_table";
    }

}
