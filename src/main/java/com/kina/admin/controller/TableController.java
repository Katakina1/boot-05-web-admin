package com.kina.admin.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.kina.admin.bean.User;
import com.kina.admin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Arrays;
import java.util.List;

@Controller
public class TableController {

    @Autowired
    UserService userService;

    @GetMapping("/user/delete/{id}")
    public String deleteUser(@PathVariable("id") Long id,
                             @RequestParam(value = "pn", defaultValue = "1") Integer pn,
                             RedirectAttributes ra) {
        userService.removeById(id);
        ra.addAttribute("pn", pn);
        return "redirect:/dynamic_table";
    }

    @GetMapping("/basic_table")
    public String basic_table() {
        return "table/basic_table";
    }
    @GetMapping("/dynamic_table")
    public String dynamic_table(@RequestParam(value="pn", defaultValue = "1")Integer pn, Model model) {
//        List<User> userList = Arrays.asList(new User("zhangsan", "123456"), new User("lisi", "123456"),
//                new User("haha", "123456"),
//                new User("hehe", "123456"));
//        model.addAttribute("users", userList);
        List<User> userList = userService.list();
        // 进行分页查询
        Page<User> page = new Page<>(pn, 2);
        // 分页查询的结果
        Page<User> page1 = userService.page(page, null);
        model.addAttribute("users", userList);
        model.addAttribute("page", page1);
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
