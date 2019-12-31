package com.hair.testZuulRoutes;

import com.hair.common.RecodeLog;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@Controller
public class TestZuulRoutes {
    Logger logger = Logger.getLogger(TestZuulRoutes.class);
    @RecodeLog
    @RequestMapping("/testPrefixA")
    @ResponseBody
    public String testPrefixA(){
        return "trueA";
    }

    @RecodeLog
    @RequestMapping("/testPrefixB")
    @ResponseBody
    public String testPrefixB(){
        return "trueB";
    }

    @RecodeLog
    @RequestMapping("/testPrefixC")
    @ResponseBody
    public String testPrefixC(){
        return "trueB";
    }
}
