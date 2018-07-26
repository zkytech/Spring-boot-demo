package com.zkytech.Autowired_Example;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component()
public class school {

    @Autowired
    school(student student1){
        student1.ann();
        System.out.println("school1");
    }
    public void announce(){
        System.out.println("这里是学校");
    }
}
