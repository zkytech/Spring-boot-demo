package com.BugManageSystem.Controller;

import com.BugManageSystem.Bean.FormatedBug;
import com.BugManageSystem.Entity.Bug;
import com.BugManageSystem.Entity.BugRepository;
import com.BugManageSystem.Entity.Types;
import com.BugManageSystem.Entity.TypesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;

@Controller
public class BugController {
    @Autowired
    BugRepository bugRepository;


    @Autowired
    TypesRepository typesRepository;


    @GetMapping("/submitbug")
    public String submitbugPage(Model model, HttpSession session) {

        List<Types> bugTypes = typesRepository.findAll();
        model.addAttribute("bugtypes", bugTypes);
        model.addAttribute("userid", (Integer) session.getAttribute("userid"));
        return "/submitbug";
    }

    @PostMapping("/submitbug")
    public String submitbug(Bug bug) {
        System.out.println(bug.getBugname());
        bugRepository.save(bug);
        return "redirect:/submitbug";
    }

    @PostMapping("/addbugtype")
    public String addbugtype(Types newtype) {
        typesRepository.save(newtype);
        return "addbugtype";
    }

    @GetMapping("/addbugtype")
    public String addbugtypePage() {

        return "addbugtype";
    }

    @GetMapping("/buglist")
    public String buglistPage(@RequestParam(required = true, defaultValue = "") String keyword, @RequestParam(required = true, defaultValue = "1") Integer page,
                              @RequestParam(required = true, defaultValue = "15") Integer size, @RequestParam(required = true, defaultValue = "bugname") String searchby, HttpSession session, Model model, @RequestParam(required = true, defaultValue = "0") Integer[] checkstatus) {
        Integer userid = (Integer) session.getAttribute("userid");
        Integer identity = (Integer) session.getAttribute("identity");
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        List<Integer> checkstatuses = Arrays.asList(checkstatus);
        long row_count = 0;
        long max_page = 0;
        Pageable pageable;
        List<Bug> bugs = null;
        switch (identity) {
            case 0:    // 普通用户，需要在检索条件里加上用户ID
                switch (searchby) {
                    case "bugname":
                        row_count = bugRepository.findAllByBugnameIgnoreCaseContainsAndSubmituserAndCheckstatusIn(keyword, userid, checkstatuses).size();
                        max_page = row_count / size; // 计算最大分页数
                        if (row_count % size != 0) {
                            max_page += 1;
                        }
                        if (page > max_page) {  //当关键词更改时可能会出现这种情况
                            page = 1;
                        }
                        pageable = new PageRequest(page - 1, size, sort);
                        bugs = bugRepository.findAllByBugnameIgnoreCaseContainsAndSubmituserAndCheckstatusIn(keyword, userid, checkstatuses, pageable);
                        break;
                    case "id":

                        max_page = 1;
                        page = 1;
                        Long id = Long.parseLong(keyword);
                        System.out.println("正在进行ID筛选");
                        bugs = Arrays.asList(bugRepository.findBugByIdAndSubmituser(id, userid));
                        break;
                }
                break;

            case 1:
                switch (searchby) {
                    case "bugname":
                        row_count = bugRepository.findAllByBugnameIgnoreCaseContainsAndCheckstatusIn(keyword, checkstatuses).size();
                        max_page = row_count / size; // 计算最大分页数
                        if (row_count % size != 0) {
                            max_page += 1;
                        }
                        if (page > max_page) {  //当关键词更改时可能会出现这种情况
                            page = 1;
                        }
                        pageable = new PageRequest(page - 1, size, sort);
                        bugs = bugRepository.findAllByBugnameIgnoreCaseContainsAndCheckstatusIn(keyword, checkstatuses, pageable);
                        break;
                    case "id":
                        page = 1;
                        max_page = 1;
                        Long id = Long.parseLong(keyword);
                        bugs = Arrays.asList(bugRepository.findBugByid(id));
                        break;
                    case "submituser":
                        Integer submituser = Integer.parseInt(keyword);
                        row_count = bugRepository.findAllBySubmituser(submituser).size();
                        max_page = row_count / size; // 计算最大分页数
                        if (row_count % size != 0) {
                            max_page += 1;
                        }
                        if (page > max_page) {
                            page = 1;
                        }
                        pageable = new PageRequest(page - 1, size, sort);
                        bugs = bugRepository.findAllBySubmituser(submituser, pageable);
                        break;
                }
                break;
        }

        if (bugs == null ||
                ((!bugs.isEmpty()) &&
                        bugs.get(0) == null)) {    // 当搜索对象为漏洞ID或用户ID时会出现这种情况
            bugs = new ArrayList<Bug>(0);
        }

        List<FormatedBug> formatedBugs = new ArrayList<FormatedBug>();
        for (Bug bug : bugs) {
            formatedBugs.add(bug.getFormatedBug());
        }
        model.addAttribute("bugs", formatedBugs);
        model.addAttribute("page", page);
        model.addAttribute("max_page", max_page);
        // 生成翻页按钮序列
        int start = page - 5;
        int end = page + 5;
        if (start < 1) {
            end += 1 - start;
            start = 1;
        }
        if (end > max_page) {
            start -= end - max_page;
            end = (int) max_page;
        }
        if (start < 1) {
            start = 1;
        }
        List<Integer> pages = new ArrayList();
        for (int i = start; i <= end; i++) {
            pages.add(i);
        }
        model.addAttribute("identity", (Integer) session.getAttribute("identity"));
        model.addAttribute("pages", pages);

        return "buglist";

    }

    @GetMapping("/showinfo")
    String showinfoPage(@RequestParam(required = true) Long id, Model model, HttpSession session) {
        FormatedBug bug = bugRepository.findBugByid(id).getFormatedBug();
        Integer userid = (Integer) session.getAttribute("userid");
        Integer identity = (Integer) session.getAttribute("identity");
        if ((identity.equals(0) && userid.equals(bug.getSubmituser())) || (identity.equals(1))) {
            model.addAttribute("bug", bug);
            return "showinfo";
        } else {
            model.addAttribute("message", "当前账号为普通用户，无法访问该资源");
            return "message";
        }
    }

    @GetMapping("/bugpanel")
    String bugpanelPage(HttpSession session, Model model) {
        model.addAttribute("identity", (Integer) session.getAttribute("identity"));
        return "bugpanel";
    }


    @RequestMapping("/fileupload")
    @ResponseBody
    void fileupload(@RequestParam("upload") MultipartFile file, HttpServletResponse response) throws FileNotFoundException, IOException {

        System.out.println(file.getOriginalFilename());
        Long date = new Date().getTime();
        String rootPath = ResourceUtils.getURL("classpath:").getPath();
        System.out.println(rootPath);
        File pic_path = new File(rootPath, "static/img");
        if (!pic_path.exists()) {
            pic_path.mkdirs();
        }
        File nf = new File(rootPath + "static/img/", date + file.getOriginalFilename());
        String img_url = "/img/" + date + file.getOriginalFilename();
        FileOutputStream out = new FileOutputStream(nf);
        out.write(file.getBytes());
        out.flush();
        out.close();
        response.setCharacterEncoding("UTF-8");
        response.setHeader("content-type", "text/html;charset=UTF-8");
        response.getWriter().write("{\n\"uploaded\":1,\n\"filename\":\"" + date + file.getOriginalFilename() + "\",\n\"url\":\"" + img_url + "\"\n}");
    }
}
