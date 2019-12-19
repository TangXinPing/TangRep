package com.hair;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class BasicsApplication {
    public static void main(String args[]){
        SpringApplication.run(BasicsApplication.class,args);
    }
}
