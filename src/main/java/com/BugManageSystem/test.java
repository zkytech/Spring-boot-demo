package com.BugManageSystem;

import com.BugManageSystem.Entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class test implements CommandLineRunner {
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


    @Override
    public void run(String... args) throws Exception {

        // 初始化测试数据
//        userRepository.save(new User("zky","160811",0));
//        userRepository.save(new User("test","160811",1));
//        userRepository.save(new User("user1","160811",0));

//        typesRepository.save(new Types("SQL注入"));
//        typesRepository.save(new Types("信息泄露"));
//        typesRepository.save(new Types("弱口令"));
//        typesRepository.save(new Types("逻辑"));
//        typesRepository.save(new Types("命令执行"));
//        typesRepository.save(new Types("权限"));
//



//        bugRepository.save(new Bug("测试1",2,"www.hao123.com", "109.123.33.1",0,"测试文本",1,0));
//        bugRepository.save(new Bug("测试2",1,"www.hao123.com", "109.123.33.1",1,"测试文本",1,0));
//        bugRepository.save(new Bug("测试3",4,"www.hao123.com", "109.123.33.1",2,"测试文本",1,0));
//        bugRepository.save(new Bug("测试4",3,"www.hao123.com", "109.123.33.1",0,"测试文本",1,0));
//        bugRepository.save(new Bug("测试5",2,"www.hao123.com", "109.123.33.1",0,"测试文本",2,0));
//        bugRepository.save(new Bug("测试6",2,"www.hao123.com", "109.123.33.1",0,"测试文本",1,0));
//        bugRepository.save(new Bug("测试1",2,"www.hao123.com", "109.123.33.1",0,"测试文本",1,0));
//        bugRepository.save(new Bug("测试2",1,"www.hao123.com", "109.123.33.1",1,"测试文本",1,0));
//        bugRepository.save(new Bug("测试3",4,"www.hao123.com", "109.123.33.1",2,"测试文本",1,0));
//        bugRepository.save(new Bug("测试4",3,"www.hao123.com", "109.123.33.1",0,"测试文本",1,0));
//        bugRepository.save(new Bug("测试5",2,"www.hao123.com", "109.123.33.1",0,"测试文本",2,0));
//        bugRepository.save(new Bug("测试6",2,"www.hao123.com", "109.123.33.1",0,"测试文本",1,0));
//        bugRepository.save(new Bug("测试1",2,"www.hao123.com", "109.123.33.1",0,"测试文本",1,0));
//        bugRepository.save(new Bug("测试2",1,"www.hao123.com", "109.123.33.1",1,"测试文本",1,0));
//        bugRepository.save(new Bug("测试3",4,"www.hao123.com", "109.123.33.1",2,"测试文本",1,0));
//        bugRepository.save(new Bug("测试4",3,"www.hao123.com", "109.123.33.1",0,"测试文本",1,0));
//        bugRepository.save(new Bug("测试5",2,"www.hao123.com", "109.123.33.1",0,"测试文本",2,0));
//        bugRepository.save(new Bug("测试6",6,"www.hao123.com", "109.123.33.1",0,"测试文本",1,0));
//        bugRepository.save(new Bug("测试1",2,"www.hao123.com", "109.123.33.1",0,"测试文本",1,0));
//        bugRepository.save(new Bug("测试2",5,"www.hao123.com", "109.123.33.1",1,"测试文本",1,0));
//        bugRepository.save(new Bug("测试3",4,"www.hao123.com", "109.123.33.1",2,"测试文本",1,0));
//        bugRepository.save(new Bug("测试4",3,"www.hao123.com", "109.123.33.1",0,"测试文本",1,0));
//        bugRepository.save(new Bug("测试5",2,"www.hao123.com", "109.123.33.1",0,"测试文本",2,0));
//        bugRepository.save(new Bug("测试6",2,"www.hao123.com", "109.123.33.1",0,"测试文本",3,0));
//        bugRepository.save(new Bug("测试1",5,"www.hao123.com", "109.123.33.1",0,"测试文本",1,0));
//        bugRepository.save(new Bug("测试2",1,"www.hao123.com", "109.123.33.1",1,"测试文本",1,0));
//        bugRepository.save(new Bug("测试3",4,"www.hao123.com", "109.123.33.1",2,"测试文本",1,0));
//        bugRepository.save(new Bug("测试4",3,"www.hao123.com", "109.123.33.1",0,"测试文本",1,0));
//        bugRepository.save(new Bug("测试5",2,"www.hao123.com", "109.123.33.1",0,"测试文本",2,0));
//        bugRepository.save(new Bug("测试6",2,"www.123.com", "109.123.33.1",0,"测试文本",3,0));
//        bugRepository.save(new Bug("测试1",2,"www.hao123.com", "109.123.33.1",0,"测试文本",1,0));
//        bugRepository.save(new Bug("测试2",1,"www.hao123.com", "109.123.33.1",1,"测试文本",1,0));
//        bugRepository.save(new Bug("测试3",4,"www.hao123.com", "109.123.33.1",2,"测试文本",1,0));
//        bugRepository.save(new Bug("测试4",3,"www.hao123.com", "109.123.33.1",0,"测试文本",1,0));
//        bugRepository.save(new Bug("测试5",2,"www.hao123.com", "109.123.33.1",0,"测试文本",2,0));
//        bugRepository.save(new Bug("测试6",2,"www.hao123.com", "111.123.33.1",0,"测试文本",3,0));
//
//        bugRepository.save(new Bug("测试1",2,"www.hao123.com", "109.123.33.1",0,"测试文本",1,0));
//        bugRepository.save(new Bug("测试2",1,"www.hao123.com", "109.123.33.1",1,"测试文本",1,0));
//        bugRepository.save(new Bug("测试3",4,"www.hao123.com", "109.123.33.1",2,"测试文本",1,0));
//        bugRepository.save(new Bug("测试4",3,"www.hao123.com", "109.123.33.1",0,"测试文本",1,0));
//        bugRepository.save(new Bug("测试5",2,"www.hao123.com", "109.123.33.1",0,"测试文本",2,0));
//        bugRepository.save(new Bug("测试6",2,"www.hao123.com", "109.123.33.1",0,"测试文本",1,0));
//        bugRepository.save(new Bug("测试1",2,"www.hao123.com", "109.123.33.1",0,"测试文本",1,0));
//        bugRepository.save(new Bug("测试2",1,"www.hao123.com", "109.123.33.1",1,"测试文本",1,0));
//        bugRepository.save(new Bug("测试3",4,"www.hao123.com", "109.123.33.1",2,"测试文本",1,0));
//        bugRepository.save(new Bug("测试4",3,"www.hao123.com", "109.123.33.1",0,"测试文本",1,0));
//        bugRepository.save(new Bug("测试5",2,"www.hao123.com", "109.123.33.1",0,"测试文本",2,0));
//        bugRepository.save(new Bug("测试6",2,"www.hao123.com", "109.123.33.1",0,"测试文本",1,0));
//        bugRepository.save(new Bug("测试1",2,"www.hao123.com", "109.123.33.1",0,"测试文本",1,0));
//        bugRepository.save(new Bug("测试2",1,"www.hao123.com", "109.123.33.1",1,"测试文本",1,0));
//        bugRepository.save(new Bug("测试3",4,"www.hao123.com", "109.123.33.1",2,"测试文本",1,0));
//        bugRepository.save(new Bug("测试4",3,"www.hao123.com", "109.123.33.1",0,"测试文本",1,0));
//        bugRepository.save(new Bug("测试5",2,"www.hao123.com", "109.123.33.1",0,"测试文本",2,0));
//        bugRepository.save(new Bug("测试6",6,"www.hao123.com", "109.123.33.1",0,"测试文本",1,0));
//        bugRepository.save(new Bug("测试1",2,"www.hao123.com", "109.123.33.1",0,"测试文本",1,0));
//        bugRepository.save(new Bug("测试2",5,"www.hao123.com", "109.123.33.1",1,"测试文本",1,0));
//        bugRepository.save(new Bug("测试3",4,"www.hao123.com", "109.123.33.1",2,"测试文本",1,0));
//        bugRepository.save(new Bug("测试4",3,"www.hao123.com", "109.123.33.1",0,"测试文本",1,0));
//        bugRepository.save(new Bug("测试5",2,"www.hao123.com", "109.123.33.1",0,"测试文本",2,0));
//        bugRepository.save(new Bug("测试6",2,"www.hao123.com", "109.123.33.1",0,"测试文本",3,0));
//        bugRepository.save(new Bug("测试1",5,"www.hao123.com", "109.123.33.1",0,"测试文本",1,0));
//        bugRepository.save(new Bug("测试2",1,"www.hao123.com", "109.123.33.1",1,"测试文本",1,0));
//        bugRepository.save(new Bug("测试3",4,"www.hao123.com", "109.123.33.1",2,"测试文本",1,0));
//        bugRepository.save(new Bug("测试4",3,"www.hao123.com", "109.123.33.1",0,"测试文本",1,0));
//        bugRepository.save(new Bug("测试5",2,"www.hao123.com", "109.123.33.1",0,"测试文本",2,0));
//        bugRepository.save(new Bug("测试6",2,"www.123.com", "109.123.33.1",0,"测试文本",3,0));
//        bugRepository.save(new Bug("测试1",2,"www.hao123.com", "109.123.33.1",0,"测试文本",1,0));
//        bugRepository.save(new Bug("测试2",1,"www.hao123.com", "109.123.33.1",1,"测试文本",1,0));
//        bugRepository.save(new Bug("测试3",4,"www.hao123.com", "109.123.33.1",2,"测试文本",1,0));
//        bugRepository.save(new Bug("测试4",3,"www.hao123.com", "109.123.33.1",0,"测试文本",1,0));
//        bugRepository.save(new Bug("测试5",2,"www.hao123.com", "109.123.33.1",0,"测试文本",2,0));
//        bugRepository.save(new Bug("测试6",2,"www.hao123.com", "111.123.33.1",0,"测试文本",3,0));
//
//        bugRepository.save(new Bug("测试1",2,"www.hao123.com", "109.123.33.1",0,"测试文本",1,0));
//        bugRepository.save(new Bug("测试2",1,"www.hao123.com", "109.123.33.1",1,"测试文本",1,0));
//        bugRepository.save(new Bug("测试3",4,"www.hao123.com", "109.123.33.1",2,"测试文本",1,0));
//        bugRepository.save(new Bug("测试4",3,"www.hao123.com", "109.123.33.1",0,"测试文本",1,0));
//        bugRepository.save(new Bug("测试5",2,"www.hao123.com", "109.123.33.1",0,"测试文本",2,0));
//        bugRepository.save(new Bug("测试6",2,"www.hao123.com", "109.123.33.1",0,"测试文本",1,0));
//        bugRepository.save(new Bug("测试1",2,"www.hao123.com", "109.123.33.1",0,"测试文本",1,0));
//        bugRepository.save(new Bug("测试2",1,"www.hao123.com", "109.123.33.1",1,"测试文本",1,0));
//        bugRepository.save(new Bug("测试3",4,"www.hao123.com", "109.123.33.1",2,"测试文本",1,0));
//        bugRepository.save(new Bug("测试4",3,"www.hao123.com", "109.123.33.1",0,"测试文本",1,0));
//        bugRepository.save(new Bug("测试5",2,"www.hao123.com", "109.123.33.1",0,"测试文本",2,0));
//        bugRepository.save(new Bug("测试6",2,"www.hao123.com", "109.123.33.1",0,"测试文本",1,0));
//        bugRepository.save(new Bug("测试1",2,"www.hao123.com", "109.123.33.1",0,"测试文本",1,0));
//        bugRepository.save(new Bug("测试2",1,"www.hao123.com", "109.123.33.1",1,"测试文本",1,0));
//        bugRepository.save(new Bug("测试3",4,"www.hao123.com", "109.123.33.1",2,"测试文本",1,0));
//        bugRepository.save(new Bug("测试4",3,"www.hao123.com", "109.123.33.1",0,"测试文本",1,0));
//        bugRepository.save(new Bug("测试5",2,"www.hao123.com", "109.123.33.1",0,"测试文本",2,0));
//        bugRepository.save(new Bug("测试6",6,"www.hao123.com", "109.123.33.1",0,"测试文本",1,0));
//        bugRepository.save(new Bug("测试1",2,"www.hao123.com", "109.123.33.1",0,"测试文本",1,0));
//        bugRepository.save(new Bug("测试2",5,"www.hao123.com", "109.123.33.1",1,"测试文本",1,0));
//        bugRepository.save(new Bug("测试3",4,"www.hao123.com", "109.123.33.1",2,"测试文本",1,0));
//        bugRepository.save(new Bug("测试4",3,"www.hao123.com", "109.123.33.1",0,"测试文本",1,0));
//        bugRepository.save(new Bug("测试5",2,"www.hao123.com", "109.123.33.1",0,"测试文本",2,0));
//        bugRepository.save(new Bug("测试6",2,"www.hao123.com", "109.123.33.1",0,"测试文本",3,0));
//        bugRepository.save(new Bug("测试1",5,"www.hao123.com", "109.123.33.1",0,"测试文本",1,0));
//        bugRepository.save(new Bug("测试2",1,"www.hao123.com", "109.123.33.1",1,"测试文本",1,0));
//        bugRepository.save(new Bug("测试3",4,"www.hao123.com", "109.123.33.1",2,"测试文本",1,0));
//        bugRepository.save(new Bug("测试4",3,"www.hao123.com", "109.123.33.1",0,"测试文本",1,0));
//        bugRepository.save(new Bug("测试5",2,"www.hao123.com", "109.123.33.1",0,"测试文本",2,0));
//        bugRepository.save(new Bug("测试6",2,"www.123.com", "109.123.33.1",0,"测试文本",3,0));
//        bugRepository.save(new Bug("测试1",2,"www.hao123.com", "109.123.33.1",0,"测试文本",1,0));
//        bugRepository.save(new Bug("测试2",1,"www.hao123.com", "109.123.33.1",1,"测试文本",1,0));
//        bugRepository.save(new Bug("测试3",4,"www.hao123.com", "109.123.33.1",2,"测试文本",1,0));
//        bugRepository.save(new Bug("测试4",3,"www.hao123.com", "109.123.33.1",0,"测试文本",1,0));
//        bugRepository.save(new Bug("测试5",2,"www.hao123.com", "109.123.33.1",0,"测试文本",2,0));
//        bugRepository.save(new Bug("测试6",2,"www.hao123.com", "111.123.33.1",0,"测试文本",3,0));
//
//        bugRepository.save(new Bug("测试1",2,"www.hao123.com", "109.123.33.1",0,"测试文本",1,0));
//        bugRepository.save(new Bug("测试2",1,"www.hao123.com", "109.123.33.1",1,"测试文本",1,0));
//        bugRepository.save(new Bug("测试3",4,"www.hao123.com", "109.123.33.1",2,"测试文本",1,0));
//        bugRepository.save(new Bug("测试4",3,"www.hao123.com", "109.123.33.1",0,"测试文本",1,0));
//        bugRepository.save(new Bug("测试5",2,"www.hao123.com", "109.123.33.1",0,"测试文本",2,0));
//        bugRepository.save(new Bug("测试6",2,"www.hao123.com", "109.123.33.1",0,"测试文本",1,0));
//        bugRepository.save(new Bug("测试1",2,"www.hao123.com", "109.123.33.1",0,"测试文本",1,0));
//        bugRepository.save(new Bug("测试2",1,"www.hao123.com", "109.123.33.1",1,"测试文本",1,0));
//        bugRepository.save(new Bug("测试3",4,"www.hao123.com", "109.123.33.1",2,"测试文本",1,0));
//        bugRepository.save(new Bug("测试4",3,"www.hao123.com", "109.123.33.1",0,"测试文本",1,0));
//        bugRepository.save(new Bug("测试5",2,"www.hao123.com", "109.123.33.1",0,"测试文本",2,0));
//        bugRepository.save(new Bug("测试6",2,"www.hao123.com", "109.123.33.1",0,"测试文本",1,0));
//        bugRepository.save(new Bug("测试1",2,"www.hao123.com", "109.123.33.1",0,"测试文本",1,0));
//        bugRepository.save(new Bug("测试2",1,"www.hao123.com", "109.123.33.1",1,"测试文本",1,0));
//        bugRepository.save(new Bug("测试3",4,"www.hao123.com", "109.123.33.1",2,"测试文本",1,0));
//        bugRepository.save(new Bug("测试4",3,"www.hao123.com", "109.123.33.1",0,"测试文本",1,0));
//        bugRepository.save(new Bug("测试5",2,"www.hao123.com", "109.123.33.1",0,"测试文本",2,0));
//        bugRepository.save(new Bug("测试6",6,"www.hao123.com", "109.123.33.1",0,"测试文本",1,0));
//        bugRepository.save(new Bug("测试1",2,"www.hao123.com", "109.123.33.1",0,"测试文本",1,0));
//        bugRepository.save(new Bug("测试2",5,"www.hao123.com", "109.123.33.1",1,"测试文本",1,0));
//        bugRepository.save(new Bug("测试3",4,"www.hao123.com", "109.123.33.1",2,"测试文本",1,0));
//        bugRepository.save(new Bug("测试4",3,"www.hao123.com", "109.123.33.1",0,"测试文本",1,0));
//        bugRepository.save(new Bug("测试5",2,"www.hao123.com", "109.123.33.1",0,"测试文本",2,0));
//        bugRepository.save(new Bug("测试6",2,"www.hao123.com", "109.123.33.1",0,"测试文本",3,0));
//        bugRepository.save(new Bug("测试1",5,"www.hao123.com", "109.123.33.1",0,"测试文本",1,0));
//        bugRepository.save(new Bug("测试2",1,"www.hao123.com", "109.123.33.1",1,"测试文本",1,0));
//        bugRepository.save(new Bug("测试3",4,"www.hao123.com", "109.123.33.1",2,"测试文本",1,0));
//        bugRepository.save(new Bug("测试4",3,"www.hao123.com", "109.123.33.1",0,"测试文本",1,0));
//        bugRepository.save(new Bug("测试5",2,"www.hao123.com", "109.123.33.1",0,"测试文本",2,0));
//        bugRepository.save(new Bug("测试6",2,"www.123.com", "109.123.33.1",0,"测试文本",3,0));
//        bugRepository.save(new Bug("测试1",2,"www.hao123.com", "109.123.33.1",0,"测试文本",1,0));
//        bugRepository.save(new Bug("测试2",1,"www.hao123.com", "109.123.33.1",1,"测试文本",1,0));
//        bugRepository.save(new Bug("测试3",4,"www.hao123.com", "109.123.33.1",2,"测试文本",1,0));
//        bugRepository.save(new Bug("测试4",3,"www.hao123.com", "109.123.33.1",0,"测试文本",1,0));
//        bugRepository.save(new Bug("测试5",2,"www.hao123.com", "109.123.33.1",0,"测试文本",2,0));
//        bugRepository.save(new Bug("测试6",2,"www.hao123.com", "111.123.33.1",0,"测试文本",3,0));
//
//        bugRepository.save(new Bug("测试1",2,"www.hao123.com", "109.123.33.1",0,"测试文本",1,0));
//        bugRepository.save(new Bug("测试2",1,"www.hao123.com", "109.123.33.1",1,"测试文本",1,0));
//        bugRepository.save(new Bug("测试3",4,"www.hao123.com", "109.123.33.1",2,"测试文本",1,0));
//        bugRepository.save(new Bug("测试4",3,"www.hao123.com", "109.123.33.1",0,"测试文本",1,0));
//        bugRepository.save(new Bug("测试5",2,"www.hao123.com", "109.123.33.1",0,"测试文本",2,0));
//        bugRepository.save(new Bug("测试6",2,"www.hao123.com", "109.123.33.1",0,"测试文本",1,0));
//        bugRepository.save(new Bug("测试1",2,"www.hao123.com", "109.123.33.1",0,"测试文本",1,0));
//        bugRepository.save(new Bug("测试2",1,"www.hao123.com", "109.123.33.1",1,"测试文本",1,0));
//        bugRepository.save(new Bug("测试3",4,"www.hao123.com", "109.123.33.1",2,"测试文本",1,0));
//        bugRepository.save(new Bug("测试4",3,"www.hao123.com", "109.123.33.1",0,"测试文本",1,0));
//        bugRepository.save(new Bug("测试5",2,"www.hao123.com", "109.123.33.1",0,"测试文本",2,0));
//        bugRepository.save(new Bug("测试6",2,"www.hao123.com", "109.123.33.1",0,"测试文本",1,0));
//        bugRepository.save(new Bug("测试1",2,"www.hao123.com", "109.123.33.1",0,"测试文本",1,0));
//        bugRepository.save(new Bug("测试2",1,"www.hao123.com", "109.123.33.1",1,"测试文本",1,0));
//        bugRepository.save(new Bug("测试3",4,"www.hao123.com", "109.123.33.1",2,"测试文本",1,0));
//        bugRepository.save(new Bug("测试4",3,"www.hao123.com", "109.123.33.1",0,"测试文本",1,0));
//        bugRepository.save(new Bug("测试5",2,"www.hao123.com", "109.123.33.1",0,"测试文本",2,0));
//        bugRepository.save(new Bug("测试6",6,"www.hao123.com", "109.123.33.1",0,"测试文本",1,0));
//        bugRepository.save(new Bug("测试1",2,"www.hao123.com", "109.123.33.1",0,"测试文本",1,0));
//        bugRepository.save(new Bug("测试2",5,"www.hao123.com", "109.123.33.1",1,"测试文本",1,0));
//        bugRepository.save(new Bug("测试3",4,"www.hao123.com", "109.123.33.1",2,"测试文本",1,0));
//        bugRepository.save(new Bug("测试4",3,"www.hao123.com", "109.123.33.1",0,"测试文本",1,0));
//        bugRepository.save(new Bug("测试5",2,"www.hao123.com", "109.123.33.1",0,"测试文本",2,0));
//        bugRepository.save(new Bug("测试6",2,"www.hao123.com", "109.123.33.1",0,"测试文本",3,0));
//        bugRepository.save(new Bug("测试1",5,"www.hao123.com", "109.123.33.1",0,"测试文本",1,0));
//        bugRepository.save(new Bug("测试2",1,"www.hao123.com", "109.123.33.1",1,"测试文本",1,0));
//        bugRepository.save(new Bug("测试3",4,"www.hao123.com", "109.123.33.1",2,"测试文本",1,0));
//        bugRepository.save(new Bug("测试4",3,"www.hao123.com", "109.123.33.1",0,"测试文本",1,0));
//        bugRepository.save(new Bug("测试5",2,"www.hao123.com", "109.123.33.1",0,"测试文本",2,0));
//        bugRepository.save(new Bug("测试6",2,"www.123.com", "109.123.33.1",0,"测试文本",3,0));
//        bugRepository.save(new Bug("测试1",2,"www.hao123.com", "109.123.33.1",0,"测试文本",1,0));
//        bugRepository.save(new Bug("测试2",1,"www.hao123.com", "109.123.33.1",1,"测试文本",1,0));
//        bugRepository.save(new Bug("测试3",4,"www.hao123.com", "109.123.33.1",2,"测试文本",1,0));
//        bugRepository.save(new Bug("测试4",3,"www.hao123.com", "109.123.33.1",0,"测试文本",1,0));
//        bugRepository.save(new Bug("测试5",2,"www.hao123.com", "109.123.33.1",0,"测试文本",2,0));
//        bugRepository.save(new Bug("测试6",2,"www.hao123.com", "111.123.33.1",0,"测试文本",3,0));
//
//        bugRepository.save(new Bug("测试1",2,"www.hao123.com", "109.123.33.1",0,"测试文本",1,0));
//        bugRepository.save(new Bug("测试2",1,"www.hao123.com", "109.123.33.1",1,"测试文本",1,0));
//        bugRepository.save(new Bug("测试3",4,"www.hao123.com", "109.123.33.1",2,"测试文本",1,0));
//        bugRepository.save(new Bug("测试4",3,"www.hao123.com", "109.123.33.1",0,"测试文本",1,0));
//        bugRepository.save(new Bug("测试5",2,"www.hao123.com", "109.123.33.1",0,"测试文本",2,0));
//        bugRepository.save(new Bug("测试6",2,"www.hao123.com", "109.123.33.1",0,"测试文本",1,0));
//        bugRepository.save(new Bug("测试1",2,"www.hao123.com", "109.123.33.1",0,"测试文本",1,0));
//        bugRepository.save(new Bug("测试2",1,"www.hao123.com", "109.123.33.1",1,"测试文本",1,0));
//        bugRepository.save(new Bug("测试3",4,"www.hao123.com", "109.123.33.1",2,"测试文本",1,0));
//        bugRepository.save(new Bug("测试4",3,"www.hao123.com", "109.123.33.1",0,"测试文本",1,0));
//        bugRepository.save(new Bug("测试5",2,"www.hao123.com", "109.123.33.1",0,"测试文本",2,0));
//        bugRepository.save(new Bug("测试6",2,"www.hao123.com", "109.123.33.1",0,"测试文本",1,0));
//        bugRepository.save(new Bug("测试1",2,"www.hao123.com", "109.123.33.1",0,"测试文本",1,0));
//        bugRepository.save(new Bug("测试2",1,"www.hao123.com", "109.123.33.1",1,"测试文本",1,0));
//        bugRepository.save(new Bug("测试3",4,"www.hao123.com", "109.123.33.1",2,"测试文本",1,0));
//        bugRepository.save(new Bug("测试4",3,"www.hao123.com", "109.123.33.1",0,"测试文本",1,0));
//        bugRepository.save(new Bug("测试5",2,"www.hao123.com", "109.123.33.1",0,"测试文本",2,0));
//        bugRepository.save(new Bug("测试6",6,"www.hao123.com", "109.123.33.1",0,"测试文本",1,0));
//        bugRepository.save(new Bug("测试1",2,"www.hao123.com", "109.123.33.1",0,"测试文本",1,0));
//        bugRepository.save(new Bug("测试2",5,"www.hao123.com", "109.123.33.1",1,"测试文本",1,0));
//        bugRepository.save(new Bug("测试3",4,"www.hao123.com", "109.123.33.1",2,"测试文本",1,0));
//        bugRepository.save(new Bug("测试4",3,"www.hao123.com", "109.123.33.1",0,"测试文本",1,0));
//        bugRepository.save(new Bug("测试5",2,"www.hao123.com", "109.123.33.1",0,"测试文本",2,0));
//        bugRepository.save(new Bug("测试6",2,"www.hao123.com", "109.123.33.1",0,"测试文本",3,0));
//        bugRepository.save(new Bug("测试1",5,"www.hao123.com", "109.123.33.1",0,"测试文本",1,0));
//        bugRepository.save(new Bug("测试2",1,"www.hao123.com", "109.123.33.1",1,"测试文本",1,0));
//        bugRepository.save(new Bug("测试3",4,"www.hao123.com", "109.123.33.1",2,"测试文本",1,0));
//        bugRepository.save(new Bug("测试4",3,"www.hao123.com", "109.123.33.1",0,"测试文本",1,0));
//        bugRepository.save(new Bug("测试5",2,"www.hao123.com", "109.123.33.1",0,"测试文本",2,0));
//        bugRepository.save(new Bug("测试6",2,"www.123.com", "109.123.33.1",0,"测试文本",3,0));
//        bugRepository.save(new Bug("测试1",2,"www.hao123.com", "109.123.33.1",0,"测试文本",1,0));
//        bugRepository.save(new Bug("测试2",1,"www.hao123.com", "109.123.33.1",1,"测试文本",1,0));
//        bugRepository.save(new Bug("测试3",4,"www.hao123.com", "109.123.33.1",2,"测试文本",1,0));
//        bugRepository.save(new Bug("测试4",3,"www.hao123.com", "109.123.33.1",0,"测试文本",1,0));
//        bugRepository.save(new Bug("测试5",2,"www.hao123.com", "109.123.33.1",0,"测试文本",2,0));
//        bugRepository.save(new Bug("测试6",2,"www.hao123.com", "111.123.33.1",0,"测试文本",3,0));

//        departmentRepository.save(new Department("工程部"));
//        departmentRepository.save(new Department("网络部"));
//        departmentRepository.save(new Department("信息部"));
//
//        handlerRepository.save(new Handler("张三","17965264565","1231456416@hotmail.com",1));
//        handlerRepository.save(new Handler("李四","17965262233","3321456416@hotmail.com",1));
//        handlerRepository.save(new Handler("阿斯顿","17965262233","3321456416@hotmail.com",1));
//        handlerRepository.save(new Handler("的改革","17965262233","3321456416@hotmail.com",1));
//        handlerRepository.save(new Handler("犹太人","17965262233","3321456416@hotmail.com",1));
//        handlerRepository.save(new Handler("而感到","17965262233","3321456416@hotmail.com",1));
//        handlerRepository.save(new Handler("进口量","17965262233","3321456416@hotmail.com",1));
//        handlerRepository.save(new Handler("三四","17965262233","3321456416@hotmail.com",1));
//        handlerRepository.save(new Handler("和四","17965262233","3321456416@hotmail.com",1));
//        handlerRepository.save(new Handler("他四三","17965262233","3321456416@hotmail.com",1));
//        handlerRepository.save(new Handler("李大四","17965262233","3321456416@hotmail.com",1));
//        handlerRepository.save(new Handler("李未四","17965262233","3321456416@hotmail.com",1));
//        handlerRepository.save(new Handler("李其四","17965262233","3321456416@hotmail.com",1));
//        handlerRepository.save(new Handler("李哦四","17965262233","3321456416@hotmail.com",1));
//        handlerRepository.save(new Handler("李可四","17965262233","3321456416@hotmail.com",1));
//        handlerRepository.save(new Handler("州三四","17965262233","3321456416@hotmail.com",1));
//        handlerRepository.save(new Handler("周平","17965262233","3321456416@hotmail.com",1));
//        handlerRepository.save(new Handler("周太阳","17965262233","3321456416@hotmail.com",1));
//        handlerRepository.save(new Handler("周流派","17965262233","3321456416@hotmail.com",1));
//        handlerRepository.save(new Handler("周早在","17965262233","3321456416@hotmail.com",1));
//
//        handlerRepository.save(new Handler("张三三","17965264565","1231456416@hotmail.com",2));
//        handlerRepository.save(new Handler("李四的","17965262233","3321456416@hotmail.com",2));
//        handlerRepository.save(new Handler("阿斯顿的","17965262233","3321456416@hotmail.com",2));
//        handlerRepository.save(new Handler("的改革未","17965262233","3321456416@hotmail.com",2));
//        handlerRepository.save(new Handler("犹太人1","17965262233","3321456416@hotmail.com",2));
//        handlerRepository.save(new Handler("而感到广泛","17965262233","3321456416@hotmail.com",2));
//        handlerRepository.save(new Handler("进口量3","17965262233","3321456416@hotmail.com",2));
//        handlerRepository.save(new Handler("三四2","17965262233","3321456416@hotmail.com",2));
//        handlerRepository.save(new Handler("和四1","17965262233","3321456416@hotmail.com",2));
//        handlerRepository.save(new Handler("他四三3","17965262233","3321456416@hotmail.com",2));
//        handlerRepository.save(new Handler("李大四2","17965262233","3321456416@hotmail.com",2));
//        handlerRepository.save(new Handler("李未四1","17965262233","3321456416@hotmail.com",2));
//        handlerRepository.save(new Handler("李其四2","17965262233","3321456416@hotmail.com",2));
//        handlerRepository.save(new Handler("李哦四3","17965262233","3321456416@hotmail.com",2));
//        handlerRepository.save(new Handler("李可四1","17965262233","3321456416@hotmail.com",2));
//        handlerRepository.save(new Handler("州三四1","17965262233","3321456416@hotmail.com",2));
//        handlerRepository.save(new Handler("周平1","17965262233","3321456416@hotmail.com",2));
//        handlerRepository.save(new Handler("周太阳1","17965262233","3321456416@hotmail.com",2));
//        handlerRepository.save(new Handler("周流派1","17965262233","3321456416@hotmail.com",2));
//        handlerRepository.save(new Handler("周早在1","17965262233","3321456416@hotmail.com",2));
//
//        handlerRepository.save(new Handler("三","17965264565","1231456416@hotmail.com",3));
//        handlerRepository.save(new Handler("四","17965262233","3321456416@hotmail.com",3));
//        handlerRepository.save(new Handler("阿顿","17965262233","3321456416@hotmail.com",3));
//        handlerRepository.save(new Handler("的革","17965262233","3321456416@hotmail.com",3));
//        handlerRepository.save(new Handler("犹人","17965262233","3321456416@hotmail.com",3));
//        handlerRepository.save(new Handler("而到","17965262233","3321456416@hotmail.com",3));
//        handlerRepository.save(new Handler("进量","17965262233","3321456416@hotmail.com",3));
//        handlerRepository.save(new Handler("三四","17965262233","3321456416@hotmail.com",3));
//        handlerRepository.save(new Handler("和四","17965262233","3321456416@hotmail.com",3));
//        handlerRepository.save(new Handler("他四三","17965262233","3321456416@hotmail.com",3));
//        handlerRepository.save(new Handler("大四","17965262233","3321456416@hotmail.com",3));
//        handlerRepository.save(new Handler("未四","17965262233","3321456416@hotmail.com",3));
//        handlerRepository.save(new Handler("其四","17965262233","3321456416@hotmail.com",3));
//        handlerRepository.save(new Handler("哦四","17965262233","3321456416@hotmail.com",3));
//        handlerRepository.save(new Handler("可四","17965262233","3321456416@hotmail.com",3));
//        handlerRepository.save(new Handler("三四","17965262233","3321456416@hotmail.com",3));
//        handlerRepository.save(new Handler("平","17965262233","3321456416@hotmail.com",3));
//        handlerRepository.save(new Handler("太阳","17965262233","3321456416@hotmail.com",3));
//        handlerRepository.save(new Handler("流派","17965262233","3321456416@hotmail.com",3));
//        handlerRepository.save(new Handler("早在","17965262233","3321456416@hotmail.com",3));



    }
}
