package com.hair.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/exception")
public class ExceptionController {
    @RequestMapping("/doubleCatch")
    public Object doubleCatch(){
        String result = "";
        String a = null;
        try{
            try{
                a.getBytes();
            }catch (IllegalAccessError e){
                result = result +"ExceptionCatch";
            }
            a="执行了";
        }catch (Exception e){
            result =result+"ExceptionCatch";
        }
        return result;
    }
}
