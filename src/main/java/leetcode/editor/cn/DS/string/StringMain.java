package leetcode.editor.cn.DS.string;


/**
 * jav中字符串是不可变的
 * 如果你确实希望你的字符串是可变的，则可以使用 toCharArray 将其转换为字符数组。
 * 如果你经常必须连接字符串，最好使用一些其他的数据结构，如 StringBuilder 。
 * 字符串直接赋值和new对象存在区别，后者会比前者多创建一个对象，一般建议使用字符串直接赋值
 */
public class StringMain {
    public static void main(String[] args) {
        // initialize
        String s1 = "Hello World";
        System.out.println("s1 is \"" + s1 + "\"");
        String s2 = s1;
        System.out.println("s2 is another reference to s1.");
        String s3 = new String(s1);
        System.out.println("s3 is a copy of s1.");

        // compare using '=='
        System.out.println("Compared by '==':");
        // true since string is immutable and s1 is binded to "Hello World"
        System.out.println("s1 and \"Hello World\": " + (s1 == "Hello World"));

        // true since s1 and s2 is the reference of the same object
        System.out.println("s1 and s2: " + (s1 == s2));


        // false since s3 is refered to another new object
        System.out.println("s1 and s3: " + (s1 == s3));

        // compare using 'equals'
        System.out.println("Compared by 'equals':");
        System.out.println("s1 and \"Hello World\": " + s1.equals("Hello World"));
        System.out.println("s1 and s2: " + s1.equals(s2));
        System.out.println("s1 and s3: " + s1.equals(s3));

        // compare using 'compareTo'
        System.out.println("Compared by 'compareTo':");
        System.out.println("s1 and \"Hello World\": " + (s1.compareTo("Hello World") == 0));
        System.out.println("s1 and s2: " + (s1.compareTo(s2) == 0));
        System.out.println("s1 and s3: " + (s1.compareTo(s3) == 0));

        //字符串反转，需要借助于StringBuffer的反转功能
        String string="runoob";
        String reverse = new StringBuffer(string).reverse().toString();
        System.out.println("字符串反转前:"+string);
        System.out.println("字符串反转后:"+reverse);
    }


}
