package com.zkytech.Autowired_Example;
import org.springframework.stereotype.Component;

@Component

public class student {

    student(){
        System.out.println("Student1");
    }
    public void ann(){
        System.out.println("这里是Student");
    }

}
