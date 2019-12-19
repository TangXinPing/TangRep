package com.hair.controller.exception;

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
            a="执行了";//这句不会执行，程序直接从try中的异常，跳入下面的总catch
        }catch (Exception e){
            result =result+"ExceptionCatch";
        }
        return result;
    }
}
