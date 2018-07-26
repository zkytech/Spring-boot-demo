package com.zkytech;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@SpringBootApplication
@Controller

public class zkytechApplication {

    @RequestMapping("/")
    @ResponseBody
    String index(){
        return "Hello World";
    }

    public static void main(String[] args){
        SpringApplication.run(zkytechApplication.class);

    }

}
