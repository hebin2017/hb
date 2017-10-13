package com.maiyuan.test.entity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Administrator on 2017/8/14.
 */
public class Test {


    public static Date getLastDayOfMonth(Date date) {
        Calendar cDay1 = Calendar.getInstance();
        cDay1.setTime(date);
        int lastDay = cDay1.getActualMaximum(Calendar.DAY_OF_MONTH);
        Date lastDate = cDay1.getTime();
        lastDate.setDate(lastDay);
        return lastDate;
    }
    public static void main(String[] args) {
        Calendar c = Calendar.getInstance();
        try {
            c.setTime(getLastDayOfMonth(new SimpleDateFormat("yyyyMM").parse("201709")));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        c.set(Calendar.HOUR_OF_DAY, 23);
        c.set(Calendar.MINUTE, 59);
        c.set(Calendar.SECOND, 59);
        c.set(Calendar.MILLISECOND, 999);
        System.out.println(new SimpleDateFormat("yyyyMMdd hh:ss:mm").format(c.getTime()));
    }
}
