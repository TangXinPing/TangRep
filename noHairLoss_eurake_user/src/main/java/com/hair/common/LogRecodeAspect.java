package com.hair.common;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;
import sun.rmi.runtime.Log;

import javax.annotation.Resource;
import java.util.Arrays;


@Aspect
@Component
public class LogRecodeAspect {
    private static Logger logger = Logger.getLogger(LogRecodeAspect.class);


    @Pointcut("@annotation(com.hair.common.RecodeLog)")
    public  void userLogAspect() {}

    @Before("userLogAspect()")
    public void doBeforedMethod(JoinPoint jp) {
        String className = jp.getSignature().getDeclaringTypeName();
        String[] classNameArray = className.split("\\.");
        className = classNameArray[classNameArray.length-1];
        //获取method名字
        String methodName =jp.getSignature().getName();
        logger.info(className+"类，执行" + methodName+"方法==============================================================" );
        Object[] args = jp.getArgs();
        //关于这里为什么取不到参数，https://blog.csdn.net/u013041642/article/details/81209404
        for (Object arg : args) {
            logger.info("参数="+arg+" ");
        }
    }

    @AfterReturning(value = "userLogAspect()",returning = "returnValue")
    public void doAfterMethod(JoinPoint jp,Object returnValue){
        String className = jp.getSignature().getDeclaringTypeName();
        String[] classNameArray = className.split("\\.");
        className = classNameArray[classNameArray.length-1];
        //获取method名字
        String methodName =jp.getSignature().getName();
        logger.info("返回值："+returnValue);
        logger.info(className+"类，退出" + methodName+"方法==============================================================" );
    }
}
