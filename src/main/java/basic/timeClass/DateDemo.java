package basic.timeClass;

import java.util.Date;

public class DateDemo {
    public static void main(String[] args) {
        Date date = new Date(); //系统时间
        System.out.println(date); //Tue Jul 26 19:06:34 CST 2022

        int year = date.getYear();
        int month = date.getMonth();
        int date1 = date.getDate();
        int hours = date.getHours();
        long time = date.getTime();
        System.out.println(year+1900); //年份是从1900年开始算的:  2022
        System.out.println(month +1);  //月份是从0开始算的: 7
        System.out.println(date1); //天: 26
        System.out.println(hours); //小时: 19
        System.out.println(time);  //时间戳，ms :1658833594884

    }
}

/**
 * new Date().getYear()+1900  年
 * new Date().getMonth()+1  月
 * new Date().getDate()  日
 * new Date().getHours() 时
 * new Date().getTime()  时间戳
 *
 */