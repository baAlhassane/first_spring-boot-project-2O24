package com.alhas2024.spring2024;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


public class MyFirstClass {
    private String myvar;

    public MyFirstClass(String s){
        this.myvar=s;
    }
    public String sayHello(){
        return " Hello MyfirtClass => "+myvar;

    }
}
