package com.alhas2024.spring2024;

import org.springframework.stereotype.Service;

@Service
public class MyFirstService {
    private final MyFirstClass myFirstClass;

    public MyFirstService(MyFirstClass myFirstClass) {
        this.myFirstClass = myFirstClass;
    }
    public String toTellingStory(){
        return "\n the dependency is saying " + myFirstClass.sayHello();
    }

}
