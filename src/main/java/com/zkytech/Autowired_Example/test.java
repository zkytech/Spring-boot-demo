package com.zkytech.Autowired_Example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties
public class test implements CommandLineRunner {
    @Autowired
    school school1;

    @Override
    public void run(String... args) throws Exception {
        school1.announce();
    }
}
