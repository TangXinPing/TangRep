package com.hair.feignint;

import com.hair.pojo.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//加此注解表示我要调用，注册到eureka里面的哪个服务，里面写服务名
@FeignClient(value = "noHairLoss-eurake-user")
public interface UserClientFeign {



    /**
     * 注解中指定要调用哪个接口
     * @param emoji
     * @return
     */
    @RequestMapping(value="/user/judgeEmoji/{emoji}",method = RequestMethod.GET)
    public String judgeEmoji(@PathVariable(value = "emoji") String emoji);

    @RequestMapping(value="/user/detail",method = RequestMethod.GET)
    public User getUser();

    @RequestMapping(value = "/user/detail",method = RequestMethod.GET)
    public User getMapperUser();

    @RequestMapping(value = "/exception/doubleCatch",method = RequestMethod.GET)
    public String doubleCatch();

}