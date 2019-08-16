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
         * 创建一个可缓存的线程池，如果线程池的大小超过了处理任务所需要的线程，就会回收部分的线程（60秒不执行任务的）
         * 任务数量增加，线程池大小不够，会添加新的线程
         * 不会对线程大小做限制，线程池的大小依赖于JVM能够创建的最大线程的大小
         */
        ExecutorService executorService = Executors.newCachedThreadPool();
        for(int i =0;i<3000;i++){
            /**
             * 一个任务通过execute（Runnable）方法被添加到线程池，任务就是一个Runnable类型的对象，
             * 任务执行的方法，就是Runnable的run方法
             *
             */
            executorService.execute(new addNum());
        }
        /**
         * shutdown调用后不可以再开始新的任务，已经submit进去的任务会执行
         * 还有一个方法是shutdownNow方法，这个会返回现在还没开
         */
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
