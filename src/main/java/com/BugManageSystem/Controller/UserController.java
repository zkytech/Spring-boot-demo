package com.BugManageSystem.Controller;

import com.BugManageSystem.Entity.*;
import com.sun.org.apache.xpath.internal.operations.Bool;
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
import java.util.HashMap;
import java.util.Map;
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
        return "redirect:/signin";
    }

    @GetMapping("/signin")
    public String signinPage(@RequestParam(name = "msg", required = false) String msg, Model model, HttpSession session) {
        if (session.getAttribute("signin") != null && (Boolean) session.getAttribute("signin")) {
            return "redirect:/bugpanel";
        }

        if(msg != null){
            model.addAttribute("msg",true);
        }else {
            model.addAttribute("msg", false);
        }
        return "signin";
    }

    @PostMapping("/signin")
    @ResponseBody
    public Map<String, Boolean> signin(User user, String remember_me, HttpSession session, HttpServletResponse respons){
        Map<String, Boolean> result = new HashMap<String, Boolean>();

        if(repository.signinCheck(user.getUsername(),user.getPassword(), user.getIdentity()).size()==1){
            //登录验证成功
            Example<User> example = Example.of(user);
            Optional<User> nuser = repository.findOne(example);
            Integer userid = -1;
            if(nuser.isPresent()){
            userid= nuser.get().getId();}
            if(remember_me!=null){
                // 一个月内免登录
                System.out.println("111111111111111111111111");
                System.out.println(remember_me);
                session.setMaxInactiveInterval(2592000);
                Cookie cookie = new Cookie("JSESSIONID", session.getId());
                cookie.setMaxAge(2592000);
                respons.addCookie(cookie);
            }
            String identity_str = null;
            switch (user.getIdentity()){
                case 0: identity_str="普通用户";break;
                case 1: identity_str="管理员";break;
                default: identity_str="未知账户类型";break;
            }
            session.setAttribute("username", user.getUsername());
            System.out.println("Setting username="+user.getUsername());
            session.setAttribute("identity", user.getIdentity());
            session.setAttribute("userid", userid);
            session.setAttribute("signin", true);
            session.setAttribute("identity_str", identity_str);
            result.put("success", true);
            return result;
        }else {
            //登录验证失败
            result.put("success", false);
            return result;
        }
    }

    @GetMapping("/signup")
    public String signupPage(){
        return "signup";
    }

    @PostMapping("/signup")
    @ResponseBody
    public Map signup(User user, Model model, RedirectAttributes redirectAttributes){
        String username = user.getUsername();
        Map result = new HashMap();
        if(repository.checkUsernameUnique(username).size()>=1){
            // 用户名已经存在，不允许注册
            model.addAttribute("alert", "用户名已被注册，请修改用户名");
            result.put("success", false);
            return result;
        }
        System.out.println("Saving to table");
        repository.save(user);
        redirectAttributes.addFlashAttribute("success","注册成功，现在开始登录吧！");
        result.put("success", true);
        return  result;
    }

    @RequestMapping("/logout")
    String logout(HttpSession session){
        session.invalidate();
        return "redirect:/";
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
