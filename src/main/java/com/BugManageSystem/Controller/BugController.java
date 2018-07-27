package com.BugManageSystem.Controller;

import com.BugManageSystem.Entity.Bug;
import com.BugManageSystem.Entity.BugRepository;
import com.BugManageSystem.Entity.Types;
import com.BugManageSystem.Entity.TypesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class BugController {
    @Autowired
    BugRepository bugRepository;


    @Autowired
    TypesRepository typesRepository;


    @GetMapping("/submitbug")
    public String submitbugPage(Model model, HttpSession session){

        List<Types> bugTypes= typesRepository.findAll();
        model.addAttribute("bugtypes", bugTypes);
        model.addAttribute("userid", (Integer)session.getAttribute("userid"));
        return "/commonUser/submitbug";
    }

    @PostMapping("/submitbug")
    public String submitbug(Bug bug){
        System.out.println(bug.getBugname());
        bugRepository.save(bug);
        return "redirect:/submitbug";
    }

    @PostMapping("/addbugtype")
    public String addbugtype(Types newtype){
        typesRepository.save(newtype);
        return "addbugtype";
    }

    @GetMapping("/addbugtype")
    public String addbugtypePage(){

        return "addbugtype";
    }

}
