package com.hut.myblog.controller;

import com.hut.myblog.bean.Tag;
import com.hut.myblog.service.UserService;
import com.hut.myblog.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class LoginController {
    @Autowired
    private UserService userService;
    @RequestMapping()
    public String loginPage() {
        return "admin/login";
    }
    @RequestMapping("/login")
    public String login(@RequestParam(value = "username",required = false) String username,
                        @RequestParam(value = "password",required = false) String password,
                        HttpSession session, RedirectAttributes attributes) {
        User user=userService.checkUser(username,password);
        if (user!=null) {
            user.setPassword(null);
            session.setAttribute("user",user);
            return "admin/bolgs";
        }else {
            session.removeAttribute("user");
           attributes.addFlashAttribute("message","用户名和密码错误");
            return "redirect:/admin";
        }
}

        @GetMapping("/logout")
        public String logout(HttpSession session){
        session.removeAttribute("user");
        return "redirect:/admin";
        }
    @RequestMapping("/bolgs")
    public String hh(){
        return "admin/bolgs";
    }


    }
