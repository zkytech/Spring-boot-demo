package com.BugManageSystem.Controller;

import com.BugManageSystem.Bean.FormatedBug;
import com.BugManageSystem.Bean.Workorder_Factory;
import com.BugManageSystem.Entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    BugRepository bugRepository;
    @Autowired
    TypesRepository typesRepository;
    @Autowired
    DepartmentRepository departmentRepository;
    @Autowired
    HandlerRepository handlerRepository;
    @Autowired
    WorkorderRepository workorderRepository;


    @GetMapping("/managebug")
    String managebugPage(@RequestParam(required = true)Long id, Model model){
        FormatedBug bug = bugRepository.findBugByid(id).getFormatedBug();
        List<Types> bugtypes = typesRepository.findAll();
        List<Department> departments = departmentRepository.findAll();
        model.addAttribute("bug",bug);
        model.addAttribute("bugtypes",bugtypes);
        model.addAttribute("departments",departments);
        return "/adminUser/managebug";
    }

    @PostMapping("managebug")
    String managebug(Workorder_Factory workorder_factory, Boolean refused, Model model){
        if(refused){
            // 漏洞被拒绝审核

            Bug bug = bugRepository.findBugByid(workorder_factory.getBugid());
            System.out.println(workorder_factory.getBugid());
            bug.setcheckstatus(2);  //将bug状态设置为2
            bugRepository.save(bug);    //将修改更新到数据库
            String message = "已拒绝该漏洞 ！<script>setTimeout(function(){" +
                    "window.parent.location='/bugpanel'}, 1000)</script>";
            model.addAttribute("message", message);

        }else{
            List<Workorder> workorders = workorder_factory.getWorkorders();
            for(Workorder workorder:workorders){
                workorderRepository.save(workorder);
            }
            String message = "工单提交成功 ！<script>setTimeout(function(){" +
                    "window.parent.location='/bugpanel'}, 1000)</script>";
            model.addAttribute("message", message);
        }
        return "message";
    }

    @GetMapping("/handlers")
    String handlersPage(@RequestParam(required = true)Integer dpt_num, Model model){
        List<Handler> handlers = handlerRepository.findAllByDepartment(dpt_num);
        model.addAttribute("handlers", handlers);
        return "/adminUser/handlers";
    }

    @GetMapping("/comment")
    String commentPage(@RequestParam(required = false,defaultValue = " ")String comment, Model model){
        if(comment.equals("null")){
            comment="";
        }
        model.addAttribute("comment", comment);
        System.out.println("comment:"+comment);
        return "/adminUser/comment";
    }

}
