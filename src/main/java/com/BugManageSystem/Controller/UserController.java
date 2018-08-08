package com.BugManageSystem.Controller;

import com.BugManageSystem.Entity.*;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
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
    @Autowired
    TypesRepository typesRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    BugRepository bugRepository;
    @Autowired
    HandlerRepository handlerRepository;
    @Autowired
    DepartmentRepository departmentRepository;

    @GetMapping("/")
    public String mainPage(){
        return "redirect:/index";
    }

    @GetMapping("/signin")
    public String signinPage(@RequestParam(required = false) String success, Model model){
        if(success!=null){
            model.addAttribute("success", success);
        }
        return "signin";
    }

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
    public String signup(User user, Model model, RedirectAttributes redirectAttributes){
        String username = user.getUsername();
        if(repository.checkUsernameUnique(username).size()>=1){
            // 用户名已经存在，不允许注册
            model.addAttribute("alert", "用户名已被注册，请修改用户名");
            return "signup";
        }
        System.out.println("Saving to table");
        repository.save(user);
        redirectAttributes.addFlashAttribute("success","注册成功，现在开始登录吧！");
        return "redirect:/signin";
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

    @RequestMapping("/project_info")
    public String project_info_page(){
        return "project_info";
    }

    @RequestMapping("/init")
    @ResponseBody
    public String init(){

        // 初始化测试数据
        userRepository.save(new User("zky","160811",0));
        userRepository.save(new User("test","160811",1));
        userRepository.save(new User("user1","160811",0));

        typesRepository.save(new Types("SQL注入"));
        typesRepository.save(new Types("信息泄露"));
        typesRepository.save(new Types("弱口令"));
        typesRepository.save(new Types("逻辑"));
        typesRepository.save(new Types("命令执行"));
        typesRepository.save(new Types("权限"));




        bugRepository.save(new Bug("测试1",2,"www.hao123.com", "109.123.33.1",0,"测试文本",1,0));
        bugRepository.save(new Bug("测试2",1,"www.hao123.com", "109.123.33.1",1,"测试文本",1,0));
        bugRepository.save(new Bug("测试3",4,"www.hao123.com", "109.123.33.1",2,"测试文本",1,0));
        bugRepository.save(new Bug("测试4",3,"www.hao123.com", "109.123.33.1",0,"测试文本",1,0));
        bugRepository.save(new Bug("测试5",2,"www.hao123.com", "109.123.33.1",0,"测试文本",2,0));
        bugRepository.save(new Bug("测试6",2,"www.hao123.com", "109.123.33.1",0,"测试文本",1,0));
        bugRepository.save(new Bug("测试1",2,"www.hao123.com", "109.123.33.1",0,"测试文本",1,0));
        bugRepository.save(new Bug("测试2",1,"www.hao123.com", "109.123.33.1",1,"测试文本",1,0));
        bugRepository.save(new Bug("测试3",4,"www.hao123.com", "109.123.33.1",2,"测试文本",1,0));
        bugRepository.save(new Bug("测试4",3,"www.hao123.com", "109.123.33.1",0,"测试文本",1,0));
        bugRepository.save(new Bug("测试5",2,"www.hao123.com", "109.123.33.1",0,"测试文本",2,0));
        bugRepository.save(new Bug("测试6",2,"www.hao123.com", "109.123.33.1",0,"测试文本",1,0));
        bugRepository.save(new Bug("测试1",2,"www.hao123.com", "109.123.33.1",0,"测试文本",1,0));
        bugRepository.save(new Bug("测试2",1,"www.hao123.com", "109.123.33.1",1,"测试文本",1,0));
        bugRepository.save(new Bug("测试3",4,"www.hao123.com", "109.123.33.1",2,"测试文本",1,0));
        bugRepository.save(new Bug("测试4",3,"www.hao123.com", "109.123.33.1",0,"测试文本",1,0));
        bugRepository.save(new Bug("测试5",2,"www.hao123.com", "109.123.33.1",0,"测试文本",2,0));
        bugRepository.save(new Bug("测试6",6,"www.hao123.com", "109.123.33.1",0,"测试文本",1,0));
        bugRepository.save(new Bug("测试1",2,"www.hao123.com", "109.123.33.1",0,"测试文本",1,0));
        bugRepository.save(new Bug("测试2",5,"www.hao123.com", "109.123.33.1",1,"测试文本",1,0));
        bugRepository.save(new Bug("测试3",4,"www.hao123.com", "109.123.33.1",2,"测试文本",1,0));
        bugRepository.save(new Bug("测试4",3,"www.hao123.com", "109.123.33.1",0,"测试文本",1,0));
        bugRepository.save(new Bug("测试5",2,"www.hao123.com", "109.123.33.1",0,"测试文本",2,0));
        bugRepository.save(new Bug("测试6",2,"www.hao123.com", "109.123.33.1",0,"测试文本",3,0));
        bugRepository.save(new Bug("测试1",5,"www.hao123.com", "109.123.33.1",0,"测试文本",1,0));
        bugRepository.save(new Bug("测试2",1,"www.hao123.com", "109.123.33.1",1,"测试文本",1,0));
        bugRepository.save(new Bug("测试3",4,"www.hao123.com", "109.123.33.1",2,"测试文本",1,0));
        bugRepository.save(new Bug("测试4",3,"www.hao123.com", "109.123.33.1",0,"测试文本",1,0));
        bugRepository.save(new Bug("测试5",2,"www.hao123.com", "109.123.33.1",0,"测试文本",2,0));
        bugRepository.save(new Bug("测试6",2,"www.123.com", "109.123.33.1",0,"测试文本",3,0));
        bugRepository.save(new Bug("测试1",2,"www.hao123.com", "109.123.33.1",0,"测试文本",1,0));
        bugRepository.save(new Bug("测试2",1,"www.hao123.com", "109.123.33.1",1,"测试文本",1,0));
        bugRepository.save(new Bug("测试3",4,"www.hao123.com", "109.123.33.1",2,"测试文本",1,0));
        bugRepository.save(new Bug("测试4",3,"www.hao123.com", "109.123.33.1",0,"测试文本",1,0));
        bugRepository.save(new Bug("测试5",2,"www.hao123.com", "109.123.33.1",0,"测试文本",2,0));
        bugRepository.save(new Bug("测试6",2,"www.hao123.com", "111.123.33.1",0,"测试文本",3,0));

        bugRepository.save(new Bug("测试1",2,"www.hao123.com", "109.123.33.1",0,"测试文本",1,0));
        bugRepository.save(new Bug("测试2",1,"www.hao123.com", "109.123.33.1",1,"测试文本",1,0));
        bugRepository.save(new Bug("测试3",4,"www.hao123.com", "109.123.33.1",2,"测试文本",1,0));
        bugRepository.save(new Bug("测试4",3,"www.hao123.com", "109.123.33.1",0,"测试文本",1,0));
        bugRepository.save(new Bug("测试5",2,"www.hao123.com", "109.123.33.1",0,"测试文本",2,0));
        bugRepository.save(new Bug("测试6",2,"www.hao123.com", "109.123.33.1",0,"测试文本",1,0));
        bugRepository.save(new Bug("测试1",2,"www.hao123.com", "109.123.33.1",0,"测试文本",1,0));
        bugRepository.save(new Bug("测试2",1,"www.hao123.com", "109.123.33.1",1,"测试文本",1,0));
        bugRepository.save(new Bug("测试3",4,"www.hao123.com", "109.123.33.1",2,"测试文本",1,0));
        bugRepository.save(new Bug("测试4",3,"www.hao123.com", "109.123.33.1",0,"测试文本",1,0));
        bugRepository.save(new Bug("测试5",2,"www.hao123.com", "109.123.33.1",0,"测试文本",2,0));
        bugRepository.save(new Bug("测试6",2,"www.hao123.com", "109.123.33.1",0,"测试文本",1,0));
        bugRepository.save(new Bug("测试1",2,"www.hao123.com", "109.123.33.1",0,"测试文本",1,0));
        bugRepository.save(new Bug("测试2",1,"www.hao123.com", "109.123.33.1",1,"测试文本",1,0));
        bugRepository.save(new Bug("测试3",4,"www.hao123.com", "109.123.33.1",2,"测试文本",1,0));
        bugRepository.save(new Bug("测试4",3,"www.hao123.com", "109.123.33.1",0,"测试文本",1,0));
        bugRepository.save(new Bug("测试5",2,"www.hao123.com", "109.123.33.1",0,"测试文本",2,0));
        bugRepository.save(new Bug("测试6",6,"www.hao123.com", "109.123.33.1",0,"测试文本",1,0));
        bugRepository.save(new Bug("测试1",2,"www.hao123.com", "109.123.33.1",0,"测试文本",1,0));
        bugRepository.save(new Bug("测试2",5,"www.hao123.com", "109.123.33.1",1,"测试文本",1,0));
        bugRepository.save(new Bug("测试3",4,"www.hao123.com", "109.123.33.1",2,"测试文本",1,0));
        bugRepository.save(new Bug("测试4",3,"www.hao123.com", "109.123.33.1",0,"测试文本",1,0));
        bugRepository.save(new Bug("测试5",2,"www.hao123.com", "109.123.33.1",0,"测试文本",2,0));
        bugRepository.save(new Bug("测试6",2,"www.hao123.com", "109.123.33.1",0,"测试文本",3,0));
        bugRepository.save(new Bug("测试1",5,"www.hao123.com", "109.123.33.1",0,"测试文本",1,0));
        bugRepository.save(new Bug("测试2",1,"www.hao123.com", "109.123.33.1",1,"测试文本",1,0));
        bugRepository.save(new Bug("测试3",4,"www.hao123.com", "109.123.33.1",2,"测试文本",1,0));
        bugRepository.save(new Bug("测试4",3,"www.hao123.com", "109.123.33.1",0,"测试文本",1,0));
        bugRepository.save(new Bug("测试5",2,"www.hao123.com", "109.123.33.1",0,"测试文本",2,0));
        bugRepository.save(new Bug("测试6",2,"www.123.com", "109.123.33.1",0,"测试文本",3,0));
        bugRepository.save(new Bug("测试1",2,"www.hao123.com", "109.123.33.1",0,"测试文本",1,0));
        bugRepository.save(new Bug("测试2",1,"www.hao123.com", "109.123.33.1",1,"测试文本",1,0));
        bugRepository.save(new Bug("测试3",4,"www.hao123.com", "109.123.33.1",2,"测试文本",1,0));
        bugRepository.save(new Bug("测试4",3,"www.hao123.com", "109.123.33.1",0,"测试文本",1,0));
        bugRepository.save(new Bug("测试5",2,"www.hao123.com", "109.123.33.1",0,"测试文本",2,0));
        bugRepository.save(new Bug("测试6",2,"www.hao123.com", "111.123.33.1",0,"测试文本",3,0));

        bugRepository.save(new Bug("测试1",2,"www.hao123.com", "109.123.33.1",0,"测试文本",1,0));
        bugRepository.save(new Bug("测试2",1,"www.hao123.com", "109.123.33.1",1,"测试文本",1,0));
        bugRepository.save(new Bug("测试3",4,"www.hao123.com", "109.123.33.1",2,"测试文本",1,0));
        bugRepository.save(new Bug("测试4",3,"www.hao123.com", "109.123.33.1",0,"测试文本",1,0));
        bugRepository.save(new Bug("测试5",2,"www.hao123.com", "109.123.33.1",0,"测试文本",2,0));
        bugRepository.save(new Bug("测试6",2,"www.hao123.com", "109.123.33.1",0,"测试文本",1,0));
        bugRepository.save(new Bug("测试1",2,"www.hao123.com", "109.123.33.1",0,"测试文本",1,0));
        bugRepository.save(new Bug("测试2",1,"www.hao123.com", "109.123.33.1",1,"测试文本",1,0));
        bugRepository.save(new Bug("测试3",4,"www.hao123.com", "109.123.33.1",2,"测试文本",1,0));
        bugRepository.save(new Bug("测试4",3,"www.hao123.com", "109.123.33.1",0,"测试文本",1,0));
        bugRepository.save(new Bug("测试5",2,"www.hao123.com", "109.123.33.1",0,"测试文本",2,0));
        bugRepository.save(new Bug("测试6",2,"www.hao123.com", "109.123.33.1",0,"测试文本",1,0));
        bugRepository.save(new Bug("测试1",2,"www.hao123.com", "109.123.33.1",0,"测试文本",1,0));
        bugRepository.save(new Bug("测试2",1,"www.hao123.com", "109.123.33.1",1,"测试文本",1,0));
        bugRepository.save(new Bug("测试3",4,"www.hao123.com", "109.123.33.1",2,"测试文本",1,0));
        bugRepository.save(new Bug("测试4",3,"www.hao123.com", "109.123.33.1",0,"测试文本",1,0));
        bugRepository.save(new Bug("测试5",2,"www.hao123.com", "109.123.33.1",0,"测试文本",2,0));
        bugRepository.save(new Bug("测试6",6,"www.hao123.com", "109.123.33.1",0,"测试文本",1,0));
        bugRepository.save(new Bug("测试1",2,"www.hao123.com", "109.123.33.1",0,"测试文本",1,0));
        bugRepository.save(new Bug("测试2",5,"www.hao123.com", "109.123.33.1",1,"测试文本",1,0));
        bugRepository.save(new Bug("测试3",4,"www.hao123.com", "109.123.33.1",2,"测试文本",1,0));
        bugRepository.save(new Bug("测试4",3,"www.hao123.com", "109.123.33.1",0,"测试文本",1,0));
        bugRepository.save(new Bug("测试5",2,"www.hao123.com", "109.123.33.1",0,"测试文本",2,0));
        bugRepository.save(new Bug("测试6",2,"www.hao123.com", "109.123.33.1",0,"测试文本",3,0));
        bugRepository.save(new Bug("测试1",5,"www.hao123.com", "109.123.33.1",0,"测试文本",1,0));
        bugRepository.save(new Bug("测试2",1,"www.hao123.com", "109.123.33.1",1,"测试文本",1,0));
        bugRepository.save(new Bug("测试3",4,"www.hao123.com", "109.123.33.1",2,"测试文本",1,0));
        bugRepository.save(new Bug("测试4",3,"www.hao123.com", "109.123.33.1",0,"测试文本",1,0));
        bugRepository.save(new Bug("测试5",2,"www.hao123.com", "109.123.33.1",0,"测试文本",2,0));
        bugRepository.save(new Bug("测试6",2,"www.123.com", "109.123.33.1",0,"测试文本",3,0));
        bugRepository.save(new Bug("测试1",2,"www.hao123.com", "109.123.33.1",0,"测试文本",1,0));
        bugRepository.save(new Bug("测试2",1,"www.hao123.com", "109.123.33.1",1,"测试文本",1,0));
        bugRepository.save(new Bug("测试3",4,"www.hao123.com", "109.123.33.1",2,"测试文本",1,0));
        bugRepository.save(new Bug("测试4",3,"www.hao123.com", "109.123.33.1",0,"测试文本",1,0));
        bugRepository.save(new Bug("测试5",2,"www.hao123.com", "109.123.33.1",0,"测试文本",2,0));
        bugRepository.save(new Bug("测试6",2,"www.hao123.com", "111.123.33.1",0,"测试文本",3,0));

        bugRepository.save(new Bug("测试1",2,"www.hao123.com", "109.123.33.1",0,"测试文本",1,0));
        bugRepository.save(new Bug("测试2",1,"www.hao123.com", "109.123.33.1",1,"测试文本",1,0));
        bugRepository.save(new Bug("测试3",4,"www.hao123.com", "109.123.33.1",2,"测试文本",1,0));
        bugRepository.save(new Bug("测试4",3,"www.hao123.com", "109.123.33.1",0,"测试文本",1,0));
        bugRepository.save(new Bug("测试5",2,"www.hao123.com", "109.123.33.1",0,"测试文本",2,0));
        bugRepository.save(new Bug("测试6",2,"www.hao123.com", "109.123.33.1",0,"测试文本",1,0));
        bugRepository.save(new Bug("测试1",2,"www.hao123.com", "109.123.33.1",0,"测试文本",1,0));
        bugRepository.save(new Bug("测试2",1,"www.hao123.com", "109.123.33.1",1,"测试文本",1,0));
        bugRepository.save(new Bug("测试3",4,"www.hao123.com", "109.123.33.1",2,"测试文本",1,0));
        bugRepository.save(new Bug("测试4",3,"www.hao123.com", "109.123.33.1",0,"测试文本",1,0));
        bugRepository.save(new Bug("测试5",2,"www.hao123.com", "109.123.33.1",0,"测试文本",2,0));
        bugRepository.save(new Bug("测试6",2,"www.hao123.com", "109.123.33.1",0,"测试文本",1,0));
        bugRepository.save(new Bug("测试1",2,"www.hao123.com", "109.123.33.1",0,"测试文本",1,0));
        bugRepository.save(new Bug("测试2",1,"www.hao123.com", "109.123.33.1",1,"测试文本",1,0));
        bugRepository.save(new Bug("测试3",4,"www.hao123.com", "109.123.33.1",2,"测试文本",1,0));
        bugRepository.save(new Bug("测试4",3,"www.hao123.com", "109.123.33.1",0,"测试文本",1,0));
        bugRepository.save(new Bug("测试5",2,"www.hao123.com", "109.123.33.1",0,"测试文本",2,0));
        bugRepository.save(new Bug("测试6",6,"www.hao123.com", "109.123.33.1",0,"测试文本",1,0));
        bugRepository.save(new Bug("测试1",2,"www.hao123.com", "109.123.33.1",0,"测试文本",1,0));
        bugRepository.save(new Bug("测试2",5,"www.hao123.com", "109.123.33.1",1,"测试文本",1,0));
        bugRepository.save(new Bug("测试3",4,"www.hao123.com", "109.123.33.1",2,"测试文本",1,0));
        bugRepository.save(new Bug("测试4",3,"www.hao123.com", "109.123.33.1",0,"测试文本",1,0));
        bugRepository.save(new Bug("测试5",2,"www.hao123.com", "109.123.33.1",0,"测试文本",2,0));
        bugRepository.save(new Bug("测试6",2,"www.hao123.com", "109.123.33.1",0,"测试文本",3,0));
        bugRepository.save(new Bug("测试1",5,"www.hao123.com", "109.123.33.1",0,"测试文本",1,0));
        bugRepository.save(new Bug("测试2",1,"www.hao123.com", "109.123.33.1",1,"测试文本",1,0));
        bugRepository.save(new Bug("测试3",4,"www.hao123.com", "109.123.33.1",2,"测试文本",1,0));
        bugRepository.save(new Bug("测试4",3,"www.hao123.com", "109.123.33.1",0,"测试文本",1,0));
        bugRepository.save(new Bug("测试5",2,"www.hao123.com", "109.123.33.1",0,"测试文本",2,0));
        bugRepository.save(new Bug("测试6",2,"www.123.com", "109.123.33.1",0,"测试文本",3,0));
        bugRepository.save(new Bug("测试1",2,"www.hao123.com", "109.123.33.1",0,"测试文本",1,0));
        bugRepository.save(new Bug("测试2",1,"www.hao123.com", "109.123.33.1",1,"测试文本",1,0));
        bugRepository.save(new Bug("测试3",4,"www.hao123.com", "109.123.33.1",2,"测试文本",1,0));
        bugRepository.save(new Bug("测试4",3,"www.hao123.com", "109.123.33.1",0,"测试文本",1,0));
        bugRepository.save(new Bug("测试5",2,"www.hao123.com", "109.123.33.1",0,"测试文本",2,0));
        bugRepository.save(new Bug("测试6",2,"www.hao123.com", "111.123.33.1",0,"测试文本",3,0));

        bugRepository.save(new Bug("测试1",2,"www.hao123.com", "109.123.33.1",0,"测试文本",1,0));
        bugRepository.save(new Bug("测试2",1,"www.hao123.com", "109.123.33.1",1,"测试文本",1,0));
        bugRepository.save(new Bug("测试3",4,"www.hao123.com", "109.123.33.1",2,"测试文本",1,0));
        bugRepository.save(new Bug("测试4",3,"www.hao123.com", "109.123.33.1",0,"测试文本",1,0));
        bugRepository.save(new Bug("测试5",2,"www.hao123.com", "109.123.33.1",0,"测试文本",2,0));
        bugRepository.save(new Bug("测试6",2,"www.hao123.com", "109.123.33.1",0,"测试文本",1,0));
        bugRepository.save(new Bug("测试1",2,"www.hao123.com", "109.123.33.1",0,"测试文本",1,0));
        bugRepository.save(new Bug("测试2",1,"www.hao123.com", "109.123.33.1",1,"测试文本",1,0));
        bugRepository.save(new Bug("测试3",4,"www.hao123.com", "109.123.33.1",2,"测试文本",1,0));
        bugRepository.save(new Bug("测试4",3,"www.hao123.com", "109.123.33.1",0,"测试文本",1,0));
        bugRepository.save(new Bug("测试5",2,"www.hao123.com", "109.123.33.1",0,"测试文本",2,0));
        bugRepository.save(new Bug("测试6",2,"www.hao123.com", "109.123.33.1",0,"测试文本",1,0));
        bugRepository.save(new Bug("测试1",2,"www.hao123.com", "109.123.33.1",0,"测试文本",1,0));
        bugRepository.save(new Bug("测试2",1,"www.hao123.com", "109.123.33.1",1,"测试文本",1,0));
        bugRepository.save(new Bug("测试3",4,"www.hao123.com", "109.123.33.1",2,"测试文本",1,0));
        bugRepository.save(new Bug("测试4",3,"www.hao123.com", "109.123.33.1",0,"测试文本",1,0));
        bugRepository.save(new Bug("测试5",2,"www.hao123.com", "109.123.33.1",0,"测试文本",2,0));
        bugRepository.save(new Bug("测试6",6,"www.hao123.com", "109.123.33.1",0,"测试文本",1,0));
        bugRepository.save(new Bug("测试1",2,"www.hao123.com", "109.123.33.1",0,"测试文本",1,0));
        bugRepository.save(new Bug("测试2",5,"www.hao123.com", "109.123.33.1",1,"测试文本",1,0));
        bugRepository.save(new Bug("测试3",4,"www.hao123.com", "109.123.33.1",2,"测试文本",1,0));
        bugRepository.save(new Bug("测试4",3,"www.hao123.com", "109.123.33.1",0,"测试文本",1,0));
        bugRepository.save(new Bug("测试5",2,"www.hao123.com", "109.123.33.1",0,"测试文本",2,0));
        bugRepository.save(new Bug("测试6",2,"www.hao123.com", "109.123.33.1",0,"测试文本",3,0));
        bugRepository.save(new Bug("测试1",5,"www.hao123.com", "109.123.33.1",0,"测试文本",1,0));
        bugRepository.save(new Bug("测试2",1,"www.hao123.com", "109.123.33.1",1,"测试文本",1,0));
        bugRepository.save(new Bug("测试3",4,"www.hao123.com", "109.123.33.1",2,"测试文本",1,0));
        bugRepository.save(new Bug("测试4",3,"www.hao123.com", "109.123.33.1",0,"测试文本",1,0));
        bugRepository.save(new Bug("测试5",2,"www.hao123.com", "109.123.33.1",0,"测试文本",2,0));
        bugRepository.save(new Bug("测试6",2,"www.123.com", "109.123.33.1",0,"测试文本",3,0));
        bugRepository.save(new Bug("测试1",2,"www.hao123.com", "109.123.33.1",0,"测试文本",1,0));
        bugRepository.save(new Bug("测试2",1,"www.hao123.com", "109.123.33.1",1,"测试文本",1,0));
        bugRepository.save(new Bug("测试3",4,"www.hao123.com", "109.123.33.1",2,"测试文本",1,0));
        bugRepository.save(new Bug("测试4",3,"www.hao123.com", "109.123.33.1",0,"测试文本",1,0));
        bugRepository.save(new Bug("测试5",2,"www.hao123.com", "109.123.33.1",0,"测试文本",2,0));
        bugRepository.save(new Bug("测试6",2,"www.hao123.com", "111.123.33.1",0,"测试文本",3,0));

        bugRepository.save(new Bug("测试1",2,"www.hao123.com", "109.123.33.1",0,"测试文本",1,0));
        bugRepository.save(new Bug("测试2",1,"www.hao123.com", "109.123.33.1",1,"测试文本",1,0));
        bugRepository.save(new Bug("测试3",4,"www.hao123.com", "109.123.33.1",2,"测试文本",1,0));
        bugRepository.save(new Bug("测试4",3,"www.hao123.com", "109.123.33.1",0,"测试文本",1,0));
        bugRepository.save(new Bug("测试5",2,"www.hao123.com", "109.123.33.1",0,"测试文本",2,0));
        bugRepository.save(new Bug("测试6",2,"www.hao123.com", "109.123.33.1",0,"测试文本",1,0));
        bugRepository.save(new Bug("测试1",2,"www.hao123.com", "109.123.33.1",0,"测试文本",1,0));
        bugRepository.save(new Bug("测试2",1,"www.hao123.com", "109.123.33.1",1,"测试文本",1,0));
        bugRepository.save(new Bug("测试3",4,"www.hao123.com", "109.123.33.1",2,"测试文本",1,0));
        bugRepository.save(new Bug("测试4",3,"www.hao123.com", "109.123.33.1",0,"测试文本",1,0));
        bugRepository.save(new Bug("测试5",2,"www.hao123.com", "109.123.33.1",0,"测试文本",2,0));
        bugRepository.save(new Bug("测试6",2,"www.hao123.com", "109.123.33.1",0,"测试文本",1,0));
        bugRepository.save(new Bug("测试1",2,"www.hao123.com", "109.123.33.1",0,"测试文本",1,0));
        bugRepository.save(new Bug("测试2",1,"www.hao123.com", "109.123.33.1",1,"测试文本",1,0));
        bugRepository.save(new Bug("测试3",4,"www.hao123.com", "109.123.33.1",2,"测试文本",1,0));
        bugRepository.save(new Bug("测试4",3,"www.hao123.com", "109.123.33.1",0,"测试文本",1,0));
        bugRepository.save(new Bug("测试5",2,"www.hao123.com", "109.123.33.1",0,"测试文本",2,0));
        bugRepository.save(new Bug("测试6",6,"www.hao123.com", "109.123.33.1",0,"测试文本",1,0));
        bugRepository.save(new Bug("测试1",2,"www.hao123.com", "109.123.33.1",0,"测试文本",1,0));
        bugRepository.save(new Bug("测试2",5,"www.hao123.com", "109.123.33.1",1,"测试文本",1,0));
        bugRepository.save(new Bug("测试3",4,"www.hao123.com", "109.123.33.1",2,"测试文本",1,0));
        bugRepository.save(new Bug("测试4",3,"www.hao123.com", "109.123.33.1",0,"测试文本",1,0));
        bugRepository.save(new Bug("测试5",2,"www.hao123.com", "109.123.33.1",0,"测试文本",2,0));
        bugRepository.save(new Bug("测试6",2,"www.hao123.com", "109.123.33.1",0,"测试文本",3,0));
        bugRepository.save(new Bug("测试1",5,"www.hao123.com", "109.123.33.1",0,"测试文本",1,0));
        bugRepository.save(new Bug("测试2",1,"www.hao123.com", "109.123.33.1",1,"测试文本",1,0));
        bugRepository.save(new Bug("测试3",4,"www.hao123.com", "109.123.33.1",2,"测试文本",1,0));
        bugRepository.save(new Bug("测试4",3,"www.hao123.com", "109.123.33.1",0,"测试文本",1,0));
        bugRepository.save(new Bug("测试5",2,"www.hao123.com", "109.123.33.1",0,"测试文本",2,0));
        bugRepository.save(new Bug("测试6",2,"www.123.com", "109.123.33.1",0,"测试文本",3,0));
        bugRepository.save(new Bug("测试1",2,"www.hao123.com", "109.123.33.1",0,"测试文本",1,0));
        bugRepository.save(new Bug("测试2",1,"www.hao123.com", "109.123.33.1",1,"测试文本",1,0));
        bugRepository.save(new Bug("测试3",4,"www.hao123.com", "109.123.33.1",2,"测试文本",1,0));
        bugRepository.save(new Bug("测试4",3,"www.hao123.com", "109.123.33.1",0,"测试文本",1,0));
        bugRepository.save(new Bug("测试5",2,"www.hao123.com", "109.123.33.1",0,"测试文本",2,0));
        bugRepository.save(new Bug("测试6",2,"www.hao123.com", "111.123.33.1",0,"测试文本",3,0));

        departmentRepository.save(new Department("工程部"));
        departmentRepository.save(new Department("网络部"));
        departmentRepository.save(new Department("信息部"));

        handlerRepository.save(new Handler("张三","17965264565","1231456416@hotmail.com",1));
        handlerRepository.save(new Handler("李四","17965262233","3321456416@hotmail.com",1));
        handlerRepository.save(new Handler("阿斯顿","17965262233","3321456416@hotmail.com",1));
        handlerRepository.save(new Handler("的改革","17965262233","3321456416@hotmail.com",1));
        handlerRepository.save(new Handler("犹太人","17965262233","3321456416@hotmail.com",1));
        handlerRepository.save(new Handler("而感到","17965262233","3321456416@hotmail.com",1));
        handlerRepository.save(new Handler("进口量","17965262233","3321456416@hotmail.com",1));
        handlerRepository.save(new Handler("三四","17965262233","3321456416@hotmail.com",1));
        handlerRepository.save(new Handler("和四","17965262233","3321456416@hotmail.com",1));
        handlerRepository.save(new Handler("他四三","17965262233","3321456416@hotmail.com",1));
        handlerRepository.save(new Handler("李大四","17965262233","3321456416@hotmail.com",1));
        handlerRepository.save(new Handler("李未四","17965262233","3321456416@hotmail.com",1));
        handlerRepository.save(new Handler("李其四","17965262233","3321456416@hotmail.com",1));
        handlerRepository.save(new Handler("李哦四","17965262233","3321456416@hotmail.com",1));
        handlerRepository.save(new Handler("李可四","17965262233","3321456416@hotmail.com",1));
        handlerRepository.save(new Handler("州三四","17965262233","3321456416@hotmail.com",1));
        handlerRepository.save(new Handler("周平","17965262233","3321456416@hotmail.com",1));
        handlerRepository.save(new Handler("周太阳","17965262233","3321456416@hotmail.com",1));
        handlerRepository.save(new Handler("周流派","17965262233","3321456416@hotmail.com",1));
        handlerRepository.save(new Handler("周早在","17965262233","3321456416@hotmail.com",1));

        handlerRepository.save(new Handler("张三三","17965264565","1231456416@hotmail.com",2));
        handlerRepository.save(new Handler("李四的","17965262233","3321456416@hotmail.com",2));
        handlerRepository.save(new Handler("阿斯顿的","17965262233","3321456416@hotmail.com",2));
        handlerRepository.save(new Handler("的改革未","17965262233","3321456416@hotmail.com",2));
        handlerRepository.save(new Handler("犹太人1","17965262233","3321456416@hotmail.com",2));
        handlerRepository.save(new Handler("而感到广泛","17965262233","3321456416@hotmail.com",2));
        handlerRepository.save(new Handler("进口量3","17965262233","3321456416@hotmail.com",2));
        handlerRepository.save(new Handler("三四2","17965262233","3321456416@hotmail.com",2));
        handlerRepository.save(new Handler("和四1","17965262233","3321456416@hotmail.com",2));
        handlerRepository.save(new Handler("他四三3","17965262233","3321456416@hotmail.com",2));
        handlerRepository.save(new Handler("李大四2","17965262233","3321456416@hotmail.com",2));
        handlerRepository.save(new Handler("李未四1","17965262233","3321456416@hotmail.com",2));
        handlerRepository.save(new Handler("李其四2","17965262233","3321456416@hotmail.com",2));
        handlerRepository.save(new Handler("李哦四3","17965262233","3321456416@hotmail.com",2));
        handlerRepository.save(new Handler("李可四1","17965262233","3321456416@hotmail.com",2));
        handlerRepository.save(new Handler("州三四1","17965262233","3321456416@hotmail.com",2));
        handlerRepository.save(new Handler("周平1","17965262233","3321456416@hotmail.com",2));
        handlerRepository.save(new Handler("周太阳1","17965262233","3321456416@hotmail.com",2));
        handlerRepository.save(new Handler("周流派1","17965262233","3321456416@hotmail.com",2));
        handlerRepository.save(new Handler("周早在1","17965262233","3321456416@hotmail.com",2));

        handlerRepository.save(new Handler("三","17965264565","1231456416@hotmail.com",3));
        handlerRepository.save(new Handler("四","17965262233","3321456416@hotmail.com",3));
        handlerRepository.save(new Handler("阿顿","17965262233","3321456416@hotmail.com",3));
        handlerRepository.save(new Handler("的革","17965262233","3321456416@hotmail.com",3));
        handlerRepository.save(new Handler("犹人","17965262233","3321456416@hotmail.com",3));
        handlerRepository.save(new Handler("而到","17965262233","3321456416@hotmail.com",3));
        handlerRepository.save(new Handler("进量","17965262233","3321456416@hotmail.com",3));
        handlerRepository.save(new Handler("三四","17965262233","3321456416@hotmail.com",3));
        handlerRepository.save(new Handler("和四","17965262233","3321456416@hotmail.com",3));
        handlerRepository.save(new Handler("他四三","17965262233","3321456416@hotmail.com",3));
        handlerRepository.save(new Handler("大四","17965262233","3321456416@hotmail.com",3));
        handlerRepository.save(new Handler("未四","17965262233","3321456416@hotmail.com",3));
        handlerRepository.save(new Handler("其四","17965262233","3321456416@hotmail.com",3));
        handlerRepository.save(new Handler("哦四","17965262233","3321456416@hotmail.com",3));
        handlerRepository.save(new Handler("可四","17965262233","3321456416@hotmail.com",3));
        handlerRepository.save(new Handler("三四","17965262233","3321456416@hotmail.com",3));
        handlerRepository.save(new Handler("平","17965262233","3321456416@hotmail.com",3));
        handlerRepository.save(new Handler("太阳","17965262233","3321456416@hotmail.com",3));
        handlerRepository.save(new Handler("流派","17965262233","3321456416@hotmail.com",3));
        handlerRepository.save(new Handler("早在","17965262233","3321456416@hotmail.com",3));
        return "成功";

    }
}
