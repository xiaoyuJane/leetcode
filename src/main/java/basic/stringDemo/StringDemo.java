package basic.stringDemo;

import java.util.Scanner;

public class StringDemo {
    public static void main(String[] args) {

//        concatTest();
//        test();
        equalTest();
    }

    /**
     *   字符串是不可变的数据类型
     *   几乎所有的字符串操作都会返回一个新字符串
     */
    public static void concatTest(){
        String s = "我的名字叫李华";
        s.concat("hhh"); //拼接对原串不影响
        System.out.println(s);// 我的名字叫李华

        String s1 = s.concat("hhh"); //用新变量来接拼接后的值
        System.out.println(s1);//我的名字叫李华hhh


        String str1 = "李华喜欢看李华的视频";
        str1.replace("李华","张三"); //  并没有替换 字符串是不变的str1还是str1
        System.out.println(str1); //李华喜欢看李华的视频

        String str2 = str1.replace("李华","张三");//几乎所有的字符串操作都会返回一个新字符串 新串要用新变量接
        System.out.println(str2);//张三喜欢看张三的视频
    }

    /**
     * 请输入验证码(AAkm)
     * aakm
     * 欢迎参加英语沙龙活动！
     * 5
     */
    public static void equalTest(){
        // 接受邀请参加活动的李华到现场后要输入验证码
        String code = "AAkm";
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入验证码("+code+")");

        String userInput = sc.nextLine();

        if(code.equalsIgnoreCase("aakm")){  // 忽略大小写判断两边的内容是否一样
            System.out.println("欢迎参加英语沙龙活动！");
        }else{
            System.out.println("您未受到邀请，请现场报名！");
        }

        String str = "李华玩得很开心！";
        System.out.println(str.indexOf("开心"));// 5 计算给出字符串第一个出现的位置
    }


    public static void test(){
        String s = "我的名字叫李华";
        // 获取第0个位置的字符
        System.out.println(s.charAt(0)); //我

        System.out.println(s.contains("李华")); //true
        System.out.println(s.contains("牛津")); //false
        System.out.println("邀请李华来参加英语沙龙活动".endsWith("活动"));//true 判断是否以xxx为结尾
        System.out.println("邀请李华来参加英语沙龙活动".startsWith("李华"));//false 判断是否以xxx开头

        String str2 = "李华成绩很好";
        System.out.println(str2.length()); // 6 计算字符串的长度


        String str5 = "哈哈_呵呵_嘻嘻_噢no";
        String[] ss = str5.split("_");//切割
        System.out.println(ss[0]);//哈哈
        System.out.println(ss[1]);//呵呵
        System.out.println(ss[2]);//嘻嘻
        System.out.println(ss[3]);//噢no

        String str6 = "今天天气不错";
        System.out.println(str6.substring(2,4));//天气 字符串截取 [ ) 左闭右开，右边取不到

        String str7 ="     哈    哈      ";
        System.out.println(str7.trim());//哈    哈, 去掉左右两边的空格


        int i = 10;
        System.out.println(String.valueOf(i)); // 基本数据类型转为字符串
        System.out.println(i+""); // 野路子

        System.out.println(String.valueOf(1.25f));
        System.out.println(String.valueOf('c'));
    }
}
