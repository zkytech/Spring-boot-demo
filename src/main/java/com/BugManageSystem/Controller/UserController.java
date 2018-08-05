package com.BugManageSystem.Controller;

import com.BugManageSystem.Entity.User;
import com.BugManageSystem.Entity.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.net.HttpCookie;
import java.util.Optional;


@Controller
public class UserController {
    @Autowired
    UserRepository repository;

    @GetMapping("/")
    public String mainPage(){
        return "redirect:/index";
    }

    @GetMapping("/signin")
    public String signinPage(){return "signin";}

    @PostMapping("/signin")
    public String signin(User user, String remember_me, HttpSession session, HttpServletResponse respons,HttpServletRequest request, Model model){
        if(repository.signinCheck(user.getUsername(),user.getPassword(), user.getIdentity()).size()==1){
            //登录验证成功
            Example<User> example = Example.of(user);
            Optional<User> nuser = repository.findOne(example);
            Integer userid = -1;
            if(nuser.isPresent()){
            userid= nuser.get().getId();}
            if(remember_me!=null){
                // 一个月内免登录
                session.setMaxInactiveInterval(2592000);
                Cookie cookie = new Cookie("JSESSIONID", session.getId());
                cookie.setMaxAge(2592000);
                respons.addCookie(cookie);
            }

            session.setAttribute("username", user.getUsername());
            System.out.println("Setting username="+user.getUsername());
            session.setAttribute("identity", user.getIdentity());
            session.setAttribute("userid", userid);
            session.setAttribute("signin", true);
            model.addAttribute("message", "成功登陆！<script>setTimeout(function(){window.top.location='/index';}, 1000)</script>");
            return "message";
        }else {
            //登录验证失败
            model.addAttribute("alert", "账号或密码错误");
            return "signin";
        }
    }

    @RequestMapping("/index")
    public String indexPage(HttpSession session, Model model){

        if(!(boolean)session.getAttribute("signin")){
            session.setAttribute("signin", false);
        }else {
        Integer identity_num =(Integer) session.getAttribute("identity");   // 在adminInterceptor中检查这一属性
        String username =(String) session.getAttribute("username");     // 在signinInterceptor中检查这一属性
        Integer userid = (Integer) session.getAttribute("userid");
        String identity= "";
        switch (identity_num){
            case 0:identity="用户";break;
            case 1:identity="审核员";break;
        }
        model.addAttribute("identity", identity);
        model.addAttribute("username", username);
        model.addAttribute("userid", userid);}
        return "INDEX";
    }

    @GetMapping("/signup")
    public String signupPage(){
        return "signup";
    }

    @PostMapping("/signup")
    public String signup(User user, RedirectAttributes redirectAttributes){
        String username = user.getUsername();
        if(repository.checkUsernameUnique(username).size()>=1){
            // 用户名已经存在，不允许注册
            redirectAttributes.addFlashAttribute("message", "用户名已被注册，请修改用户名");
            return "redirect:/signup";
        }
        System.out.println("Saving to table");
        repository.save(user);
        redirectAttributes.addFlashAttribute("sucess","注册成功，现在开始登录吧！");
        return "redirect:/";
    }
    @RequestMapping("/test")
    public String testPage(){
        return "test";
    }
//TODO:添加注销/登出功能
    @RequestMapping("/logout")
    String logout(HttpSession session){
        session.invalidate();
        return "redirect:/index";
    }
}
