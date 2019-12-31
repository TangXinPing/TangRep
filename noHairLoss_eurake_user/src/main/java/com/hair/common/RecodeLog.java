package com.hair.common;

import org.springframework.stereotype.Component;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;
import java.lang.annotation.RetentionPolicy;

@Target({ElementType.METHOD})  //目标是方法
@Retention(RetentionPolicy.RUNTIME)
public @interface RecodeLog {
}
