package com.hair.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Controller
@RequestMapping("/csdnThread")
public class SingletonPattern {
    @RequestMapping("/singletonPattern")
    public void singletonPattern(){
        /**
         * java中的四种线程池
         *https://www.cnblogs.com/baizhanshi/p/5469948.html捡到宝了
         */
        ExecutorService executorService = Executors.newCachedThreadPool();
        for(int i =0;i<3000;i++){
            executorService.execute(new addNum());
        }
        executorService.shutdown();
        while (!executorService.isTerminated()){
            System.out.println("temp = "+Singletion2.getInstance().temp);
        }
    }
}
class addNum implements Runnable{
    @Override
    public void run() {
        Singletion2 singletion2 = Singletion2.getInstance();
        try{
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        singletion2.temp = (singletion2.temp+1);
        System.out.println(Thread.currentThread().getName()+";Temp="+singletion2.temp);
    }
}

class Singletion2{
    private static Singletion2 singletion2;
    public static volatile int temp =128;

    public Singletion2() { }

    public Singletion2(int temp) {
        this.temp = temp;

    }

    public static synchronized Singletion2 getInstance(){
        if(singletion2==null){
            singletion2 = new Singletion2();
        }
        return singletion2;
    }
}
