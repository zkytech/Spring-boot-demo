package com.zkytech.DataBaseIO_Example;

import com.zkytech.DataBaseIO_Example.User;
import com.zkytech.DataBaseIO_Example.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

@Component
public class UserPages implements CommandLineRunner {
    @Autowired
    UserRepository repository;

    @Override
    public void run(String... args) throws Exception {
        Sort sort = new Sort(Sort.Direction.ASC, "id");
        Pageable pageable = new PageRequest(2,7,sort);
        for(User user:repository.findAll(pageable)){
            System.out.println(user);
        }

    }
}
