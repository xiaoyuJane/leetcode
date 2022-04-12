package leetcode.editor.cn.DS.string;

public class StringBufferTest {
    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer();

        sb.append("hello ").append("world ").append("java");
        System.out.println(sb); //hello world java

        sb.insert(5,',');
        System.out.println(sb); //hello,world java

        sb.deleteCharAt(5);
        System.out.println(sb);

        sb.setCharAt(6,',');
        System.out.println(sb); //hello,,world java

        //删除指定位置的字符
        sb.deleteCharAt(1);
        System.out.println(sb); //hllo world java

        sb.delete(5,10); //含左不含右
        System.out.println(sb);  //hllo  java

        //含左不含右
        sb.delete(0,sb.length()); //删除所有
        System.out.println(sb);   //无


        String s = "aabaa";
        System.out.println(s.substring(1,3)); //起始位置和结束位置

    }

}
