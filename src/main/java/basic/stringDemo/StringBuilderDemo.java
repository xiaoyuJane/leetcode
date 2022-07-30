package basic.stringDemo;

public class StringBuilderDemo {
    public static void main(String[] args) {
        test();
    }

    /**
     * // 下述操作都可以将StringBuilder换成StringBuffer，结果一样
     */
    public static void test(){
        // 一个空的字符串""
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder("猫喜欢吃鱼");
        System.out.println(sb2);// 猫喜欢吃鱼

        //可追加，无需新建变量来接收
        sb2.append("，狗也喜欢吃鱼");
        System.out.println(sb2);//  猫喜欢吃鱼，狗也喜欢吃鱼

        sb2.insert(1,"哈哈哈");
        System.out.println(sb2); //猫哈哈哈喜欢吃鱼，狗也喜欢吃鱼


        String s = sb2.toString();
        System.out.println(s); //猫哈哈哈喜欢吃鱼，狗也喜欢吃鱼

    }
}
