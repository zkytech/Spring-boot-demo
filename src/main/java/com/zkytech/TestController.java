package com.zkytech;

import com.zkytech.DataBaseIO_Example.User;
import com.zkytech.DataBaseIO_Example.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;


@Controller

public class TestController {
    @Autowired
    UserRepository repository;

    @PostMapping("/adduser")
    @ResponseBody
    String addUser(User user, @RequestParam(required = true) MultipartFile file) throws IOException{

        System.out.println("文件名称："+file.getOriginalFilename()+"\n文件类型："+file.getContentType()+"\n文件大小："+file.getSize());

        File nf = new File("/home/zky/桌面","test"+file.getOriginalFilename());
        FileOutputStream out = new FileOutputStream(nf);
        out.write(file.getBytes());
        out.flush();
        out.close();
        repository.save(user);
        return "<script>alert('success')</script>";
    }

    @GetMapping("/")
    String addForm(){
        return "addform";
    }
}
