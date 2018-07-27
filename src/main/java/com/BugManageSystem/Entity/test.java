package com.BugManageSystem.Entity;

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

    @Override
    public void run(String... args) throws Exception {
//
//        User user = userRepository.findUserById(1);
//        System.out.println(user);
//
//        Types type = typesRepository.findTypesById(2);
//        System.out.println(type);
//        bugRepository.save(new Bug("测试1",2,"www.hao123.com", "109.123.33.1",0,"测试文本",1));
//        bugRepository.save(new Bug("测试2",1,"www.hao123.com", "109.123.33.1",1,"测试文本",1));
//        bugRepository.save(new Bug("测试3",4,"www.hao123.com", "109.123.33.1",2,"测试文本",1));
//        bugRepository.save(new Bug("测试4",3,"www.hao123.com", "109.123.33.1",0,"测试文本",1));
//        bugRepository.save(new Bug("测试5",2,"www.hao123.com", "109.123.33.1",0,"测试文本",2));
//        bugRepository.save(new Bug("测试6",2,"www.hao123.com", "109.123.33.1",0,"测试文本",1));
//        bugRepository.save(new Bug("测试1",2,"www.hao123.com", "109.123.33.1",0,"测试文本",1));
//        bugRepository.save(new Bug("测试2",1,"www.hao123.com", "109.123.33.1",1,"测试文本",1));
//        bugRepository.save(new Bug("测试3",4,"www.hao123.com", "109.123.33.1",2,"测试文本",1));
//        bugRepository.save(new Bug("测试4",3,"www.hao123.com", "109.123.33.1",0,"测试文本",1));
//        bugRepository.save(new Bug("测试5",2,"www.hao123.com", "109.123.33.1",0,"测试文本",2));
//        bugRepository.save(new Bug("测试6",2,"www.hao123.com", "109.123.33.1",0,"测试文本",1));
//        bugRepository.save(new Bug("测试1",2,"www.hao123.com", "109.123.33.1",0,"测试文本",1));
//        bugRepository.save(new Bug("测试2",1,"www.hao123.com", "109.123.33.1",1,"测试文本",1));
//        bugRepository.save(new Bug("测试3",4,"www.hao123.com", "109.123.33.1",2,"测试文本",1));
//        bugRepository.save(new Bug("测试4",3,"www.hao123.com", "109.123.33.1",0,"测试文本",1));
//        bugRepository.save(new Bug("测试5",2,"www.hao123.com", "109.123.33.1",0,"测试文本",2));
//        bugRepository.save(new Bug("测试6",6,"www.hao123.com", "109.123.33.1",0,"测试文本",1));
//        bugRepository.save(new Bug("测试1",2,"www.hao123.com", "109.123.33.1",0,"测试文本",1));
//        bugRepository.save(new Bug("测试2",5,"www.hao123.com", "109.123.33.1",1,"测试文本",1));
//        bugRepository.save(new Bug("测试3",4,"www.hao123.com", "109.123.33.1",2,"测试文本",1));
//        bugRepository.save(new Bug("测试4",3,"www.hao123.com", "109.123.33.1",0,"测试文本",1));
//        bugRepository.save(new Bug("测试5",2,"www.hao123.com", "109.123.33.1",0,"测试文本",2));
//        bugRepository.save(new Bug("测试6",2,"www.hao123.com", "109.123.33.1",0,"测试文本",3));
//        bugRepository.save(new Bug("测试1",5,"www.hao123.com", "109.123.33.1",0,"测试文本",1));
//        bugRepository.save(new Bug("测试2",1,"www.hao123.com", "109.123.33.1",1,"测试文本",1));
//        bugRepository.save(new Bug("测试3",4,"www.hao123.com", "109.123.33.1",2,"测试文本",1));
//        bugRepository.save(new Bug("测试4",3,"www.hao123.com", "109.123.33.1",0,"测试文本",1));
//        bugRepository.save(new Bug("测试5",2,"www.hao123.com", "109.123.33.1",0,"测试文本",2));
//        bugRepository.save(new Bug("测试6",2,"www.123.com", "109.123.33.1",0,"测试文本",3));
//        bugRepository.save(new Bug("测试1",2,"www.hao123.com", "109.123.33.1",0,"测试文本",1));
//        bugRepository.save(new Bug("测试2",1,"www.hao123.com", "109.123.33.1",1,"测试文本",1));
//        bugRepository.save(new Bug("测试3",4,"www.hao123.com", "109.123.33.1",2,"测试文本",1));
//        bugRepository.save(new Bug("测试4",3,"www.hao123.com", "109.123.33.1",0,"测试文本",1));
//        bugRepository.save(new Bug("测试5",2,"www.hao123.com", "109.123.33.1",0,"测试文本",2));
//        bugRepository.save(new Bug("测试6",2,"www.hao123.com", "111.123.33.1",0,"测试文本",3));
    }
}
