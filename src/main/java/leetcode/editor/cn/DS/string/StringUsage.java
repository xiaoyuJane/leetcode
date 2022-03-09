package leetcode.editor.cn.DS.string;

public class StringUsage {
    public static void main(String[] args) {
        String s = "this is a good    example     a";
        System.out.println(s.length()); //29
        System.out.println(s.charAt(0)); //t
        System.out.println("1:"+ s.charAt(s.length()-1)); //a

        //字符串中是否包含某一个字串
        System.out.println(s.contains("is")); //true
        //indexOf(str)既可以判断是否包含子串，又可以获取该子串出现的位置。
        if(s.indexOf("a")!=-1) System.out.println("a is ");
        System.out.println(s.indexOf('o'));
        System.out.println(s.indexOf('o',2));

//        boolean isEmpty():原理就是判断字符串长度是否为0。
//        boolean startsWith(str);
//        boolean endsWith(str);
//        boolean equals(str);  //判断字符串内容是否相同

//        boolean equalsIgnoreCase(); //忽略大小写，判断内容是否相同

//        int indexOf(char ch):返回的是ch在字符串中第一次出现的位置。
//        int indexOf(char ch,int fromIndex):从formIndex指定位置开始，获取ch在字符串中出现的位置。
//        int indexOf(String str):返回的是str在字符串中第一次出现的位置。
//        int indexOf(String str,int fromIndex)：从fromIndex指定位置开始，获取str在字符串中出现的位置。
//        同样规则的还有lastIndexOf系列函数，不过它与indexOf函数取值方向相反，它是在字符串后边开始。

        char[] ss = s.toCharArray();  //将字符串转成字符数组
//        String toUpperCase();    // 大写
//        String toLowerCase();    // 小写
//        String substring(begin)：从指定位置开始到结尾 如果角标不存在，会出现字符串角标越界异常。
//        String substring(begin,end):包含开头，不含结尾。
//        String replace(oldchar,newchar);如果要替换的字符不存在，返回的还是原串。

    }


}
