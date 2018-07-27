package com.zkytech.DataBaseIO_Example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DataInitialization implements CommandLineRunner {
    @Autowired
    UserRepository repository;

    @Override
    public void run(String... args) throws Exception {
        repository.save(new User("Jack", "Bauer@gmail.com"));
        repository.save(new User("Chloe", "OBrian@gmail.com"));
        repository.save(new User("Kim", "BauerKin@gmail.com"));
        repository.save(new User("David", "Palmer@gmail.com"));
        repository.save(new User("Michelle", "Dessler@gmail.com"));
        System.out.println("User found with find All()");
        System.out.println("------------------------------");
//        for (User user: repository.findAll()){
//            System.out.println(user);
//        }

        System.out.println(repository.findUserById(new Long(2)));
    }

    public List<User> helloWorld(){

        return null;
    }

}
