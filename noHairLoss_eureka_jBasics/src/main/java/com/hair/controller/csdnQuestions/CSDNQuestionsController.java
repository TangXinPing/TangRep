package com.hair.controller.csdnQuestions;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.hair.utils.ComDate;
import com.hair.utils.DateUtil;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Api("记录csdn上的一些问题")
@RestController
@RequestMapping("/csdn")
public class CSDNQuestionsController {

    //计算给定时间距今年份
    @RequestMapping("/computeYear")
    public int computeYear(){
        ComDate comDate = new ComDate();
        Date date = DateUtil.parseStrToDate("2012-02-12",DateUtil.DATE_FORMAT_YY_MM_DD);
        comDate.setCreateDate(date);
        return comDate.getYear();
    }

    //解析不规则字段
    @RequestMapping("/circulateJson")
    public void circulateJson(){
        //1、定义json数据
        String json="{\"bgyear1\":\"2019\",\"edyear2\":\"2019\",\"edyear3\":\"2019\",\"edyear1\":\"2019\",\"Money3\":\"33333\",\"Money1\":\"11111\",\"Money2\":\"2222\",\"bgyear2\":\"2019\",\"bgyear3\":\"2019\"}";
        //2、解析
        JSONObject jsonObject= JSONObject.parseObject(json);
        Map<String,Integer> resMap=new HashMap<>();
        //3、从1开始,依次循环取出json中字段
        for(int i=1;;i++){
            Integer edyear = jsonObject.getInteger("edyear"+i);
            Integer bgyear = jsonObject.getInteger("bgyear"+i);
            Integer money = jsonObject.getInteger("Money"+i);
            //3.1、如果任一字段为null,则打断循环
            if(edyear==null||bgyear==null||money==null){
                break;
            }
            //3.2、添加结果
            resMap.put("res"+i,(edyear-bgyear)*money);
        }
        //4、打印结果(注意此处使用的是jdk1.8语法lambda表达式)
//        resMap.forEach((k,v)->{
//            System.out.println(k+":"+v);
//        });
        for (Map.Entry<String,Integer> entry : resMap.entrySet()){
            System.out.println(entry.getKey()+entry.getValue());
        }
    }
}
