package com.hair.threadPool;


import org.apache.log4j.Logger;

public class WorkThread implements Runnable {

    Logger logger = Logger.getLogger(getClass());

    @Override
    public void run() {
        try {
            logger.info(Thread.currentThread().getName()+" RUNNING..");
//            Thread.sleep(3);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
