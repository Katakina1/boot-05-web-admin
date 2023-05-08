package com.kina.admin.controller;

import com.kina.admin.bean.City;
import com.kina.admin.bean.Hero;
import com.kina.admin.bean.User;
import com.kina.admin.service.CityService;
import com.kina.admin.service.HeroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
public class IndexController {

    @Autowired
    private HeroService heroService;

    @Autowired
    private CityService cityService;

    @ResponseBody
    @GetMapping("/hero")
    public Hero getByNumber(@RequestParam("number") int number){
        return heroService.getHeroByNumber(number);
    }

    @ResponseBody
    @GetMapping("/city")
    public City getCityById(@RequestParam("id") Long id) {
        return cityService.getById(id);
    }

    @PostMapping("/city")
    public City saveCity(City city) {
        cityService.saveCity(city);
        return city;
    }

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
