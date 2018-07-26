package com.BugManageSystem.controller;

import com.BugManageSystem.User;
import com.BugManageSystem.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;


@Controller
public class UserController {
    @Autowired
    UserRepository repository;

    @GetMapping("/login.html")
    public String loginPage(){
        return "login";
    }

    @PostMapping("/login")
    public String login(User user, HttpSession session, Model model, RedirectAttributes redirectAttributes){

        if(repository.loginCheck(user.getUsername(),user.getPassword(), user.getIdentity()).size()==1){
            //登录验证成功
            session.setAttribute("username", user.getUsername());
            redirectAttributes.addFlashAttribute("message", "成功登陆！");
            return "redirect:/index";
        }else {
            //登录验证失败
            model.addAttribute("message", true);
            return "login";
        }
    }

    @RequestMapping("/index")
    public String indexPage(){
        return "INDEX";
    }

    @GetMapping("/signup.html")
    public String signupPage(){
        return "signup";
    }

    @PostMapping("/signup")
    @ResponseBody
    public String signup(User user){
        System.out.println("Saving to table");
        repository.save(user);
        return "成功注册!";
    }



}
