package com.alhas2024.spring2024;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class FirstController {


    @GetMapping("/hello")
    //@ResponseStatus(HttpStatus.ACCEPTED)
        String myHello(){
            return "<h1> Mys Hello Firt controller ! </h1> "+HttpStatus.ACCEPTED;
        }

        @PostMapping("/post")
    String post(
            @RequestBody String message){
        return " request accept and post is \n "+ message;
        }
    @PostMapping("/post-order")
String post(
            @RequestBody Order message){
        return message.toString();
    }

    @PostMapping("/post-record")
    String postRecord(
            @RequestBody OrderRecord message){
        return message.toString();
    }
    @GetMapping("/get-order/{message}")
    String getRecord(
            @PathVariable String message){
        return "my name is "+message;
    }
     //http://localhost:8080/get-orderParam?user-name=alhousseynou&last-name=BA
    @GetMapping("/get-orderParam")
    String getOrderParam(
            @RequestParam("user-name") String userName,
            @RequestParam("last-name") String lastName

            ){
        return "my name is "+userName +" " +lastName;
    }


}

