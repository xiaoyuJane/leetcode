package basic.timeClass;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class SimpleDateFormatDemo {
    public static void main(String[] args) throws ParseException {
//        formateTest();
//        parseTest();
        timeDiff();
    }

    public static void timeDiff() throws ParseException {

        //1.格式化时间
        String s1 = "2021-08-12 12:00:00"; // 开始时间
        String s2 = "2021-08-12 14:35:00"; // 结束时间

        //2.把字符串转换为时间戳 String->Date->getTime()
        SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
        Date d1 = sdf.parse(s1);
        Date d2 = sdf.parse(s2);

        //计算时间差:先要获取时间毫秒形式（long类型） 再做差
        long long1 = d1.getTime();
        long long2 = d2.getTime();

        //3.计算ms级别时间差，取绝对值
        long diffTime = Math.abs(long1 - long2);

        // 4.秒级别时间差
        long diffSec = diffTime / 1000;

        // 5.分级别时间差
        long diffMin = diffSec / 60;

        //6.显示 xx小时xx分钟
        long displayHours = diffMin / 60; // 小时
        long displayMin = diffMin % 60; //分钟

        System.out.println("您学习的时长为："+displayHours+"小时"+displayMin+"分钟"); //您学习的时长为：2小时35分钟
    }


    public static void formateTest(){
        Date date = new Date();
        System.out.println(date); //Tue Jul 26 19:40:07 CST 2022

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); // 设置格式化时间的模式
        String format1 = format.format(date);
        System.out.println(format1); //2022-07-26 19:40:07
    }

    public static void parseTest() throws ParseException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一个时间(yyyy-MM-dd HH:mm:ss)：");
        String s = scanner.nextLine();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = format.parse(s);
        System.out.println(date);

        /**
         * 请输入一个时间(yyyy-MM-dd HH:mm:ss)：
         * 2022-01-21 10:10:10
         * Fri Jan 21 10:10:10 CST 2022
         */


    }
}
