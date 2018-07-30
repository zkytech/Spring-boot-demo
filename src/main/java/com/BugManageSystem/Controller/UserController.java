package com.BugManageSystem.Controller;

import com.BugManageSystem.Entity.User;
import com.BugManageSystem.Entity.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.util.Optional;


@Controller
public class UserController {
    @Autowired
    UserRepository repository;

    @GetMapping("/")
    public String loginPage(){
        return "login";
    }

    @PostMapping("/login")
    public String login(User user, HttpSession session, Model model, RedirectAttributes redirectAttributes){

        if(repository.loginCheck(user.getUsername(),user.getPassword(), user.getIdentity()).size()==1){
            //登录验证成功
            Example<User> example = Example.of(user);
            Optional<User> nuser = repository.findOne(example);
            Integer userid = -1;
            if(nuser.isPresent()){
            userid= nuser.get().getId();}
            session.setAttribute("username", user.getUsername());
            System.out.println("Setting username="+user.getUsername());
            session.setAttribute("identity", user.getIdentity());
            session.setAttribute("userid", userid);
            redirectAttributes.addFlashAttribute("message", "成功登陆！");
            return "redirect:/index";
        }else {
            //登录验证失败
            model.addAttribute("message", "账号或密码错误");
            return "login";
        }
    }

    @RequestMapping("/index")
    public String indexPage(HttpSession session, Model model){
        Integer identity_num =(Integer) session.getAttribute("identity");   // 在adminInterceptor中检查这一属性
        String username =(String) session.getAttribute("username");     // 在loginInterceptor中检查这一属性
        Integer userid = (Integer) session.getAttribute("userid");
        String identity= "";
        switch (identity_num){
            case 0:identity="用户";break;
            case 1:identity="审核员";break;
        }
        model.addAttribute("identity", identity);
        model.addAttribute("username", username);
        model.addAttribute("userid", userid);
//        if(identity == 0) {
//            //普通用户
//            return "/commonUser/INDEX";
//        }else{
//            if (identity==1){
//                return "/adminUser/INDEX";
//            }
//        }
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
        redirectAttributes.addFlashAttribute("message", "注册成功，现在开始登录吧！");
        return "redirect:/";
    }
    @RequestMapping("/test")
    public String testPage(){
        return "test";
    }


}
