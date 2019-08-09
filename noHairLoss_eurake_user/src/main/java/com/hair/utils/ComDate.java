package com.hair.utils;

import java.util.Calendar;
import java.util.Date;

/**
 * 计算设置日期距今年数
 */
public class ComDate {
    private int years;
    private Date createDate;
    private Date nowDate;

    public int getYear(){
        //设置以前的日期
        Calendar before = Calendar.getInstance();
        /*
        Calendar也许不可以这样子setTime
         */
        before.setTime(createDate);


        Calendar now = Calendar.getInstance();

        //年份查=现在的年份-以前的年份
        years = now.get(Calendar.YEAR) - now.get(Calendar.YEAR);

        return years;

    }

    public int getYears() {
        return years;
    }

    public void setYears(int years) {
        this.years = years;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getNowDate() {
        return nowDate;
    }

    public void setNowDate(Date nowDate) {
        this.nowDate = nowDate;
    }
}
