package basic.timeClass;

import java.util.Calendar;
import java.util.Date;

public class CalendarDemo {
    public static void main(String[] args) {

        setTest();
    }

    //使用get相关的方法获取时间的某些属性
    public static void getTest(){
        Calendar instance = Calendar.getInstance();
        System.out.println(instance);
        //java.util.GregorianCalendar[time=1658834386321,areFieldsSet=true,areAllFieldsSet=true,lenient=true,
        // zone=sun.util.calendar.ZoneInfo[id="Asia/Shanghai",offset=28800000,dstSavings=0,useDaylight=false,
        // transitions=29,lastRule=null],firstDayOfWeek=1,minimalDaysInFirstWeek=1,ERA=1,YEAR=2022,MONTH=6,
        // WEEK_OF_YEAR=31,WEEK_OF_MONTH=5,DAY_OF_MONTH=26,DAY_OF_YEAR=207,DAY_OF_WEEK=3,
        // DAY_OF_WEEK_IN_MONTH=4,AM_PM=1,HOUR=7,HOUR_OF_DAY=19,MINUTE=19,SECOND=46,
        // MILLISECOND=321,ZONE_OFFSET=28800000,DST_OFFSET=0]

        //提取有效信息
        int year = instance.get(Calendar.YEAR);  //2022
        int month = instance.get(Calendar.MONTH) + 1; //7
        int date = instance.get(Calendar.DATE); //26
        int hour = instance.get(Calendar.HOUR_OF_DAY); //19
        int minutes = instance.get(Calendar.MINUTE); //25
        int second = instance.get(Calendar.SECOND); //2

        System.out.println(year);
        System.out.println(month);
        System.out.println(date);
        System.out.println(hour);
        System.out.println(minutes);
        System.out.println(second);

    }

    //使用set相关的方法设置

    public static void setTest(){
        Date date = new Date();
        Calendar instance = Calendar.getInstance();
        instance.setTime(date); //把Date转换为Calendar
        //instance.setTime(new Date());

        System.out.println(instance.get(Calendar.YEAR)); //  年 :2022
        System.out.println(instance.get(Calendar.MONTH)+1); // 月份：从0开始的 :7
        System.out.println(instance.get(Calendar.DATE)); // 日 :26



    }
}
