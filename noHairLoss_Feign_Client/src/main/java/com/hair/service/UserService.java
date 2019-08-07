package com.hair.service;

import com.hair.feignint.UserClientFeign;
import com.hair.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//加此注解表示我要调用，注册到eureka里面的哪个服务，里面写服务名
@Service
public class UserService {

    @Autowired
    UserClientFeign userClientFeign;

    /**
     * 注解中指定要调用哪个接口，参数正常写就好。
     * @param emoji
     * @return
     */
    public String judgeEmoji(@PathVariable(value = "emoji")String emoji){
        return userClientFeign.judgeEmoji(emoji);
    }

    public User getUser(){
        return userClientFeign.getUser();
    }

    public User getMapperUser(){
        return userClientFeign.getMapperUser();
    }

    public String doubleCatch(){
        return userClientFeign.doubleCatch();
    }

}
