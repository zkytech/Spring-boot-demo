package com.BugManageSystem.Controller;

import com.BugManageSystem.Bean.FormatedBug;
import com.BugManageSystem.Entity.Bug;
import com.BugManageSystem.Entity.BugRepository;
import com.fasterxml.jackson.databind.ser.std.StdArraySerializers;
import com.sun.org.apache.xalan.internal.xsltc.util.IntegerArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    BugRepository bugRepository;


    @GetMapping("/bugpanel")
    String bugpanelPage(){
        return "/adminUser/bugpanel";
    }

    @GetMapping("/buglist")
    String buglistPage(@RequestParam(required = false,defaultValue = "")String keyword,@RequestParam(required = false, defaultValue = "1")Integer page,
            @RequestParam(required = false,defaultValue = "10") Integer size, Model model){
        Sort sort = new Sort(Sort.Direction.ASC, "id");
        Pageable pageable = new PageRequest(page-1,size,sort);
        long row_count = bugRepository.count(); // 获取总行数
        System.out.println("总行数："+row_count);
        long max_page = row_count/size; // 计算最大分页数
        if(row_count%size!=0){
            max_page+=1;
        }
        List<Bug> bugs = bugRepository.findAllByBugnameContains(keyword,pageable);
        List<FormatedBug> formatedBugs = new ArrayList<FormatedBug>();
        for (Bug bug: bugs){
            formatedBugs.add(bug.getFormatedBug());
        }
        model.addAttribute("bugs", formatedBugs);
        model.addAttribute("page",page);
        model.addAttribute("max_page",max_page);

        // 生成翻页按钮序列
        int start = page-5;
        int end = page+5;
        if (start<1){
            end +=1-start;
            start=1;
        }
        if (end>max_page){
            start-=end-max_page;
            end=(int)max_page;
        }
        if(start<1){
            start=1;
        }
        List<Integer> pages = new ArrayList();
        for(int i = start; i<=end;i++){
            pages.add(i);
        }
        model.addAttribute("pages", pages);

        return "/adminUser/buglist";
    }


}
